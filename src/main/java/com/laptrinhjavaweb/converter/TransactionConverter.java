package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    // convert request dto -> response
    public TransactionEntity convertToEntity(TransactionDTO dto){
        TransactionEntity result = modelMapper.map(dto, TransactionEntity.class);

        return result;
    }

    // convert entity -> dto
    public TransactionDTO convertToDTO(TransactionEntity dto){
        TransactionDTO result = modelMapper.map(dto, TransactionDTO.class);
        return result;
    }


    // convert request dto -> enntity
    public TransactionEntity convertToTransactionEntity(TransactionDTO dto){
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCode(dto.getCode());
        transactionEntity.setNote(dto.getNote());
        if (!transactionEntity.getCode().isEmpty() && transactionEntity.getNote() != null) {
            transactionEntity.setCustomer(customerRepository.findById(dto.getId()).get());
        }
        return transactionEntity;
    }
}
