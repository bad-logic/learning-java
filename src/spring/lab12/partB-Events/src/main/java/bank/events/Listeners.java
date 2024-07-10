package bank.events;

import bank.dtos.CreateTraceRecordDTO;
import bank.service.TraceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@EnableAsync
public class Listeners {

    @Autowired
    private TraceRecordService traceRecordService;

    @Async
    @EventListener
    public void onEvent(AccountChangeEvent ev) throws Exception {
        CreateTraceRecordDTO record = new CreateTraceRecordDTO();
        record.setDate(LocalDate.now());
        record.setEvent(ev.getEvent());

        StringBuilder emailMessage = new StringBuilder("EVENT: "+ev.getEvent()+", AMOUNT: ");
        switch (ev.getEvent()){
            case DEPOSIT, WITHDRAW -> {
                emailMessage.append(ev.getTransaction().getAmount()).append(", Acc: ").append(ev.getTransaction().getAccountNumber());
                record.setAccountNumber(ev.getTransaction().getAccountNumber());
                record.setAmount(ev.getTransaction().getAmount());
            }
            case TRANSFER -> {
                emailMessage.append(ev.getTransfer().getAmount()).append(", FromAcc: ").append(ev.getTransfer().getFromAccountNumber()).append(", Acc: ").append(ev.getTransfer().getToAccountNumber());
                record.setAccountNumber(ev.getTransfer().getToAccountNumber());
                record.setFromAccountNumber(ev.getTransfer().getFromAccountNumber());
                record.setAmount(ev.getTransfer().getAmount());
            }
            default -> throw new Exception("unknown event triggered");
        }

        // code to sending email or inject emailService as dependency if one is available
        // for now just writing to console
        System.out.println("EMAIL: " + emailMessage.toString());

        // ADDING A TRACE RECORD
        this.traceRecordService.addTraceRecord(record);
    }
}
