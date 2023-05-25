package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends CustomerRepositoryCustom, JpaRepository<CustomerEntity, Long> {

    @Query(value="select count(*) from customer", nativeQuery = true)
    int countAllByCustomer();

    void deleteByIdIn(List<Long> ids);
    Long countByIdIn(List<Long> customerIds);
}
