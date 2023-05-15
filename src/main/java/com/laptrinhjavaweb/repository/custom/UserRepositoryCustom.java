package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {

    List<UserEntity> getAllStaff();
    List<UserEntity> getAllStaffByBuilding(Long buildingId);

    List<UserEntity> getAllUsers(Pageable pageable);
    int countTotalItem();

}
