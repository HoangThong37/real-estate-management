package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "assignmentbuilding")
public class AssignBuildingEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private BuildingEntity building;

    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
}
