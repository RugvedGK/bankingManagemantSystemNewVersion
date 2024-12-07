package com.demo_bank_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo_bank_v2.helper.Token;
import com.demo_bank_v2.models.User;
import com.demo_bank_v2.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/login")
	public String getLogin(ModelMap map) {
		String token = Token.generateToken();
		map.put("token", token);
		map.put("PageTitle", "Login");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email, 
						@RequestParam("password")String password, 
						@RequestParam("_token")String token, ModelMap map, HttpSession session) {
		if(email.isEmpty() || email == null || password.isEmpty() || password == null) {
			map.put("error", "Username or Password Cannot be Empty");
			return "login";
		}
		
		String getEmaiInDatabase = userRepository.getUserEmail(email);
		
		if(getEmaiInDatabase != null) {
			String getPasswordInDatabase = userRepository.getUserPassword(getEmaiInDatabase);
			
			if(!BCrypt.checkpw(password, getPasswordInDatabase)) {
				map.put("error", "Incorrect Username or Password");
				return "login";
			}
		}else {
			map.put("error", "Something went worng please contect support");
			return "error";	
		}
		
		int verified = userRepository.isVerified(getEmaiInDatabase);
		if(verified != 1) {
			map.put("error", "This Account is not yet Verified, please check email and verify account");
			return "login";
		}
		User user = userRepository.getUserDetails(getEmaiInDatabase);
		
		session.setAttribute("user", user);
		session.setAttribute(token, token);
		session.setAttribute("authenticated", true);
		
		return "redirect:/app/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("logged_out", "Logged Out Successfully");
		return "redirect:/login";
	}
}
