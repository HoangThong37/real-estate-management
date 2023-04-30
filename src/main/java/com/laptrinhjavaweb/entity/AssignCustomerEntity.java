package com.laptrinhjavaweb.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assignmentcustomer")
public class AssignCustomerEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="staff_id", nullable=false) //cart_id chính là truong khoá phu trong table Item liên k?t v?i khóa chính trong table Cart
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable=false)
    private CustomerEntity customer;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
