package com.sawlov2code.rmbackend.transactionLog.dao;

import com.sawlov2code.rmbackend.transactionLog.model.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
}
