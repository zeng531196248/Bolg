package cn.tbnb1.after.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tbnb1.after.Service.BigPicService;
import cn.tbnb1.model.Page;
import cn.tbnb1.model.User;

@Controller
public class BigPicController {

	
	@Autowired
	private BigPicService bigPicService;
	
	
	@GetMapping("/backstage/bigpic")
	public String ToBigPic(HttpServletRequest request,Model model){
		User user=(User)request.getSession().getAttribute("loginUser");
		List<Page> pageList=bigPicService.findByUid(user.getId());
		model.addAttribute("pageList", pageList);
		return "Html/Blohg/bigpic";
	}
	
	
	
	@GetMapping("/backstage/banner-add")
	public String ToBigPicAndbanneradd(HttpServletRequest request,Model model,Page page){
		if(page.getId()!=null){
			 page=bigPicService.findById(page.getId());
			 model.addAttribute("page", page);
		}
		
		return "Html/Blohg/banner-add";
	}
	
	@DeleteMapping("/backstage/deletbigpic")
	public ResponseEntity<Void> deletbigpic(HttpServletRequest request,Model model,Integer id){
		try {
			bigPicService.deletOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/backstage/banner-edit")
	public String ToBigPicAnd(HttpServletRequest request,Model model){
		
		return "Html/Blohg/banner-edit";
	}
	
	
	@PostMapping("/backstage/savebigpic")
	public ResponseEntity<Void> saveBigpic(HttpServletRequest request,Page bigpage){
		User user=(User)request.getSession().getAttribute("loginUser");
		if(bigpage.getId()==null){
			bigpage.setUid(user.getId());
			Integer i=bigPicService.save(bigpage);
			if(i==null){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}else {
			bigpage.setUid(user.getId());
			bigPicService.updataPage(bigpage);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping("/backstage/updatePageState")
	public ResponseEntity<Void> updataState(HttpServletRequest request,@RequestParam(value="id", required=true) Integer id){
		bigPicService.updataPageState(id);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
	
	
	
	
	
}
