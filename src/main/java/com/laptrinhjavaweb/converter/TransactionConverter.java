package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.request.TransactionRequest;
import com.laptrinhjavaweb.entity.TransactionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter {

    @Autowired
    private ModelMapper modelMapper;

    // convert request dto -> response
    public TransactionEntity convertToEntity(TransactionRequest dto){
        TransactionEntity result = modelMapper.map(dto, TransactionEntity.class);
        return result;
    }


//    public CustomerResponse convertToCustomerResponse(CustomerEntity entity){
//        CustomerResponse result = modelMapper.map(entity, CustomerResponse.class);
//        return result;
//    }
}
