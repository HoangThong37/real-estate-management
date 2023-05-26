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

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private TransactionRepository transactionRepo;

	@Autowired
	private TransactionConverter transactionConverter;

	// apply java 8
	@Override
	@Transactional
	public TransactionDTO save(TransactionDTO transactionDTO) throws NotFoundException {
		TransactionEntity transaction = transactionConverter.convertToTransactionEntity(transactionDTO);
        if (transaction != null) {
        	transactionRepo.save(transaction);
		}
		return transactionConverter.convertToDTO2(transaction);
	}

    @Override
	public List<TransactionDTO> findTransactionByCustomer(Long customerId) {
		List<TransactionEntity> listTransaction = transactionRepo.findByCustomer_Id(customerId);
		return listTransaction.stream()
				              .map(transactionConverter::convertToDTO)
				              .collect(Collectors.toList());
	}

	@Override
	public List<TransactionDTO> findAllTransaction() {
		return transactionRepo.findAll().stream()
				.map(transactionConverter::convertToDTO)
				.collect(Collectors.toList());
	}

/*	@Override
	public List<TransactionDTO> findAllTransaction() {
		 List<TransactionDTO> transactionDTOS = new ArrayList<>();
		 List<TransactionEntity> transactions = transactionRepo.findAll();
		 for (TransactionEntity item : transactions) {
			 transactionDTOS.add(transactionConverter.convertToDTO(item));
		 }
		return transactionDTOS;
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
*/


}