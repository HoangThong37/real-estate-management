package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;

import java.sql.SQLException;
import java.util.List;

public interface UserRepositoryCustom {

    List<UserEntity> getAllStaff();
    List<UserEntity> getAllStaffByBuilding(Long buildingId);

}
