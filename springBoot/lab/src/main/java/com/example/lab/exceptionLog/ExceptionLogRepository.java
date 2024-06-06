package com.example.lab.exceptionLog;

import com.example.lab.common.CustomRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExceptionLogRepository extends CustomRepository<ExceptionLog, UUID> {
}
