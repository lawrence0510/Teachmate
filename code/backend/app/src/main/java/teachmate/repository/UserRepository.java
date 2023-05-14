package teachmate.repository;
//在 repository 中建立一個方法，用來將用戶資訊存儲到資料庫中。

import org.springframework.data.jpa.repository.JpaRepository;
import teachmate.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
}
