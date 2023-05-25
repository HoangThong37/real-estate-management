package com.laptrinhjavaweb.dto;

import java.util.List;

public class CustomerDTO extends AbstractDTO {

    private String fullName;
    private String phone;
    private String email;
    private String note;
    private String requirement;
    private String company;
    private List<UserDTO> userDTOS;
   // private List<Transaction> userDTOS;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
