package bank.adapter;

import bank.domain.TraceRecord;
import bank.dtos.*;

public class TraceRecordAdapter {
    public static TraceRecord toTraceRecordDomain(CreateTraceRecordDTO data){
        TraceRecord domain = new TraceRecord();
        domain.setAccountNumber(data.getAccountNumber());
        domain.setDate(data.getDate());
        domain.setEvent(data.getEvent());
        domain.setAmount(data.getAmount());
        domain.setFromAccountNumber(data.getFromAccountNumber());
        return domain;
    }

    public static TraceRecordDTO toTraceRecordDto(TraceRecord data){
        return new TraceRecordDTO(data.getAccountNumber(),data.getAmount(),data.getDate(),data.getEvent(),data.getFromAccountNumber(),data.getId());
    }
}
