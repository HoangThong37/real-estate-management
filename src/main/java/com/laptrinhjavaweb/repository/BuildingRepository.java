package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuildingRepository extends BuildingRepositoryCustom, JpaRepository<BuildingEntity, Long> {
    BuildingEntity findById(Long id);
    // void deleteByIdIn(List<Long> ids);

    @Query(value="select count(*) from building", nativeQuery = true)
    long countAllBuilding();

    void deleteByIdIn(List<Long> ids);
}
