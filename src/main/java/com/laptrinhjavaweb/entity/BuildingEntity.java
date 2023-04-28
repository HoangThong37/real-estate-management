package com.laptrinhjavaweb.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    private static final long serialVersionUID = -6525302831793188081L;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_basement")
    private String numberOfBasement; // số tầng hầm

    @Column(name = "buildingarea")
    private String buildingArea;   // khu vực xây dựng

    @Column(name = "street")
    private String street;    // đường

    @Column(name = "ward")
    private String ward;  // phường


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




/*
package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    private static final long serialVersionUID = -6525302831793188081L;

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;    // đường

    @Column(name = "ward")
    private String ward;  // phường

    @Column(name = "district")
    private String district;  // quận

    @Column(name = "structure")
    private String structure;  // kết cấu

    @Column(name = "numberofbasement")
    private Integer numberOfBasement;  // số tầng hầm

    @Column(name = "floorarea")
    private Integer floorArea;  // diện tích sàn

    @Column(name = "direction")
    private String direction;  // phương hướng

    @Column(name = "level")
    private String level;  // hạng

    @Column(name = "rentprice")
    private Integer rentPrice;  // số tầng hầm

    @Column(name = "rentpricedescription")
    private String rentPriceDescription;  // mô tả giá thuê

    @Column(name = "servicefee")
    private String serviceFee;  // phí dịch vụ

    @Column(name = "carfee")
    private String carFee;  // phí ô tô

    @Column(name = "motofee")
    private String motoFee;  // phí xe máy

    @Column(name = "overtimefee")
    private String overtimeFee;  // phí ngoài giờ

    @Column(name = "waterfee")
    private String waterFee;  // phí nước

    @Column(name = "electricityfee")
    private String electricityFee;  // Giá điện

    @Column(name = "deposit")
    private String deposit;  // tiền gửi

    @Column(name = "payment")
    private String payment;  // sự chi trả

    @Column(name = "renttime")
    private String renttime;  // thời gian thuê

    @Column(name = "decorationtime")
    private String decorationtime;  // thời gian trang trí

    @Column(name = "brokeragetee")
    private DecimalFormat brokeragetee;  // người môi giới

    @Column(name = "type")
    private List<String> type;  // loại tòa nhà

    @Column(name = "note")
    private String note;  // GHI CHÚ

    @Column(name = "managername")
    private String managerName;  // tên quản lí

    @Column(name = "managerphone")
    private String managerPhone;  // số điện thoiaji quản lí


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getRentPriceDescription() {
        return rentPriceDescription;
    }

    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getCarFee() {
        return carFee;
    }

    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }

    public String getMotoFee() {
        return motoFee;
    }

    public void setMotoFee(String motoFee) {
        this.motoFee = motoFee;
    }

    public String getOvertimeFee() {
        return overtimeFee;
    }

    public void setOvertimeFee(String overtimeFee) {
        this.overtimeFee = overtimeFee;
    }

    public String getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(String waterFee) {
        this.waterFee = waterFee;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRenttime() {
        return renttime;
    }

    public void setRenttime(String renttime) {
        this.renttime = renttime;
    }

    public String getDecorationtime() {
        return decorationtime;
    }

    public void setDecorationtime(String decorationtime) {
        this.decorationtime = decorationtime;
    }

    public DecimalFormat getBrokeragetee() {
        return brokeragetee;
    }

    public void setBrokeragetee(DecimalFormat brokeragetee) {
        this.brokeragetee = brokeragetee;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
}
*/
