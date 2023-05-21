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

    @Override
    public List<RentareaEntity> findByRentArea(Long id) {
        StringBuilder sql = new StringBuilder("select * from rentarea as r  inner join building as b on r.building_id = b.id ");
        sql.append(" where b.id =  ").append(id);

        Query query = entityManager.createNativeQuery(sql.toString(), RentareaEntity.class);
        return query.getResultList();
    }

}


