package cn.tbnb1.after.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;










import cn.tbnb1.after.Service.BolgTypeService;
import cn.tbnb1.after.Service.UserService;
import cn.tbnb1.model.BolgType;
import cn.tbnb1.model.User;

@Controller
@RequestMapping("/backstage")
public class UserController {

	@Autowired
	UserService uservice;
	@Autowired
	BolgTypeService bolgTypeService;
	
	@GetMapping("/wblog")
	public String wblog(Model model){
		Integer uid=1;
		List<BolgType> resBolgType = bolgTypeService.findBolgTypeByUid(uid);
		model.addAttribute("ListBolgType", resBolgType);
		return "Html/Blohg/wblog";
	}
	
	@GetMapping("/main")
	public String toPage(Model model,HttpServletRequest request) {
		String ServerName= request.getServerName();//获取服务器地址
		int ServerPort=request.getServerPort();//服务的端口
		String remoteHost = request.getRemoteHost();//客户端主机名
	//	model.addAttribute("name", name);
		return "Html/Blohg/main";
		
	}
	
	/**
	 * 
	* @Title: uploadimage 
	* @Description: 上传图片
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/uploadimage")
	public String uploadimage(){
		return null;
		
	}
	
	@RequestMapping("/loginpage")
	public String loginPage(Model model) {
		return "admin/login";
	}
	@PostMapping("/login")
	public  String loginUser(Model model, User user,
			HttpServletRequest request) {
		if (user == null) {
			return "false";
		}
		String Msg = null;
		User u = uservice.findByUsername(user.getUsername());
		if (u == null) {
			Msg = "当前用户不存在";
			return "false";
		}
		try {
			if (!Md5Crypt.apr1Crypt(user.getPassword(),user.getSalt()).equals(u.getPassword())) {
				Msg = "账号或者密码错误";
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/backstage/admin";

	}

	
	
	/**
	 * 
	* @Title: toIndex 
	* @Description:后台主页 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@GetMapping("/admin")
	public String toIndex(Model model){
		//TODO 需要 从redis中取一次数据，判断该用户有没有存在不存在就直接回到login
		
		return "Html/Blohg/index";
		
	}
	
	
}
