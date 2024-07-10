package bank.service;

import java.util.Collection;

import bank.common.RestException;
import bank.dtos.AccountDTO;
import bank.dtos.CreateAccountDTO;
import bank.dtos.TransactionDTO;
import bank.dtos.TransferDTO;


public interface IAccountService {
    public AccountDTO createAccount(CreateAccountDTO data) ;
    public AccountDTO getAccount(long accountNumber) throws RestException;
    public Collection<AccountDTO> getAllAccounts();
    public void deposit (TransactionDTO data) throws RestException;
    public void withdraw (TransactionDTO data) throws RestException;
    public void depositEuros (TransactionDTO data) throws RestException;
    public void withdrawEuros (TransactionDTO data) throws RestException;
    public void transferFunds(TransferDTO data) throws RestException;
}
