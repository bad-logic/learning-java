package bank.kafka;

import bank.dtos.CreateAccountDTO;
import bank.dtos.TransactionDTO;
import bank.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @Autowired
    private AccountService accountService;

    public Receiver(AccountService accountService){
        this.accountService = accountService;
    }


    @KafkaListener(topics = {"KafkaToBank"})
    public void receive(@Payload String message) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            KafkaMessage op = objectMapper.readValue(message, KafkaMessage.class);
            MessageType type = op.getMessage();
            String payload = objectMapper.writeValueAsString(op.getPayload());
            System.out.println("Received Message " + type +", Payload: "+payload);
            switch (type){
                case CREATE_ACCOUNT -> this.accountService.createAccount(objectMapper.readValue(payload, CreateAccountDTO.class));
                case DEPOSIT -> this.accountService.deposit(objectMapper.readValue(payload, TransactionDTO.class));
                case WITHDRAW -> this.accountService.withdraw(objectMapper.readValue(payload, TransactionDTO.class));
                default -> throw new Exception("unknown operation type");
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }

}
