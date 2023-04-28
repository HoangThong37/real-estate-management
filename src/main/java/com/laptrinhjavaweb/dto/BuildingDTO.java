package com.laptrinhjavaweb.dto;

public class BuildingDTO extends AbstractDTO<BuildingDTO> {

    private String name;
    private String numberOfBasement; // số tầng hầm
    private String buildingArea;
    private String street;
    private String ward;
    private String district;
    private Long staffId;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    //    private String district;
//    private String structure;
//    private Integer costRent;
//    private String costDescription;
//    private String serviceCost;
//    private String carCost;
//    private String motorbikeCost;
//    private String overtimeCost;
//    private String[] buildingTypes = new String[] {};
//    private String costRentFrom;
//    private String costRentTo;
//    private String areaRentFrom;
//    private String areaRentTo;
//    private String staffId;
//    private String electricityCost;
//    private String deposit;
//    private String payment;
//    private String timeRent;
//    private String timeDecorator;
//    private String areaRent;
//    private String address;
//    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(String numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}