package ec.com.technoloqie.api.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.technoloqie.api.account.entity.Transaction;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer>	{

}
