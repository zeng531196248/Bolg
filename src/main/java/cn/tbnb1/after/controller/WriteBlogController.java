package cn.tbnb1.after.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import cn.tbnb1.after.Service.BlogService;
import cn.tbnb1.model.Blog;
import cn.tbnb1.model.User;

@Controller
public class WriteBlogController {
	
	@Autowired
	BlogService blogService;
	
	@PostMapping("backstage/writeblog")
	public ResponseEntity<Void> writeBlog(HttpServletRequest request,Model model,Blog blog){
		try {
			if(blog==null){
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//500
			}
			User user=(User) request.getSession().getAttribute("loginUser");
			if(user!=null){
				blog.setUid(user.getId());
				blog.setAuthor(user.getNickname());
			}
			Integer i=blogService.save(blog);
			if(i>0){
				return ResponseEntity.status(HttpStatus.CREATED).build();//201
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
}
