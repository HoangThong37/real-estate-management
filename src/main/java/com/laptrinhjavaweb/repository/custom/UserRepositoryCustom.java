package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {

    List<UserEntity> getAllStaff();
    List<UserEntity> getAllStaffByBuilding(Long buildingId);

}
