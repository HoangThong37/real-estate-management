//package com.laptrinhjavaweb.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "assignmentbuilding")
//public class AssignBuildingEntity extends BaseEntity {
//
//    @ManyToOne()
//    @JoinColumn(name="building_id", nullable=false ) //cart_id chính là truong khoá phu trong table Item liên k?t v?i khóa chính trong table Cart
//    private BuildingEntity building;
//
//    @ManyToOne
//    @JoinColumn(name="user_id", nullable=false) //cart_id chính là truong khoá phu trong table Item liên k?t v?i khóa chính trong table Cart
//    private UserEntity user;
//
//    public UserEntity getUser() {
//        return user;
//    }
//
//    public void setUser(UserEntity user) {
//        this.user = user;
//    }
//
//    public BuildingEntity getBuilding() {
//        return building;
//    }
//
//    public void setBuilding(BuildingEntity building) {
//        this.building = building;
//    }
//}