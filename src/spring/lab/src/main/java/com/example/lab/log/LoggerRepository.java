package com.example.lab.log;

import com.example.lab.common.CustomRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoggerRepository extends CustomRepository<Log, UUID> {
}
