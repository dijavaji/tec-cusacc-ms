package ec.com.technoloqie.api.account.service.impl;

import org.springframework.stereotype.Service;

import ec.com.technoloqie.api.account.entity.AccountTransaction;
import ec.com.technoloqie.api.account.repository.IAccountTransactionRepository;
import ec.com.technoloqie.api.account.service.IAccountTransactionService;

@Service
public class AccountTransactionServiceImpl implements IAccountTransactionService{
	
	private IAccountTransactionRepository accountTransRepo;
	
	@Override
	public AccountTransaction createAccountTransaction(AccountTransaction transAcc) {
		return this.accountTransRepo.save(transAcc);
	}

}
