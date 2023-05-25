package com.laptrinhjavaweb.service;


import com.laptrinhjavaweb.dto.AssignmentDTO;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.request.CustomerRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.dto.response.CustomerResponse;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import javassist.NotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


public interface ICustomerService {

    List<CustomerResponse> pageCustomer(Pageable pageable, CustomerRequest customerRequest);

    int getTotalItems();

    CustomerDTO findCustomerById(Long id);

    CustomerDTO save(CustomerDTO customer);

    void delete(long[] idList);

    List<StaffResponseDTO> finAllStaffByCustomer(Long id);

    void assignmentCustomer(AssignmentDTO assignmentDTO);

    CustomerDTO findById(Long id);
}
