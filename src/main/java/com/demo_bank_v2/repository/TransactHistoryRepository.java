package com.demo_bank_v2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo_bank_v2.models.PaymentHistory;
import com.demo_bank_v2.models.TransactionHistory;

@Repository
public interface TransactHistoryRepository extends CrudRepository<TransactionHistory, Integer> {

	@Query(value = "SELECT * FROM v_transaction_history WHERE user_id= :user_id ", nativeQuery = true)
	List<TransactionHistory> getTransactRecordsById(@Param("user_id") int user_id);
	
}
