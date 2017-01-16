package cn.tbnb1.after.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.tbnb1.model.User;
public interface UserDao  extends JpaRepository<User, Integer>{
	User findByUsername(String username);
	
}
