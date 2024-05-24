package ec.com.technoloqie.api.account.mapper;

import ec.com.technoloqie.api.account.dto.AccountDto;
import ec.com.technoloqie.api.account.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccNumber(), 
				accountDto.getBalance(),
				accountDto.getCreatedBy(),
				accountDto.getCreatedDate(),
				accountDto.getModifiedBy(),
				accountDto.getModifiedDate(),
				accountDto.getStatus(),
				accountDto.getCustomerId(),
				null,
				null);
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccNumber(), 
				account.getBalance(),
				account.getCreatedBy(),
				account.getCreatedDate(),
				account.getModifiedBy(),
				account.getModifiedDate(),
				account.getStatus(),
				account.getCustomerId()
				);
		return accountDto;
	}
}
