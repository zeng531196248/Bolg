package cn.tbnb1.after.controller;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tbnb1.after.Service.UserService;
import cn.tbnb1.model.User;

@Controller("/after")
public class UserController {
	
	@Autowired
	UserService uservice;
	@PostMapping("/login")
	public @ResponseBody boolean loginUser(Model model ,User user ,HttpServletRequest request) {
		if(user==null){
			return false;
		}
		String Msg=null;
		User u = uservice.findByUsername(user.getUsername());
		if(u.getStatus()!=1 ||u==null){
			Msg="当前用户不存在";
		}
		return false;
		
	}
	
	
	
}
