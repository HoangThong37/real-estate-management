package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.TransactionConverter;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.TransactionRepository;
import com.laptrinhjavaweb.service.ITransactionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private TransactionRepository transactionRepo;

	@Autowired
	private TransactionConverter transactionConverter;

	@Override
	@Transactional
	public TransactionDTO save(TransactionDTO transactionDTO) throws NotFoundException {
		TransactionEntity transaction = transactionConverter.convertToTransactionEntity(transactionDTO);
        if (transaction != null) {
        	transactionRepo.save(transaction);
		}
		return  transactionConverter.convertToDTO(transaction);
	}

	@Override
	public List<TransactionDTO> findTransactionByCustomer(Long customerId) {
		List<TransactionDTO> transactionDTO = new ArrayList<>();
		List<TransactionEntity> listTransaction = transactionRepo.findByCustomer_Id(customerId);

		for (TransactionEntity item : listTransaction) {
			TransactionDTO dto = transactionConverter.convertToDTO(item);
			transactionDTO.add(dto);
		}
		return transactionDTO;
	}

	@Override
	public List<TransactionDTO> findAllTransaction() {
		 List<TransactionDTO> transactionDTOS = new ArrayList<>();
		 List<TransactionEntity> transactions = transactionRepo.findAll();
		 for (TransactionEntity item : transactions) {
			 transactionDTOS.add(transactionConverter.convertToDTO(item));
		 }
		return transactionDTOS;
	}

}