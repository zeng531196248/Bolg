package cn.tbnb1.after.Service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tbnb1.after.Dao.UserDao;
import cn.tbnb1.after.Service.UserService;
import cn.tbnb1.model.BolgType;
import cn.tbnb1.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired 
	public	UserDao userdao;
	@Override
	public User findByUsername(String username) {
		return  userdao. findByUsername( username);
	}

}
