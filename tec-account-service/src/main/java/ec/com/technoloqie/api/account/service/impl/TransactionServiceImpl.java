package ec.com.technoloqie.api.account.service.impl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.com.technoloqie.api.account.commons.AccountConstants;
import ec.com.technoloqie.api.account.commons.exception.AccountWSException;
import ec.com.technoloqie.api.account.dto.TransactionDto;
import ec.com.technoloqie.api.account.entity.Transaction;
import ec.com.technoloqie.api.account.entity.TransactionType;
import ec.com.technoloqie.api.account.mapper.TransactionMapper;
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
	public TransactionDto createTransaction(TransactionDto transaction) throws AccountWSException{
		Transaction trans = TransactionMapper.mapToTransaction(transaction);
		TransactionType transactionType = new TransactionType();
		transactionType.setId(AccountConstants.TRANSACTION_TYPE_SIMPLE);
		trans.setTransactionType(transactionType);
		Transaction newTrans = this.transactionDao.save(trans);
		return TransactionMapper.mapToTransactionDto(newTrans);
	}

	@Override
	@Transactional(readOnly = true)
	public TransactionDto getTransactionId(Integer code) throws AccountWSException{
		Transaction transaction = this.transactionDao.findById(code).orElse(null);
		return TransactionMapper.mapToTransactionDto(transaction);
	}

	@Override
	public void deleteTransaction(Integer code) {
		this.transactionDao.deleteById(code);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<TransactionDto> getListTransaction() {
		List<Transaction> transactions = this.transactionDao.findAll();
		return transactions.stream().map((trans)-> TransactionMapper.mapToTransactionDto(trans)).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Transaction payTransaction(Transaction transaction) throws AccountWSException{
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Transaction> findByNameContainingDate(String firstName, String lastName, String dateInit,
			String dateFinish) {
		return null;
	}

	@Override
	@Transactional
	public TransactionDto updateTransaction(TransactionDto trans, int id) throws AccountWSException {
		Transaction existTrans = this.transactionDao.findById(id).orElseThrow(() -> new AccountWSException("Error la transaccion no existe"));
		existTrans.setAmount(trans.getAmount());
		existTrans.setModifiedBy(trans.getModifiedBy());
		existTrans.setModifiedDate(LocalDate.now());
		existTrans.setStatus(trans.getStatus());
		this.transactionDao.save(existTrans);
		return TransactionMapper.mapToTransactionDto(existTrans);
	}

}
