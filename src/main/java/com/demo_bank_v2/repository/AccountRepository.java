package com.demo_bank_v2.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo_bank_v2.models.Accounts;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Integer>{
	
	@Query(value = "SELECT * FROM accounts WHERE user_id = :user_id", nativeQuery = true)
	List<Accounts> getUserAccountsById(@Param("user_id")int user_id);
	
	@Query(value = "SELECT balance FROM accounts WHERE user_id = :user_id", nativeQuery = true)
	BigDecimal getTotalBalance(@Param("user_id")int user_id);
}
