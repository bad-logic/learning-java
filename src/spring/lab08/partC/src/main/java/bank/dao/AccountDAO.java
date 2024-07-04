package bank.dao;

import bank.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountDAO extends MongoRepository<Account,Integer> {
	Account getAccountByaccountnumber(long accountNumber);
}

