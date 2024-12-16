package com.demo_bank_v2.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo_bank_v2.models.User;
import com.demo_bank_v2.repository.AccountRepository;
import com.demo_bank_v2.repository.PaymentRepository;
import com.demo_bank_v2.repository.TransactRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/transact")
public class TransactController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private TransactRepository transactRepository;
	
	User user;
	double currentBalance;
	double newBalance;
	
	LocalDateTime currentDateTime = LocalDateTime.now();
	
	String errorMessage;
	String successMessage;

	@PostMapping("/deposit")
	public String depoiste(@RequestParam("deposite_amount")String depositeAmount,
							@RequestParam("account_id")String accountID,
							HttpSession session,
							RedirectAttributes redirectAttributes) {
		
		if(depositeAmount.isEmpty() || accountID.isEmpty()) {
			redirectAttributes.addFlashAttribute("error", "Deposite Amount and Account Depositing Cannot be Empty");
			return "redirect:/app/dashboard";
		}
		
		user = (User)session.getAttribute("user");
		int acc_id = Integer.parseInt(accountID);
		double depositeAmountValue = Double.parseDouble(depositeAmount);
		
		if(depositeAmountValue == 0) {
			redirectAttributes.addFlashAttribute("error", "Deposit Amount Cannot Be of 0 (Zero) Value");
			return "redirect:/app/dashboard";
		}
		
		currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);
		newBalance = currentBalance + depositeAmountValue;
		
		accountRepository.changeAccountBalanceById(newBalance, acc_id);
		currentDateTime = LocalDateTime.now();
		
		transactRepository.logTransaction(acc_id, "depoist", depositeAmountValue, "online", "success", "Deposit Transaction Successful", currentDateTime);
		
		redirectAttributes.addFlashAttribute("success", "Amount Deposited Successfully");
		return "redirect:/app/dashboard";
	}
	
	@PostMapping("/transfer")
	public String transfer(@RequestParam("transfer_from") String transfer_from, @RequestParam("transfer_to") String transfer_to, @RequestParam("transfer_amount") String transfer_amount, 
							HttpSession session, RedirectAttributes redirectAttributes) {
		if(transfer_from.isEmpty() || transfer_to.isEmpty() || transfer_amount.isEmpty()) {
			redirectAttributes.addFlashAttribute("error", "The account transfering from and to along with the amount cannot be empty");
			return "redirect:/app/dashboard"; 
		}
		
		int transferFromId = Integer.parseInt(transfer_from);
		int transferToId = Integer.parseInt(transfer_to);
		double transferAmount = Double.parseDouble(transfer_amount);
		
		if(transferFromId == transferToId) {
			redirectAttributes.addFlashAttribute("error", "Cannot Transfer Into the same Account, Please select the appropriate to perform transfer");
			return "redirect:/app/dashboard"; 
		}
		
		if(transferAmount == 0) {
			redirectAttributes.addFlashAttribute("error", "Cannot Transfer an amount of 0 (Zero) value, please enter a valule greater than 0 (Zero)");
			return "redirect:/app/dashboard";
		}
		
		
		user = (User)session.getAttribute("user");
		
		 double currentBalanceOfAccountTransferingFrom = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);
//		 currentDateTime = LocalDateTime.now();
		 
		 if(currentBalanceOfAccountTransferingFrom < transferAmount) {
				errorMessage = "You have insufficient Funds to perform this Transfer!";
				transactRepository.logTransaction(transferFromId, "transfer", transferAmount, "online", "failed", "Insufficient Funds", currentDateTime);
				redirectAttributes.addFlashAttribute("error", errorMessage);
				return "redirect:/app/dashboard";
			}
			
		 
		 double currentBalanceOfAccountTransferingTo = accountRepository.getAccountBalance(user.getUser_id(), transferToId);

		 
		double newBalanceOfAccountTransferingFrom = currentBalanceOfAccountTransferingFrom - transferAmount;
		
		double newBalanceOfAccountTransferingTo = currentBalanceOfAccountTransferingTo + transferAmount;
		
		accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferingFrom, transferFromId);
		
		accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferingTo, transferToId);
		
		transactRepository.logTransaction(transferFromId, "deposit", transferAmount, "online", "success", "Transfer Transaction Successful", currentDateTime);
		
		redirectAttributes.addFlashAttribute("success", "Amount Transfered Successfully");
		return "redirect:/app/dashboard";
		
	}
	
	
	@PostMapping("/withdraw")
	public String withdraw(@RequestParam("withdrawal_amount") String withdrawalAmount,
							@RequestParam("account_id") String accountID,
							HttpSession session, RedirectAttributes redirectAttributes) {
		
		String errorMessage;
		String successMessage;
		
		if(withdrawalAmount.isEmpty() || accountID.isEmpty()) {
			errorMessage = "Withdrawal Amount and Account Withdrawing from account cannot be empty";
			redirectAttributes.addFlashAttribute("error", errorMessage);
			return "redirect:/app/dashboard";
		}
		
		double withdrawal_amount = Double.parseDouble(withdrawalAmount);
		int account_id = Integer.parseInt(accountID);
		
		if(withdrawal_amount == 0){
			errorMessage = "Withdrawal Amount cannot be 0 (Zero) value, please enter a valule greater than 0 (Zero)";
			redirectAttributes.addFlashAttribute("error", errorMessage);
			return "redirect:/app/dashboard";
		}
		
		user = (User)session.getAttribute("user");
		
		currentBalance = accountRepository.getAccountBalance(user.getUser_id(), account_id);
		
		if(currentBalance < withdrawal_amount) {
			errorMessage = "You have insufficient Funds to perform this Transfer!";
			transactRepository.logTransaction(account_id, "withdrawal", withdrawal_amount, "online", "failed", "Insufficient Funds", currentDateTime);
			redirectAttributes.addFlashAttribute("error", errorMessage);
			return "redirect:/app/dashboard";
		}
		
		newBalance = currentBalance - withdrawal_amount;
		
		accountRepository.changeAccountBalanceById(newBalance, account_id);
		
		transactRepository.logTransaction(account_id, "Withdrawal", withdrawal_amount, "online", "success", "Withdrawal Transaction Successful", currentDateTime);
		
		successMessage = "Withdrawal Successful";
		redirectAttributes.addFlashAttribute("success", successMessage);
		return "redirect:/app/dashboard";
//		return "";
	}
	
	@PostMapping("/payment")
	public String payment(@RequestParam("beneficiary") String beneficiary,
			@RequestParam("beneficiary_acc_no") String beneficiary_acc_no,
			@RequestParam("account_id") String account_id,
			@RequestParam("reference") String reference,
			@RequestParam("payment_amount") String payment_amount, HttpSession session, RedirectAttributes redirectAttributes) {
		
		String errorMessage;
		String successMessage;
		
		
		if(beneficiary.isEmpty() || beneficiary_acc_no.isEmpty() || account_id.isEmpty() || payment_amount.isEmpty()){
			errorMessage = "Payment Amount cannot be 0 (Zero) value, please enter a valule greater than 0 (Zero)";
			redirectAttributes.addFlashAttribute("error", errorMessage);
			return "redirect:/app/dashboard";
		}
		
		
		
		int accountID = Integer.parseInt(account_id);
		double paymentAmount = Double.parseDouble(payment_amount);
		if(paymentAmount == 0) {
			errorMessage = "Beneficiary, Account Number Account Paying From and Payment Amount Cannot be Empty!";
			redirectAttributes.addFlashAttribute("error", errorMessage);
			return "redirect:/app/dashboard";
		}
		user = (User)session.getAttribute("user");
		currentBalance = accountRepository.getAccountBalance(user.getUser_id(), accountID);
		
		if(currentBalance < paymentAmount) {
			errorMessage = "You have insufficient Funds to perform this payment";
			String reasonCode = "Could not Process Payment due to insufficient funds!";
			paymentRepository.makePayment(accountID, beneficiary, beneficiary_acc_no, paymentAmount, reference, "failed", reasonCode, currentDateTime);
			transactRepository.logTransaction(accountID, "Payment", paymentAmount, "online", "failed", "Insufficient Funds", currentDateTime);
			redirectAttributes.addFlashAttribute("error", errorMessage);
			return "redirect:/app/dashboard";
		}
		
		newBalance = currentBalance - paymentAmount;
		
		String reasonCode = "Payment Processed Successfully";
		LocalDateTime currentDateTime = LocalDateTime.now();
		paymentRepository.makePayment(accountID, beneficiary, beneficiary_acc_no, paymentAmount, reference, "success", reasonCode, currentDateTime);
		
		accountRepository.changeAccountBalanceById(newBalance, accountID);
		
		transactRepository.logTransaction(accountID, "Payment", paymentAmount, "online", "success", "Payment Transaction Successful", currentDateTime);
		successMessage = reasonCode;
		redirectAttributes.addFlashAttribute("success", successMessage);
		return "redirect:/app/dashboard";
	}
}
