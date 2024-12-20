package com.demo_bank_v2.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo_bank_v2.models.Transact;

@Repository
public interface TransactRepository extends CrudRepository<Transact, Integer>{

	@Modifying
	@Query(value = "INSERT INTO transaction_history(account_id, transaction_type, amount, source, status, reason_code, create_at)" + 
	               "VALUES(:account_id, :transaction_type, :amount, :source, :status, :reason_code, :create_at)", nativeQuery = true)
	@Transactional
	void logTransaction(@Param("account_id") int account_id,
			@Param("transaction_type") String transaction_type,
			@Param("amount") double amount,
			@Param("source") String source,
			@Param("status") String status,
			@Param("reason_code") String reason_code,
			@Param("create_at") LocalDateTime create_at);
}
