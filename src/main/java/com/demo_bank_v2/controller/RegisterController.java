package com.demo_bank_v2.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo_bank_v2.helper.HTML;
import com.demo_bank_v2.helper.Token;
import com.demo_bank_v2.mailMessanger.MailMassanger;
import com.demo_bank_v2.models.User;
import com.demo_bank_v2.repository.UserRepository;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@Controller
public class RegisterController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registerUser") User user,
            BindingResult result,
            @RequestParam("first_name") String first_name,
            @RequestParam("last_name") String last_name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirm_password") String confirm_password, ModelMap map) throws MessagingException {
		
		
		if (result.hasErrors() && confirm_password.isEmpty()) {
			map.put("confirm_pass", "The Confirm Field is required");
			return "register";
		}
		
		//TODO: CHECK FOR PASSWORD MATCH: 
		if(!password.equals(confirm_password)) {
			map.put("passwordMisMatch", "Password do not match");
			return "register";
		}
		
		//TODO: GET TOKEN STRING:
		String token = Token.generateToken();
		
		//TODO: GENERATE RANDOM CODE:
		Random random = new Random();
		int bound = 123;
		int code = bound * random.nextInt(bound);
		
		//TODO: GET EMAIL HTML BODY
		String emailBody =  HTML.htmlEmailTemplate(token, code);
		
		//TODO: HASH PASSWORD:
		String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());
		
		//TODO: REGISTER USER:
		userRepository.registerUser(first_name, last_name, email, hashed_password, token, code);
		
		//TODO: SEND EMAIL NOTIFICATION
		MailMassanger.htmlEmailMessanger("user1@starkindusties.com", email, "Verify Account", emailBody);
		
		//TODO: RETURN TO REGISTER PAGE:
		map.put("success", "Account Registered Successfully, Please Check Your Email and Verify Account");
		return "register";
	}
	
	

}
