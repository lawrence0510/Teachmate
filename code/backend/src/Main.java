import com.sun.net.httpserver.HttpServer;
import controller.LoginController;
import controller.RegisterController;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8000), 0);

        server.createContext("/register", new RegisterController());
        server.createContext("/signin", new LoginController());
        server.start();

        System.out.println("Server started on port 8000");
    }
}