package com.project.transactionManagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.transactionManagement.entity.Transaction;
import com.project.transactionManagement.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private TransactionService transactionService;

	public TransactionController( TransactionService transactionService ) {
		this.transactionService=transactionService;
	}

	@PostMapping("/save")
	public Transaction saveTransaction( @RequestBody Transaction transaction ){
		return transactionService.saveTransaction( transaction );
	}
}
