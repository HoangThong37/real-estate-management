package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentareaEntity;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Override
    @Transactional
    public void saveRentAreas(List<RentareaEntity> listRentAreaEntity, BuildingEntity buildingEntity) {
        List<RentareaEntity> rentareas = new ArrayList<>();
        if (listRentAreaEntity.size() > 0) {
            for (RentareaEntity item : listRentAreaEntity) {
                rentareas.add(item);
            }
        }
        List<RentareaEntity> rentareaEntities = rentAreaRepository.findByBuilding(buildingEntity) ;

        if (rentareas.size() > 0) {
            for (RentareaEntity item : rentareaEntities) {
                 entityManager.remove(item);
            }

            for (RentareaEntity rentarea : rentareas) {
                entityManager.persist(rentarea);
            }
        }
    }

//    @Transactional
//    @Override
//    public void saveAllByBuilding(List<RentareaEntity> rentAreaEntitis, BuildingEntity buildingEntity) {
//        List<RentareaEntity> rentAreaEntityListByBuilding = new ArrayList<>();
//        if (buildingEntity.getRentareas().size() > 0){ // đây
//            //List<RentareaEntity> listRentarea = rentAreaRepository.findByRentArea(buildingEntity.getId());
//
//            for (RentareaEntity item : rentAreaEntitis) {
//                rentAreaEntityListByBuilding.add(item);
//            }
//        }
//
//        if(rentAreaEntitis.size() > 0) {  // remove nên phải check dưới db coi có ko
//            rentAreaEntityListByBuilding.forEach(item-> {
//                entityManager.remove(item);
//            });
//            rentAreaEntitis.forEach(item->{  //
//                entityManager.persist(item);
//            });
//        }
//    }

    @Override
    public List<RentareaEntity> findByRentArea(Long id) {
        StringBuilder sql = new StringBuilder("select * from rentarea as r  inner join building as b on r.building_id = b.id ");
        sql.append(" where b.id =  ").append(id);

        Query query = entityManager.createNativeQuery(sql.toString(), RentareaEntity.class);
        return query.getResultList();
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

