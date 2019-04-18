package cn.tbnb1.after.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BigPicController {

	
	@GetMapping("/backstage/bigpic")
	public String ToBigPic(HttpServletRequest request,Model model){
		
		return "Html/Blohg/bigpic";
	}
	
	
	
	@GetMapping("/backstage/banner-add")
	public String ToBigPicAndbanneradd(HttpServletRequest request,Model model){
		
		return "Html/Blohg/banner-add";
	}
	
	@GetMapping("/backstage/banner-edit")
	public String ToBigPicAnd(HttpServletRequest request,Model model){
		
		return "Html/Blohg/banner-edit";
	}
	
	
	
	
}
