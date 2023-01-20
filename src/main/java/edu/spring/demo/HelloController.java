package edu.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;

@Controller
public class HelloController {
	
	@GetMapping("/")
	@ResponseBody
	public String helloAction(HttpSession session) {
		if(session.getAttribute("user") != null) {
			return "Bonjour " + session.getAttribute("user");
		}
		return "Hello world";
	}
	
	@GetMapping("/msg/{msg}")
	@ResponseBody
	public String msgAction(@PathVariable("msg") String msg) {
		return "message : " + msg;
	}
	
	@GetMapping("/view/{msg}")
	@ResponseBody
	public String withViewAction(@PathVariable("message") String msg) {
		return "/helloView";
	}
	
	@PostMapping("/submit")
	@ResponseBody
	public String submitAction(@ModelAttribute("login") String login, HttpSession session) {
		session.setAttribute("user", login);
		return "Vous etes connecté sous le nom " + login;
	}
}
