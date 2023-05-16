package teachmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import teachmate.model.User;
import teachmate.service.UserNotFoundException;
import teachmate.service.UserService;

//在 controller 中建立一個 POST 請求的 API，並綁定到一個註冊的方法。
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<User> signinUser(@RequestBody User user) throws UserNotFoundException{
        User signinUser = userService.signinUser(user);
        return new ResponseEntity<>(signinUser, HttpStatus.CREATED);
    }
}
