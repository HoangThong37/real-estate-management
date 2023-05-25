package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.TransactionConverter;
import com.laptrinhjavaweb.dto.request.TransactionRequest;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.TransactionRepository;
import com.laptrinhjavaweb.service.ITransactionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private TransactionRepository transactionRepo;

	@Autowired
	private TransactionConverter transactionConverter;

	@Override
	@Transactional
	public void save(TransactionRequest transactionRequest) throws NotFoundException {
		TransactionEntity transaction = transactionConverter.convertToEntity(transactionRequest);
        if (transaction != null) {
        	transactionRepo.save(transaction);
		}
	}
}