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
import java.sql.SQLException;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysql.jdbc.PreparedStatement;


public class RegisterController implements HttpHandler {
    private UserService userService;
    private MySQLRepository repository;

    public RegisterController() {
        userService = new UserService();
        repository = new MySQLRepository();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            handleOptionsRequest(exchange);
        }
        else if ("POST".equals(exchange.getRequestMethod())) {
            String requestBody = getRequestData(exchange);

            User user = parseUserFromRequest(requestBody);

            userService.saveUser(user, repository);
            
            String response = "User saved";
            sendResponse(exchange, response, 200);
        } else {
            String response = "Not support";
            sendResponse(exchange, response, 405);
        }
    }

    private String getRequestData(HttpExchange exchange) throws IOException {
        InputStream requestBody = exchange.getRequestBody();
        byte[] buffer = new byte[1024];
        int bytesRead;
        StringBuilder requestData = new StringBuilder();
        while ((bytesRead = requestBody.read(buffer)) != -1) {
            requestData.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
        }
        requestBody.close();
        return requestData.toString();
    }

    private User parseUserFromRequest(String requestBody) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(requestBody, JsonObject.class);
        String name = jsonObject.get("name").getAsString();
        String email = jsonObject.get("email").getAsString();
        String password = jsonObject.get("password").getAsString();
        int age = jsonObject.get("age").getAsInt();
        String gender = jsonObject.get("gender").getAsString();
        String school = jsonObject.get("school").getAsString();
        String region = jsonObject.get("region").getAsString();
        String major = jsonObject.get("major").getAsString();
        String phoneNumber = jsonObject.get("phoneNumber").getAsString();
        String mbti = jsonObject.get("mbti").getAsString();
        long userID = generateUserID();

        User user = new User();
        user.setUserID(userID);
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAge(age);
        user.setGender(gender);
        user.setSchool(school);
        user.setRegion(region);
        user.setMajor(major);
        user.setPhoneNum(phoneNumber);
        user.setMBTI(mbti);
        
        return user;
    }
    private void sendResponse(HttpExchange exchange, String response, int statusCode) throws IOException {
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
    
    private int generateUserID() {
        int min = 1; // 最小值
        int max = Integer.MAX_VALUE; // 最大值
        int userID;
    
        // 生成隨機數，如果重複則重新生成直到不重複
        do {
            userID = (int) (min + Math.random() * (max - min + 1));
        } while (userService.isUserIDExists(userID, repository));
    
        return userID;
    } 

    private void handleOptionsRequest(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:8080");
        headers.add("Access-Control-Allow-Methods", "POST");
        headers.add("Access-Control-Allow-Headers", "Content-Type");
        sendResponse(exchange, "", 200);
    }
}

