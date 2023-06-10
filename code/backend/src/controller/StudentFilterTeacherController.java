package controller;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import model.Post;
import repository.MySQLRepository;
import service.UserService;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class StudentFilterTeacherController implements HttpHandler {
    private UserService userService;
    private MySQLRepository repository;

    public StudentFilterTeacherController() {
        userService = new UserService();
        repository = new MySQLRepository();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            // Handle OPTIONS request
            handleOptionsRequest(exchange);
        } else if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            try {
                Headers headers = exchange.getResponseHeaders();
                headers.add("Access-Control-Allow-Origin", "http://localhost:8080");
                headers.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
                headers.add("Access-Control-Allow-Headers", "Content-Type");

                // Read the request body
                InputStream requestBody = exchange.getRequestBody();
                byte[] requestBodyBytes = requestBody.readAllBytes();
                String requestBodyString = new String(requestBodyBytes, StandardCharsets.UTF_8);

                // Parse the JSON request body
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(requestBodyString, JsonObject.class);
                String subject = jsonObject.get("subject").getAsString();
                String gender = jsonObject.get("gender").getAsString();
                String mbti = jsonObject.get("mbti").getAsString();
                String region = jsonObject.get("region").getAsString();

                // Call the UserService method to filter teachers by criteria
                List<Post> filteredPosts = userService.filterTeachersByCriteria(subject, gender, mbti, region, repository);
                if (filteredPosts != null) {
                    // Convert the filtered posts to JSON and send as the response
                    String jsonResponse = gson.toJson(filteredPosts);
                    sendResponse(exchange, 200, jsonResponse);
                } else {
                    String responseMessage = "Error occurred during filtering teachers' posts.";
                    sendResponse(exchange, 500, responseMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
                String responseMessage = "Error occurred during filtering teachers' posts.";
                sendResponse(exchange, 500, responseMessage);
            }
        } else {
            String responseMessage = "Invalid request method.";
            sendResponse(exchange, 405, responseMessage);
        }
    }


    private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private void handleOptionsRequest(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:8080");
        headers.add("Access-Control-Allow-Methods", "POST");
        headers.add("Access-Control-Allow-Headers", "Content-Type");
        sendResponse(exchange, 200, "");
    }
}
