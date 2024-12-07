package com.demo_bank_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo_bank_v2.repository.UserRepository;

@Controller
public class WelcomePage {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	
	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}
	
	@GetMapping("/error")
	public String getError(ModelMap map) {
		map.put("PageTitle", "Errors");
		return "error";
	}
	
	@GetMapping("/verify")
	public String getVerify(@RequestParam("token") String token, @RequestParam("code") String code, ModelMap map) {
		String dbToken = userRepository.checkToken(token);
		if(dbToken == null) {
			map.put("error", "This Session Has Expired");
			return "error";
		}
		
		userRepository.verifyAccount(token, code); 
		map.put("success", "Account verified Successfully, Please proceed to Log In");
		return "login";
	}
	
}
