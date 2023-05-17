import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import controller.LoginController;
import controller.RegisterController;
import controller.Router;

import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8000), 0);

        Router router = new Router();
        router.addRoute("/register", new RegisterController());
        router.addRoute("/login", new LoginController());

        server.createContext("/", router);

        server.start();

        System.out.println("Server started on port 8000");
    }
}