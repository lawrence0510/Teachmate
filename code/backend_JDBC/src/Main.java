import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import service.UserService;
import repository.MySQLRepository;
import model.User;
import controller.RegisterController;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8000), 0);

        server.createContext("/register", new RegisterController());
        server.start();

        System.out.println("Server started on port 8000");
    }
}