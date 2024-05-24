package ec.com.technoloqie.api.account.service;

import java.util.Collection;
import java.util.List;

import ec.com.technoloqie.api.account.commons.exception.AccountWSException;
import ec.com.technoloqie.api.account.dto.TransactionDto;
import ec.com.technoloqie.api.account.entity.Transaction;

public interface ITransactionService {
	
	TransactionDto createTransaction(TransactionDto transaction) throws AccountWSException;
	TransactionDto getTransactionId(Integer code) throws AccountWSException;
	TransactionDto updateTransaction(TransactionDto trans, int id) throws AccountWSException;
	void deleteTransaction(Integer code) throws AccountWSException;
	List<TransactionDto> getListTransaction() throws AccountWSException;
	Transaction payTransaction(Transaction transaction) throws AccountWSException;
	Collection <Transaction> findByNameContainingDate(String firstName, String lastName, String dateInit,
			String dateFinish) throws AccountWSException;

}
