package ec.com.technoloqie.api.account.service;

import java.util.List;

import ec.com.technoloqie.api.account.commons.exception.AccountException;
import ec.com.technoloqie.api.account.dto.AccountDto;

public interface IAccountService {
	
	AccountDto createAccount(AccountDto account) throws AccountException;
	AccountDto updateAccount(AccountDto account, int id)throws AccountException;
	void deleteAccount(Integer code)throws AccountException;
	List<AccountDto> getListAccounts()throws AccountException;
	//AccountDto findOneByAccNumber(Integer code);
	AccountDto getAccountById(Integer code) throws AccountException;
}
