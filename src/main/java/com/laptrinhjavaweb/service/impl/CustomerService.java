package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.request.CustomerRequest;
import com.laptrinhjavaweb.dto.response.CustomerResponse;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerConverter customerConverter;

	@Override
	public List<CustomerResponse> pageCustomer(Pageable pageable, CustomerRequest customerRequest) {
		List<CustomerResponse> result = new ArrayList<>();
		CustomerSearchBuilder customerSearch = convertParamToBuilder(customerRequest);
		List<CustomerEntity> listCustomer = customerRepository.pageCustomer(pageable, customerSearch);
		for (CustomerEntity item : listCustomer) {
			result.add(customerConverter.convertToCustomerResponse(item));
		}
		return result;
	}

	private CustomerSearchBuilder convertParamToBuilder(CustomerRequest customerRequest) {
		try {
			CustomerSearchBuilder result = new CustomerSearchBuilder.Builder()
					.setFullName(customerRequest.getFullName())
					.setEmail(customerRequest.getEmail())
					.setPhone(customerRequest.getPhone())
					.setStaffId(customerRequest.getStaffId()).build();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getTotalItems() {
		return customerRepository.countAllByCustomer();
	}
}