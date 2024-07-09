package app;

import app.dto.AccountDTO;
import app.dto.CreateAccountDTO;
import app.dto.TransactionDTO;
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
        return new ResponseEntity<List<AccountDTO>>(this.accountService.getAccounts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody @Valid CreateAccountDTO data){
        return new ResponseEntity<AccountDTO>(this.accountService.createAccount(data), HttpStatus.CREATED);
    }

    @PostMapping("/deposit")
    public ResponseEntity<AccountDTO> deposit(@RequestBody @Valid TransactionDTO data) throws RestException {
        return new ResponseEntity<AccountDTO>(this.accountService.deposit(data), HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@RequestBody @Valid TransactionDTO data) throws RestException {
        return new ResponseEntity<AccountDTO>(this.accountService.withdraw(data), HttpStatus.OK);
    }

}
