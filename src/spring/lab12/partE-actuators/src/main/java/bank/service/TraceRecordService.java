package bank.service;

import bank.adapter.TraceRecordAdapter;
import bank.domain.TraceRecord;
import bank.dtos.CreateTraceRecordDTO;
import bank.dtos.TraceRecordDTO;
import bank.repository.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraceRecordService {
    @Autowired
    private TraceRecordRepository traceRecordRepository;

    public TraceRecordService(TraceRecordRepository traceRecordRepository) {
        this.traceRecordRepository = traceRecordRepository;
    }

    public TraceRecordDTO addTraceRecord(CreateTraceRecordDTO trace){
        TraceRecord data = this.traceRecordRepository.save(TraceRecordAdapter.toTraceRecordDomain(trace));
        return TraceRecordAdapter.toTraceRecordDto(data);
    }
}
