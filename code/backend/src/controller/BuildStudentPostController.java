package controller;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import model.Post;
import repository.MySQLRepository;
import service.UserService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class BuildStudentPostController implements HttpHandler {
    private UserService userService;
    private MySQLRepository repository;

    public BuildStudentPostController() {
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
                String region = jsonObject.get("region").getAsString();
                String major = jsonObject.get("major").getAsString();
                String note = jsonObject.get("note").getAsString();
                int userID = jsonObject.get("userID").getAsInt();
                Post post = new Post();
                post.setPostSubject(subject);
                post.setPostRegion(region);
                post.setPostMajor(major);
                post.setPostContent(note);
                post.setP_UserID(userID);
                int postID = generatePostID();
                post.setP_ID(postID);

                // Attempt to build the contract
                boolean buildSuccess = userService.buildStudentPost(post, repository);

                if (buildSuccess) {
                    String responseMessage = "Build student post successfully!";
                    sendResponse(exchange, 200, responseMessage);
                } else {
                    String responseMessage = "Error occurred during student post build.";
                    sendResponse(exchange, 500, responseMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
                String responseMessage = "Error occurred during student post build.";
                sendResponse(exchange, 500, responseMessage);
            }
        } else {
            String responseMessage = "Invalid request method.";
            sendResponse(exchange, 405, responseMessage);
        }
    }

    private int generatePostID() {
        int min = 1;
        int max = Integer.MAX_VALUE;
        int P_ID;

        do {
            P_ID = (int) (min + Math.random() * (max - min + 1));
        } while (userService.isPostIDExists(P_ID, repository));

        return P_ID;
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
