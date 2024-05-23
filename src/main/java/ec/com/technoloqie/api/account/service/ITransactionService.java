package ec.com.technoloqie.api.account.service;

import java.util.Collection;
import java.util.List;

import ec.com.technoloqie.api.account.entity.Transaction;

public interface ITransactionService {
	
	Transaction createTransaction(Transaction transaction);
	Transaction getTransactionId(Integer code);
	Transaction updateTransaction(Transaction trans, int id);
	void deleteTransaction(Integer code);
	List<Transaction> getListTransaction();
	Transaction payTransaction(Transaction transaction);
	Collection <Transaction> findByNameContainingDate(String firstName, String lastName, String dateInit,
			String dateFinish);

}
