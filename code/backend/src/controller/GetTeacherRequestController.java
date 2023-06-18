package controller;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import repository.MySQLRepository;
import service.UserService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GetTeacherRequestController implements HttpHandler {
    private UserService userService;
    private MySQLRepository repository;

    public GetTeacherRequestController() {
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
                String studentname = jsonObject.get("studentname").getAsString();
                String teachername = jsonObject.get("props").getAsJsonObject().get("username").getAsString();

                boolean saveTeacherRequestInfoSuccess = userService.saveTeacherRequestInfo(teachername, studentname,repository);
                if (saveTeacherRequestInfoSuccess) {
                    String responseMessage = "Save request successfully!";
                    sendResponse(exchange, 200, responseMessage);
                } else {
                    String responseMessage = "Error occurred during saving request.";
                    sendResponse(exchange, 500, responseMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
                String responseMessage = "Error occurred during saving request.";
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
