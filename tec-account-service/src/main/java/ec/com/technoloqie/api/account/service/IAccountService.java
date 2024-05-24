package ec.com.technoloqie.api.account.service;

import java.util.List;

import ec.com.technoloqie.api.account.commons.exception.AccountWSException;
import ec.com.technoloqie.api.account.dto.AccountDto;

public interface IAccountService {
	
	AccountDto createAccount(AccountDto account) throws AccountWSException;
	AccountDto updateAccount(AccountDto account, int id)throws AccountWSException;
	void deleteAccount(Integer code)throws AccountWSException;
	List<AccountDto> getListAccounts()throws AccountWSException;
	//AccountDto findOneByAccNumber(Integer code);
	AccountDto getAccountById(Integer code) throws AccountWSException;
}
