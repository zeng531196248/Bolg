package cn.tbnb1.after.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tbnb1.after.Service.BolgService;
import cn.tbnb1.model.Blog;
import cn.tbnb1.model.User;
import cn.tbnb1.viewModel.Data;


@Controller
public class BolgListController {
	
	@Autowired
	private BolgService bolgService;
	
	
	
	
	/**
	 * 
	* @Title: showBolgList 
	* @Description: 跳转到博客显示页面
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@GetMapping("/backstage/articlelist")
	public String showBolgList(){
		return"Html/Blohg/articlelist" ;
	}
	
	
	@GetMapping("/backstage/showarticlelist")
	@ResponseBody
	public Data showarticlelist(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("loginUser");
		List<Blog> resdata=bolgService.findBlogByUid(user.getId());
		Data data=new Data();
		data.setData(resdata);
		return data ;
	}
	
	
	
}
