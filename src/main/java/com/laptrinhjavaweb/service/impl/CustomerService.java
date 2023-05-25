package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.AssignmentDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.request.CustomerRequest;
import com.laptrinhjavaweb.dto.response.CustomerResponse;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerConverter customerConverter;

	@Autowired
	private UserRepository userRepository;

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

	@Override
	public CustomerDTO findCustomerById(Long id) {
		if (id != null) {
			CustomerEntity customerEntity = customerRepository.findById(id).get();

			return customerConverter.convertToDto(customerEntity);
	     }
	     return null;
	}

	@Override
	@Transactional
	public CustomerDTO save(CustomerDTO customer) {
		CustomerEntity customerEntity = customerConverter.convertToEntity(customer);

        // edit - set user, transaction
		if (customer.getId() != null) {
			CustomerEntity customerId = customerRepository.findById(customer.getId()).get();
			customerEntity.setUserEntities(customerId.getUserEntities());
			customerEntity.setTransactionEntities(customerId.getTransactionEntities());
		}

		return customerConverter.convertToDto(customerRepository.save(customerEntity));
	}

	@Override
	@Transactional
	public void delete(List<Long> idList) {
		try {
			if (!idList.isEmpty()) {
				Long count = customerRepository.countByIdIn(idList);

				if (count != idList.size()) {
					throw new NotFoundException("Customer not found!");
				}
				// remove customer
				customerRepository.deleteByIdIn(idList);
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	// sử dụng java 8
	public void assignmentCustomer(AssignmentDTO assignmentDTO) throws NotFoundException {
		CustomerEntity customer = Optional.ofNullable(customerRepository.findById(assignmentDTO.getCustomerId()).get())
				                          .orElseThrow(() -> new NotFoundException(SystemConstant.CUSTOMER_NF));

		customer.setUserEntities(Optional.ofNullable(userRepository.findAllById(assignmentDTO.getStaffIds()))
				                 .orElseThrow(() -> new NotFoundException(SystemConstant.CUSTOMER_NF)));
		customerRepository.save(customer);
	}

	// Sử dụng java 7 - task: giao khách hàng cho nhân viên quản lí
	// test ok !
/*	@Override
	public void assignmentCustomer(AssignmentDTO assignmentDTO)  {
		try {
			if (assignmentDTO.getCustomerId() != null) {
				CustomerEntity customerEntity = customerRepository.findById(assignmentDTO.getCustomerId()).get();
				customerEntity.setUserEntities(userRepository.findAllById(assignmentDTO.getStaffIds()));
				customerRepository.save(customerEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error assignmentBuilding service");
		}
	}*/

	@Override
	public CustomerDTO findById(Long id) {
		return id != null ? customerConverter.convertToDto(customerRepository.findById(id).get()) : null;
	}
}