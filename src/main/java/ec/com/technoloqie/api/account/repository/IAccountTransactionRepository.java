package ec.com.technoloqie.api.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.technoloqie.api.account.entity.AccountTransaction;

public interface IAccountTransactionRepository extends JpaRepository<AccountTransaction, Integer>	{

}
