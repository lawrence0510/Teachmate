package teachmate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teachmate.model.User;
import teachmate.repository.UserRepository;

//在 service 中建立一個註冊用的方法，該方法將會使用 repository 來存儲用戶資訊。
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

	public User signinUser(User user) throws UserNotFoundException {
        String email = user.getEmail();
        String password = user.getPassword();
    
        User existingUser = userRepository.findByEmailAndPassword(email, password);
    
        if (existingUser == null) {
            throw new UserNotFoundException("User not found");
        }
        return existingUser;
	}
}
