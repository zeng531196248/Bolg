package cn.tbnb1.after.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("bolgTypesize", bolgTypeByUid.size());
		return "Html/Blohg/addblogtype";
		
	}
	
	/**
	 * 
	* @Title: showaddblogtype 
	* @Description: 添加博客类型页面跳转
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@GetMapping("/backstage/bolg-add")
	public String showaddblogtype(){
		return "Html/Blohg/bolg-add";
		
	}
	
	
	@GetMapping("/backstage/bolg-eddit/{id}")
	public String edditBolgTypePage(@PathVariable("id")Integer id,HttpServletRequest request,Model model){
		User user=(User)request.getSession().getAttribute("loginUser");
		BolgType resbolgType = bolgTypeService.findBolgTypeByUidAndId(user.getId(),id);
		model.addAttribute("bolgType", resbolgType);
		return "Html/Blohg/bolg-eddit";
	}
	
	
	
	
	
	
	
	/**
	 * 
	* @Title: deletType 
	* @Description: 删除博客类型
	* @param @param id
	* @param @return    设定文件 
	* @return ResponseEntity<Void>    返回类型 
	* @throws
	 */
	
	@DeleteMapping("/backstage/delettype")
	public  ResponseEntity<Void>deletType(@RequestParam(required=false)Integer id,HttpServletRequest request){
		try {
			User user=(User)request.getSession().getAttribute("loginUser");
			int res = bolgTypeService.deletByIdAndUid(user.getId(),id);
			if(res>0){
				return ResponseEntity.status(HttpStatus.CREATED).build();//201
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//500
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();//400
		
	}
	
	/**
	 * 
	* @Title: deletType 
	* @Description: 批量删除
	* @param @param ids
	* @param @param request
	* @param @return    设定文件 
	* @return ResponseEntity<Void>    返回类型 
	* @throws
	 */
	@DeleteMapping("/backstage/deletbatch")
	public  ResponseEntity<Void>deletType(@RequestParam(required=false)Integer[] ids,HttpServletRequest request){
		try {
			User user=(User)request.getSession().getAttribute("loginUser");
			for (int i = 0; i < ids.length; i++) {
				bolgTypeService.deletByIdAndUid(user.getId(),ids[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//500
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();//201
	}
	
	
	/**
	 * 
	* @Title: addtype 
	* @Description: 添加博客类型
	* @param @param bolgType
	* @param @param request
	* @param @return    设定文件 
	* @return ResponseEntity<Void>    返回类型 
	* @throws
	 */
	@PostMapping("/backstage/addtype")
	public  ResponseEntity<Void>addtype(BolgType bolgType,HttpServletRequest request){
		try {
			bolgType.setId(null);
			bolgType.setUpdateTime(new Date());
			bolgType.setIsDisplay("0");
			User user=(User)request.getSession().getAttribute("loginUser");
			bolgType.setUid(user.getId());
			bolgType.setCreatTime(bolgType.getUpdateTime());
			BolgType restype = bolgTypeService.save(bolgType);
			System.out.println(restype);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//500
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();//201
	}
	
}
