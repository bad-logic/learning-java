package bank.dao;

import bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountDAO extends JpaRepository<Account,Integer> {
	Account getAccountByaccountnumber(long accountNumber);
}

