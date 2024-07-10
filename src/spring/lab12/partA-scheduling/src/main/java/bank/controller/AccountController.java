package bank.controller;

import bank.common.RestException;
import bank.dtos.AccountDTO;
import bank.dtos.CreateAccountDTO;
import bank.dtos.TransactionDTO;
import bank.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccounts(){
        return new ResponseEntity<List<AccountDTO>>(this.accountService.getAllAccounts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody @Valid CreateAccountDTO data){
        return new ResponseEntity<AccountDTO>(this.accountService.createAccount(data), HttpStatus.CREATED);
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionDTO> deposit(@RequestBody @Valid TransactionDTO data) throws RestException {
        this.accountService.deposit(data);
        return new ResponseEntity<TransactionDTO>(data, HttpStatus.OK);

    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionDTO> withdraw(@RequestBody @Valid TransactionDTO data) throws RestException {
        this.accountService.withdraw(data);
        return new ResponseEntity<TransactionDTO>(data, HttpStatus.OK);
    }
}
