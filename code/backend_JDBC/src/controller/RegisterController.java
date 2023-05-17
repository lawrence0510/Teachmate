package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import model.User;
import repository.MySQLRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class RegisterController implements HttpHandler {
    private MySQLRepository repository;

    public RegisterController(MySQLRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
			String username = extractParameter(exchange, "username");
			String password = extractParameter(exchange, "password");
			int age = Integer.parseInt(extractParameter(exchange, "age"));
			String gender = extractParameter(exchange, "gender");
			String school = extractParameter(exchange, "school");
			String region = extractParameter(exchange, "region");
			String major = extractParameter(exchange, "major");
			String phoneNum = extractParameter(exchange, "phoneNum");
			String email = extractParameter(exchange, "email");
			String mbti = extractParameter(exchange, "mbti");
            User user = new User(null, username, password, age, gender, school, region, major, phoneNum, email, mbti);
            repository.saveUser(user);

            String response = "Registration successful";
            sendResponse(exchange, 200, response);
        } else {
            String response = "Invalid request method";
            sendResponse(exchange, 400, response);
        }
    }

    private String extractParameter(HttpExchange exchange, String parameterName) {

        return "";
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.sendResponseHeaders(statusCode, response.getBytes(StandardCharsets.UTF_8).length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }
}
