package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.response.TransactionResponse;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.service.impl.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TransactionConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

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

    // convert entity -> dto - 2
    public TransactionDTO convertToDTO2(TransactionEntity dto){
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setNote(dto.getNote());
        transactionDTO.setCustomerId(dto.getCustomer().getId());
        transactionDTO.setCustomerId(dto.getCustomer().getId());

        return transactionDTO;
    }


    // convert request dto -> enntity
    public TransactionEntity convertToTransactionEntity(TransactionDTO dto){
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCode(dto.getCode());
        transactionEntity.setNote(dto.getNote());
        if (!transactionEntity.getCode().isEmpty() && transactionEntity.getNote() != null) {
            transactionEntity.setCustomer(customerRepository.findById(dto.getCustomerId()).get());
        }
        return transactionEntity;
    }
}
