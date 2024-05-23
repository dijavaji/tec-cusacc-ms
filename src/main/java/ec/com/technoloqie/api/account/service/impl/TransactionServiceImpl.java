package ec.com.technoloqie.api.account.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.com.technoloqie.api.account.commons.exception.AccountException;
import ec.com.technoloqie.api.account.entity.Transaction;
import ec.com.technoloqie.api.account.repository.ITransactionRepository;
import ec.com.technoloqie.api.account.service.IAccountService;
import ec.com.technoloqie.api.account.service.IAccountTransactionService;
import ec.com.technoloqie.api.account.service.ITransactionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionServiceImpl implements ITransactionService{
	
	@Autowired
	private ITransactionRepository transactionDao;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IAccountTransactionService accTranService;
	
	@Override
	@Transactional
	public Transaction createTransaction(Transaction transaction) {
		return this.transactionDao.save(transaction);
	}

	@Override
	@Transactional(readOnly = true)
	public Transaction getTransactionId(Integer code) {
		return this.transactionDao.findById(code).orElse(null);
	}

	@Override
	@Transactional
	public Transaction updateTransaction(Transaction trans, int id) {
		Transaction existTrans = getTransactionId(id); 
		existTrans.setAmount(trans.getAmount());
		existTrans.setModifiedBy(trans.getModifiedBy());
		existTrans.setModifiedDate(new Date());
		existTrans.setStatus(trans.getStatus());
		this.transactionDao.save(existTrans);
		return existTrans;
	}

	@Override
	public void deleteTransaction(Integer code) {
		this.transactionDao.deleteById(code);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Transaction> getListTransaction() {
		return this.transactionDao.findAll();
	}
	
	@Override
	@Transactional
	public Transaction payTransaction(Transaction transaction) throws AccountException{
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Transaction> findByNameContainingDate(String firstName, String lastName, String dateInit,
			String dateFinish) {
		return null;
	}

}
