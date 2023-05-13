package com.laptrinhjavaweb.dto.request;

import java.util.ArrayList;
import java.util.List;

public class AssignmentBuildingRequest {

    private List<Integer> staffIds = new ArrayList<>();

    public List<Integer> getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(List<Integer> staffIds) {
        this.staffIds = staffIds;
    }
}
