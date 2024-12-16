package com.demo_bank_v2.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo_bank_v2.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

	@Modifying
	@Query(value = "INSERT INTO payments(account_id, beneficiary, beneficiary_acc_no, amount, reference_no, status, reason_code, create_at)" + 
					"VALUES(:account_id, :beneficiary, :beneficiary_acc_no, :amount, :reference_no, :status, :reason_code, :create_at)", nativeQuery = true) 
	@Transactional
	void makePayment(@Param("account_id") int account_id,
			@Param("beneficiary") String beneficiary,
			@Param("beneficiary_acc_no") String beneficiary_acc_no,
			@Param("amount") double amount,
			@Param("reference_no") String reference_no,
			@Param("status") String status,
			@Param("reason_code") String reason_code,
			@Param("create_at") LocalDateTime create_at);
}
