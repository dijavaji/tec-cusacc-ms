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

import ec.com.technoloqie.api.account.dto.AccountDto;
import ec.com.technoloqie.api.account.entity.Account;
import ec.com.technoloqie.api.account.service.impl.AccountServiceImpl;
import jakarta.validation.Valid;


//@CrossOrigin(origins = {"http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {
	
	@Autowired
	private AccountServiceImpl accountService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> addAccount(@Valid @RequestBody AccountDto accountDto, BindingResult result) {
		return new ResponseEntity<>(this.accountService.createAccount(accountDto), HttpStatus.CREATED); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable Integer id) {
		AccountDto accountDto = this.accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto); 
	}
	
	@GetMapping
	public ResponseEntity<List<?>> getAllAccounts() {
		List<AccountDto> accounts = this.accountService.getListAccounts();
		return ResponseEntity.ok(accounts); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@Valid @PathVariable Integer id) {
		this.accountService.deleteAccount(id);
		return ResponseEntity.ok("Cuenta eliminada correctamente"); 
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAccount(@RequestBody AccountDto accountDto, @PathVariable Integer id) {
		AccountDto account = this.accountService.updateAccount(accountDto, id);
		return ResponseEntity.ok(account);
	}
}
