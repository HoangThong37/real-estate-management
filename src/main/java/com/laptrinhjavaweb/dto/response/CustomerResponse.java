package com.laptrinhjavaweb.dto.response;

import com.laptrinhjavaweb.dto.AbstractDTO;

public class CustomerResponse extends AbstractDTO {

    private String fullName;        // tên kh
    private String staffName;       // nv quản lí
    private String phone;           // phone staff
    private String email;           // email
    private String requirement;
    private String status;          // tình trạng

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
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

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
