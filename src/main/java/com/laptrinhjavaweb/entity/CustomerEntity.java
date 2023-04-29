package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    // giao tòa nhà cho nv
    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<AssignCustomerEntity> customers;

    // 1 - n transaction
    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<TransactionEntity> transactions;

    public List<AssignCustomerEntity> getCustomers() {
        return customers;
    }

    public void setCustomers(List<AssignCustomerEntity> customers) {
        this.customers = customers;
    }

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
