package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.request.CustomerRequest;
import com.laptrinhjavaweb.dto.response.CustomerResponse;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.ITransactionService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private IUserService userService;

    @GetMapping("/customer-list")
    public ModelAndView customerList(HttpServletRequest request,
                                     @ModelAttribute("customerSearch") CustomerRequest customerRequest) {
        try {
            ModelAndView mav = new ModelAndView("admin/customer/list");
            DisplayTagUtils.of(request, customerRequest);
            Pageable pageable = PageRequest.of(customerRequest.getPage() - 1, customerRequest.getMaxPageItems());
            List<CustomerResponse> pageCustomer = customerService.pageCustomer(pageable, customerRequest);

            customerRequest.setListResult(pageCustomer);
            customerRequest.setTotalItems(customerService.getTotalItems()); // set tổng số item

            mav.addObject("customers", customerRequest);
            mav.addObject("staffs", userService.getAllStaff());  // userService.getAllStaff()
            return mav;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/customer-edit")
    public ModelAndView customerEdit(@RequestParam(name = "customerId", required = false) Long customerId) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");

        if (customerId == null) {
            mav.addObject("customerEdit", new CustomerDTO());
            mav.addObject("staffs", userService.getAllStaff());  // userService.getAllStaff()
            mav.addObject("transactionMap", customerService.transactions());
            mav.addObject("findTransactionByCustomer", transactionService.findAllTransaction());
        } else { // id
            mav.addObject("customerEdit", customerService.findCustomerById(customerId));
            mav.addObject("staffs", userService.getAllStaff());  // userService.getAllSta
            mav.addObject("transactionMap", customerService.transactions());
            mav.addObject("findTransactionByCustomer", transactionService.findTransactionByCustomer(customerId));
            // get transaction to customer
        }
        return mav;
    }
}
