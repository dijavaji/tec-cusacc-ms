package ec.com.technoloqie.api.account.mapper;

import ec.com.technoloqie.api.account.dto.TransactionDto;
import ec.com.technoloqie.api.account.entity.Transaction;

public class TransactionMapper {
	
	public static Transaction mapToTransaction(TransactionDto transDto) {
		return new Transaction(
				transDto.getId(),
				transDto.getAmount(),
				transDto.getCreatedBy(),
				transDto.getCreatedDate(),
				transDto.getModifiedBy(),
				transDto.getModifiedDate(),
				transDto.getStatus(),
				null
				);
	}
	
	public static TransactionDto mapToTransactionDto(Transaction transaction) {
		return new TransactionDto(
				transaction.getId(),
				transaction.getAmount(),
				null,  
				transaction.getTransactionType().getId(),
				null,
				transaction.getCreatedBy(),
				transaction.getCreatedDate(),
				transaction.getModifiedBy(),
				transaction.getModifiedDate(),
				transaction.getStatus()
				);
	}

}
