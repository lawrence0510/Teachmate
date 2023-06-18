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
import java.util.Map;

public class GetPostController implements HttpHandler {
    private UserService userService;
    private MySQLRepository repository;

    public GetPostController() {
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
                
                // Parse the JSON request body
                Gson gson = new Gson();
                
                // Call the UserService method to filter teachers by criteria
                List<Map<String, Object>> PostsData = userService.getPostsData(repository);
                if (PostsData != null) {
                    // Convert the filtered posts to JSON and send as the response
                    String jsonResponse = gson.toJson(PostsData);
                    sendResponse(exchange, 200, jsonResponse);
                } else {
                    String responseMessage = "Error occurred during getting student's information.";
                    sendResponse(exchange, 500, responseMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
                String responseMessage = "Error occurred getting student's information.";
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
