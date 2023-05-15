package com.laptrinhjavaweb.dto.request;

import java.util.ArrayList;
import java.util.List;

public class BuildingDeleteRequest {

    private List<Long> buildingId = new ArrayList<>();

    public List<Long> getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(List<Long> buildingId) {
        this.buildingId = buildingId;
    }
}
