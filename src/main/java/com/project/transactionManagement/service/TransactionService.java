package com.project.transactionManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.transactionManagement.entity.Transaction;
import com.project.transactionManagement.repository.TransactionRepository;

/**
 *  transaction service
 *
 */
@Service
public class TransactionService {

	//	@Autowired
	//	TransactionRepository transactionRepository;

	/**
	 * The reason why constructor injection (below ) is preferred over field injection (above) is
	 * that :
	 *
	 * What Happens in Field Injection ?
	 *-------------------------------------------------
	 * @Service
	 * public class TransactionService {
	 *
	 *     @Autowired
	 *     TransactionRepository transactionRepository;
	 * }
	 *---------------------------------------------------------
	 * Internally:
	 * Step 1: Object created
	 * ---------------------------------------------------------
	 * TransactionService service = new TransactionService();
	 *---------------------------------------------------------
	 * At this moment:
	 *----------------------------------
	 * transactionRepository = null
	 *-----------------------------------
	 * Step 2: Dependency injected (later)
	 * ------------------------------------
	 * service.transactionRepository = repo;
	 *----------------------------------------
	 * this can cause NPE when we try to create object manually :
	 * -------------------------------------------
	 * TransactionService service = new TransactionService();
	 * service.saveTransaction(tx); // ❌ NPE
	 *----------------------------------------------
	 * 👉 Spring is NOT involved
	 * 👉 Injection never happens
	 * 👉 transactionRepository stays null
	 *
	 * But with constructor injection object will not be created till we have repo
	 */

	private TransactionRepository transactionRepository;


	public TransactionService(TransactionRepository repo) {
		this.transactionRepository = repo;
	}


	// Save transaction
	public Transaction saveTransaction( Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	// Get all transactions
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	// Get transaction by ID
	public Transaction getTransactionById(Integer id) {
		return transactionRepository.findById(id).orElse(null);
	}

	// Delete transaction
	public void deleteTransaction(Integer id) {
		transactionRepository.deleteById(id);
	}

}
