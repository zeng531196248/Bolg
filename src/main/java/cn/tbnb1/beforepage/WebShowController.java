package cn.tbnb1.beforepage;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class WebShowController {
	@RequestMapping(value={"", "/"}, method= RequestMethod.GET)
	public String toPageIndex(Model model,HttpServletRequest request ) {
		return "/beforepag/lw-index-nosidebar";
	}
}