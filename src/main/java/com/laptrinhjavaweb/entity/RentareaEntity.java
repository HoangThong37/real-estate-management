package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "rentarea")
public class RentareaEntity extends BaseEntity {

    @Column(name = "value")
    private Integer value;

    @ManyToOne
    @JoinColumn(name="building_id", nullable=false) //cart_id chính là truong khoá phu trong table Item liên k?t v?i khóa chính trong table Cart
    private BuildingEntity building;

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
