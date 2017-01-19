package cn.tbnb1.after.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tbnb1.model.Children;

@Controller
@RequestMapping("/navs")
public class NavsTabController {

	/**
	 * 
	* @Title: navs 
	* @Description: 侧导航加载
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@PostMapping("/")
	public String navs(Children children) {
		
		return null;
		
	}
	
	
	
}
