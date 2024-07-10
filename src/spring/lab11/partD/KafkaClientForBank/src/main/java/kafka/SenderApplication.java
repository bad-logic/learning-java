package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.dtos.CreateAccountDTO;
import kafka.dtos.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SenderApplication implements CommandLineRunner {
    @Autowired
    Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("sending: create Account message");
        CreateAccountDTO acc = new CreateAccountDTO("Frank");

        String accountCreationMessage = objectMapper.writeValueAsString(new BankMessage(MessageType.CREATE_ACCOUNT,acc));
        sender.send("KafkaToBank",accountCreationMessage);

        System.out.println("sending: deposit on Account message");
        TransactionDTO deposit = new TransactionDTO(1L,11000);
        String depositMessage = objectMapper.writeValueAsString(new BankMessage(MessageType.DEPOSIT, deposit));
        sender.send("KafkaToBank",depositMessage);

        System.out.println("sending: withdraw on Account message");
        TransactionDTO withdraw = new TransactionDTO(1L,2000);
        String withdrawMessage = objectMapper.writeValueAsString(new BankMessage(MessageType.WITHDRAW, withdraw));
        sender.send("KafkaToBank",withdrawMessage);

    }
}
