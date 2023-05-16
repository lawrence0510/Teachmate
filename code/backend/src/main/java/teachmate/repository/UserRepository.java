package teachmate.repository;
//在 repository 中建立一個方法，用來將用戶資訊存儲到資料庫中。

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teachmate.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmailAndPassword(String email, String password);
}
