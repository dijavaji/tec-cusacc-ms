package ec.com.technoloqie.api.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.technoloqie.api.account.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer>{

}
