package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.response.CustomerResponse;
import com.laptrinhjavaweb.dto.response.TransactionResponse;
import com.laptrinhjavaweb.dto.response.TransactionTypesResponse;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.enums.TransactionsEnum;
import com.laptrinhjavaweb.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CustomerConverter {

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO convertToDto(CustomerEntity entity){
        CustomerDTO result = modelMapper.map(entity, CustomerDTO.class); // hứng kết quả
        // code save transaction
        List<TransactionTypesResponse> typesResponses = new ArrayList<>();
        for (TransactionsEnum item : TransactionsEnum.values()) {
            TransactionTypesResponse transaction = new TransactionTypesResponse();
            transaction.setCode(item.name());
            transaction.setTransactionName(item.getTransactionTypeValue());
            // set giao dịch
            List<TransactionResponse> transactionResponses = new ArrayList<>();

            for (TransactionEntity transactionEntity : entity.getTransactionEntities()) {
                if (transactionEntity.getCode().equals(item.name())) {
                    TransactionResponse transactionResponse = new TransactionResponse();
                    transactionResponse.setCreateDate(DateUtils.convertDateToString(new Date(),  "dd/MM/yyyy HH:mm:ss"));
                    transactionResponse.setNote(transactionEntity.getNote());
                    transactionResponses.add(transactionResponse);
                }
            }
            transaction.setTransactions(transactionResponses);
            typesResponses.add(transaction);
        }
        result.setTransactionTypes(typesResponses);
        return result;
    }


    public CustomerEntity convertToEntity(CustomerDTO dto){
        CustomerEntity result = modelMapper.map(dto, CustomerEntity.class);
        return result;
    }

    public CustomerResponse convertToCustomerResponse(CustomerEntity entity){
        CustomerResponse result = modelMapper.map(entity, CustomerResponse.class);
        return result;
    }



}
