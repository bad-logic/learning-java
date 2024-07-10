package bank.repository;

import bank.domain.TraceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraceRecordRepository extends JpaRepository<TraceRecord,Long> {
}
