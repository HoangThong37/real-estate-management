package com.laptrinhjavaweb.api.admin;
import com.laptrinhjavaweb.dto.AssignmentDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.IUserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPI {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IUserService userService;

    // create, update
    @PostMapping
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customer) throws NotFoundException {
       return ResponseEntity.ok(customerService.save(customer));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@RequestBody List<Long> ids) throws NotFoundException {
        if (ids.size() > 0) {
            customerService.delete(ids);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findOneCustomer(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(customerService.findById(id));
    }

    // api load staff
    @GetMapping("/{id}/staff")
    public List<StaffResponseDTO> loadStaffByCustomer(@PathVariable("id") Long id) {
        return userService.finAllStaffByCustomer(id);
    }

    // assignment customer by staff
    @PostMapping("/assignment")
    public Long assignmentBuilding(@RequestBody(required = false) AssignmentDTO assignmentDTO) {
        customerService.assignmentCustomer(assignmentDTO);
        return assignmentDTO.getCustomerId();
    }
}