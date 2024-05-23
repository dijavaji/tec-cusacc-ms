package ec.com.technoloqie.api.account.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.technoloqie.api.account.entity.Transaction;

/**
 * @author dv
 */
@RestController
@RequestMapping("/api/transactions")
public class TransactionRestController {
	
	@GetMapping
	public List<Transaction> getListTransactions() {
		return null;
	}
	
	public 
}
