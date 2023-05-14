package teachmate.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teachmate.repository.UserRepository;
import teachmate.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean verifyUserCredentials(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);
        return userOptional.isPresent();
    }

}
