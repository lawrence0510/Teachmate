package controller;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import model.User;
import repository.MySQLRepository;
import service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LoginController implements HttpHandler {
    private UserService userService;
    private MySQLRepository repository;

    public LoginController() {
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
                headers.add("Access-Control-Allow-Methods", "POST");
                headers.add("Access-Control-Allow-Headers", "Content-Type");
                // Read the request body
                InputStream requestBody = exchange.getRequestBody();
                byte[] requestBodyBytes = requestBody.readAllBytes();
                String requestBodyString = new String(requestBodyBytes, StandardCharsets.UTF_8);

                // Parse the JSON request body
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(requestBodyString, JsonObject.class);
                String email = jsonObject.get("email").getAsString();
                String password = jsonObject.get("password").getAsString();

                // Create a User object
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);

                // Authenticate the user
                boolean isAuthenticated = userService.loginUser(user, repository);

                if (isAuthenticated) {
                    // User authentication successful
                    String responseMessage = "Logged in successfully!";
                    sendResponse(exchange, 200, responseMessage);
                } else {
                    // User authentication failed
                    String responseMessage = "Unsuccessful log in!";
                    sendResponse(exchange, 401, responseMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
                String responseMessage = "Error occurred during login.";
                sendResponse(exchange, 500, responseMessage);
            }
        } else {
            // Invalid HTTP method
            String responseMessage = "Invalid request method.";
            sendResponse(exchange, 405, responseMessage);
        }
    }

    private void handleOptionsRequest(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:8080");
        headers.add("Access-Control-Allow-Methods", "POST");
        headers.add("Access-Control-Allow-Headers", "Content-Type");
        sendResponse(exchange, 200, "");
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
}
