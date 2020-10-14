package com.zln.zcar.cms.service;

import com.zln.zcar.cms.Dao.OperationLogDaoJpaRepository;
import com.zln.zcar.cms.entity.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogService {
    @Autowired
    private OperationLogDaoJpaRepository operationLogDaoJpaRepository;
    public void insert(OperationLog operlog) {
        operationLogDaoJpaRepository.save(operlog);
    }
}
