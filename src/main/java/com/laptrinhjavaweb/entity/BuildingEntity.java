package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
