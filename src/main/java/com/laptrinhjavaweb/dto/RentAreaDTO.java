package com.laptrinhjavaweb.dto;

public class RentAreaDTO extends AbstractDTO {

    private Integer value;
    private Long buildingid;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Long buildingid) {
        this.buildingid = buildingid;
    }
}
