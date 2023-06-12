import com.sun.net.httpserver.HttpServer;

import controller.BuildContractController;
import controller.BuildStudentPostController;
import controller.BuildTeacherPostController;
import controller.ContractGradeCommentController;
import controller.GetStudentController;
import controller.LoginController;
import controller.RegisterController;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8000), 0);
        //1.path接收post，連到controller
        server.createContext("/register", new RegisterController()); //ok
        server.createContext("/signin", new LoginController()); //ok
        server.createContext("/buildcontract", new BuildContractController()); //ok
        server.createContext("/contractgradecomment", new ContractGradeCommentController());
        server.createContext("/buildteacherpost", new BuildTeacherPostController());
        server.createContext("/buildstudentpost", new BuildStudentPostController());
        server.createContext("/getstudentinfo", new GetStudentController());
        server.start();

        System.out.println("Server started on port 8000");
    }
}