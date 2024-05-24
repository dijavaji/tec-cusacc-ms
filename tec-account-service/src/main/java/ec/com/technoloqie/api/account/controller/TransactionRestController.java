package ec.com.technoloqie.api.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.com.technoloqie.api.account.dto.TransactionDto;
import ec.com.technoloqie.api.account.service.ITransactionService;
import jakarta.validation.Valid;

/**
 * @author dv
 */
@RestController
@RequestMapping("/api/transactions")
public class TransactionRestController {
	
	@Autowired
	private ITransactionService tranService;
	
	@GetMapping
	public ResponseEntity<List<?>> getAllTransactions() {
		List<TransactionDto> accounts = this.tranService.getListTransaction();
		return ResponseEntity.ok(accounts); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTransactionById(@PathVariable Integer id) {
		TransactionDto transDto = this.tranService.getTransactionId(id);
		return ResponseEntity.ok(transDto); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> addTransaction(@Valid @RequestBody TransactionDto transactionDto, BindingResult result) {
		return new ResponseEntity<>(this.tranService.createTransaction(transactionDto), HttpStatus.CREATED); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTransaction(@Valid @PathVariable Integer id) {
		this.tranService.deleteTransaction(id);
		return ResponseEntity.ok("Transaccion eliminada correctamente"); 
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTransaction(@RequestBody TransactionDto transDto, @PathVariable Integer id) {
		TransactionDto transaction = this.tranService.updateTransaction(transDto, id);
		return ResponseEntity.ok(transaction);
	}
	
}
