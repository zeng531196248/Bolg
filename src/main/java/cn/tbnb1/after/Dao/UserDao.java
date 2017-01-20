package cn.tbnb1.after.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.tbnb1.model.BolgType;
import cn.tbnb1.model.User;
public interface UserDao  extends JpaRepository<User, Integer>{
	User findByUsername(String username);

	
}
