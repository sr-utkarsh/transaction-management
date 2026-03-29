package com.project.transactionManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.transactionManagement.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}
