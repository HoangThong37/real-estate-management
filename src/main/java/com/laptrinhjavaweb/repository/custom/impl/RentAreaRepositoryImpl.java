package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentareaEntity;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    RentAreaRepository rentAreaRepository;

    @Transactional
    @Override
    public void saveAllByBuilding(List<RentareaEntity> rentAreaEntitis, BuildingEntity buildingEntity) {
        List<RentareaEntity> rentAreaEntityListByBuilding = new ArrayList<>();
        if (buildingEntity.getRentareas().size() > 0){
            rentAreaEntityListByBuilding = rentAreaRepository.findByBuilding(buildingEntity);
        }

        if(rentAreaEntitis.size() > 0){
            rentAreaEntityListByBuilding.forEach(item->{
                entityManager.remove(item);
            });
            rentAreaEntitis.forEach(item->{
                entityManager.persist(item);
            });
        }
    }

//    @Autowired
//    RentAreaRepository rentAreaRepo;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    @Transactional
//    public void saveAllByBuilding(List<RentareaEntity> listRentArea, BuildingEntity buildingEntity) {
//        List<RentareaEntity> listRentAreas = new ArrayList<>();
//        if (buildingEntity.getRentareas().size() > 0) {
//             listRentAreas = rentAreaRepo.findByBuilding(buildingEntity);
//        }
//        listRentAreas.forEach(item -> {
//            entityManager.remove(item);
//        });
//
//        listRentArea.forEach(item -> {
//            entityManager.persist(listRentArea);
//        });
//    }
}
