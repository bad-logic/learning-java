package bank.repositories;

import bank.domain.Tracerecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TracerecordRepository extends JpaRepository<Tracerecord,Integer> {
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    default Tracerecord addRecord(Tracerecord t){
        return save(t);
    }
}
