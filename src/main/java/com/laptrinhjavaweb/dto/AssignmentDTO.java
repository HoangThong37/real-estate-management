package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class AssignmentDTO {

    private Long buildingid;
    private List<Long> staffIds = new ArrayList<>();
    private Long customerId;

    public Long getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Long buildingid) {
        this.buildingid = buildingid;
    }

    public List<Long> getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(List<Long> staffIds) {
        this.staffIds = staffIds;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
