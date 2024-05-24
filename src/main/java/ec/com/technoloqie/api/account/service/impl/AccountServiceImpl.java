package ec.com.technoloqie.api.account.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.technoloqie.api.account.commons.exception.AccountWSException;
import ec.com.technoloqie.api.account.dto.AccountDto;
import ec.com.technoloqie.api.account.entity.Account;
import ec.com.technoloqie.api.account.mapper.AccountMapper;
import ec.com.technoloqie.api.account.repository.IAccountRepository;
import ec.com.technoloqie.api.account.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto accountdto) throws AccountWSException{
		Account account = AccountMapper.mapToAccount(accountdto);
		Account savedAccount = this.accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto updateAccount(AccountDto account, int id) throws AccountWSException{
		Account existAccount = this.accountRepository.findById(id).orElseThrow(()-> new AccountWSException("Error la cuenta no existe")); //tenemos que comprobar si con la identificación dada existe en la db o no
		existAccount.setBalance(account.getBalance());
		existAccount.setModifiedBy(account.getModifiedBy());
		existAccount.setModifiedDate(LocalDate.now());
		existAccount.setStatus(account.getStatus());
		this.accountRepository.save(existAccount);
		return AccountMapper.mapToAccountDto(existAccount);
	}

	@Override
	public void deleteAccount(Integer code) throws AccountWSException{
		getAccountById(code);
		accountRepository.deleteById(code);;
	}

	@Override
	public List<AccountDto> getListAccounts() throws AccountWSException{
		List <Account> accounts = this.accountRepository.findAll();
		return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}

	@Override
	public AccountDto getAccountById(Integer code) throws AccountWSException{
		Account account = this.accountRepository.findById(code).orElseThrow(()-> new AccountWSException("Error la cuenta no existe"));
		return AccountMapper.mapToAccountDto(account);
	}
	
}
