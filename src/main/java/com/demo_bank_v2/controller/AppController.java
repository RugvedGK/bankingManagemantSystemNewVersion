package com.demo_bank_v2.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo_bank_v2.models.Accounts;
import com.demo_bank_v2.models.User;
import com.demo_bank_v2.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/app")
public class AppController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/dashboard")
	public String getDashboard(HttpSession session, ModelMap map) {
		User user = (User)session.getAttribute("user");
		List<Accounts> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());
		BigDecimal totalAccountDecimal = accountRepository.getTotalBalance(user.getUser_id());
		map.put("userAccounts", getUserAccounts);
		map.put("totalBalance", totalAccountDecimal);
		return "dashboard";
	}
}
