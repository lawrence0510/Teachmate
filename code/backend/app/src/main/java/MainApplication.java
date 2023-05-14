import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import teachmate.service.UserService;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

        UserService userService = context.getBean(UserService.class);

        String email = "john@gmail.com";
        String password = "12345";

        boolean isValidCredentials = userService.verifyUserCredentials(email, password);

        if (isValidCredentials) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid email or password");
        }

        context.close();
    }
}
