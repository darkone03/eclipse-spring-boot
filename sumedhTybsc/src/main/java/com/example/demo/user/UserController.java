package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String getReString() {
		return "register";
	}
	
	
	@PostMapping("/register")
	public void getNewUser(@RequestParam("input1") String input1,@RequestParam("input2") String input2 ,Model model) {
		if(userService.isUserPresent(input1)) {
			model.addAttribute("result","user already exists");
		}else {
			userService.userAdd(input1, input2);
			model.addAttribute("result","user created");
		}
		
		//		if(userService.userAdd(input1, input2)) {
//			model.addAttribute("result","user created");
//		}else {
//			model.addAttribute("result","user already exists");
//		}
	}
}
