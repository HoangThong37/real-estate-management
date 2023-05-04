package com.laptrinhjavaweb.dto.response;

import com.laptrinhjavaweb.dto.BuildingSearchParent;

public class BuildingSearchResponse extends BuildingSearchParent {

    private String name;            // tên sản phẩm
    private String address;         // địa chỉ
    private String managerName;     // tên quản lí
    private Integer managerPhone;   // số điện thoại
    private String floorArea;       // diện tích sàn
    private String emptyArea;       // diện tích trống
    private String rentCost;        // giá thuê
    private String serviceFee;      // phí dịch vụ
    private String brokerageFee;    // phí môi giới

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Integer getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(Integer managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(String floorArea) {
        this.floorArea = floorArea;
    }

    public String getEmptyArea() {
        return emptyArea;
    }

    public void setEmptyArea(String emptyArea) {
        this.emptyArea = emptyArea;
    }

    public String getRentCost() {
        return rentCost;
    }

    public void setRentCost(String rentCost) {
        this.rentCost = rentCost;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(String brokerageFee) {
        this.brokerageFee = brokerageFee;
    }
}
