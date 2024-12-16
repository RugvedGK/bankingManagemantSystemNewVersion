package com.demo_bank_v2.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo_bank_v2.models.Accounts;
import com.demo_bank_v2.models.PaymentHistory;
import com.demo_bank_v2.models.TransactionHistory;
import com.demo_bank_v2.models.User;
import com.demo_bank_v2.repository.AccountRepository;
import com.demo_bank_v2.repository.PaymentHistoryRepository;
import com.demo_bank_v2.repository.TransactHistoryRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.UserTransaction;

@Controller
@RequestMapping("/app")
public class AppController {
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PaymentHistoryRepository paymentHistoryRepository;
	
	@Autowired
	private TransactHistoryRepository transactHistoryRepository;
	
	User user;
	
	@GetMapping("/dashboard")
	public String getDashboard(HttpSession session, ModelMap map) {
		User user = (User)session.getAttribute("user");
		List<Accounts> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());
		BigDecimal totalAccountDecimal = accountRepository.getTotalBalance(user.getUser_id());
		map.put("userAccounts", getUserAccounts);
		map.put("totalBalance", totalAccountDecimal);
		return "dashboard";
	}
	
	@GetMapping("/paymentHistory")
	public String getPaymentHistory(HttpSession session, ModelMap map) {
		
		user = (User)session.getAttribute("user");
		
		List<PaymentHistory> userPaymentHistory = paymentHistoryRepository.getPaymentRecordsById(user.getUser_id());
		
		map.put("payment_history", userPaymentHistory);
		
		return "paymentHistory";
	}
	
	@GetMapping("/transactionHistory")
	public String getTransactHistory(HttpSession session, ModelMap map) {
		
		user = (User)session.getAttribute("user");
		
		List<TransactionHistory> userTransactHistory = transactHistoryRepository.getTransactRecordsById(user.getUser_id());
		
		map.put("transaction_history", userTransactHistory);
		
		return "transactHistory";
	}
}
