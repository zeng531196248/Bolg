package cn.tbnb1.after.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cn.tbnb1.after.Service.BolgTypeService;
import cn.tbnb1.model.BolgType;
import cn.tbnb1.model.User;

@Controller
public class BlogTypeController {

	
	@Autowired
	private BolgTypeService bolgTypeService;
	
	
	/**
	 * 
	* @Title: addblogtype 
	* @Description: 博客类型展示
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@GetMapping("/backstage/addblogtype")
	public String addblogtype(HttpServletRequest request,Model model){
		User user=(User)request.getSession().getAttribute("loginUser");
		if(user==null){
			return "redirect:/backstage/loginpage";
		}
		List<BolgType> bolgTypeByUid = bolgTypeService.findBolgTypeByUid(user.getId());
		model.addAttribute("BolgTypeList", bolgTypeByUid);
		return "Html/Blohg/addblogtype";
		
	}
	@GetMapping("/backstage/bolg-add")
	public String showaddblogtype(){
		return "Html/Blohg/bolg-add";
		
	}
	
	
}
