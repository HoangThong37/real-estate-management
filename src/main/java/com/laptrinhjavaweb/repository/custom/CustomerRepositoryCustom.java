package com.laptrinhjavaweb.repository.custom;


import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerRepositoryCustom {

    // sử dụng buider
    List<CustomerEntity> pageCustomer(Pageable pageable, CustomerSearchBuilder builder);

}
