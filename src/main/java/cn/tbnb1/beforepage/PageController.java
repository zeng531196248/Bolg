package cn.tbnb1.beforepage;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	@GetMapping("/{page}")
	public String toPage(@PathVariable String page,HttpServletRequest request) {
		return "/beforepag/"+page;
	}
}
