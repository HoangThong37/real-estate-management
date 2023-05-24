package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    private UserRepository userRepository;

    // cách 3: sử dụng builder - common search
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> pageCustomer(Pageable pageable, CustomerSearchBuilder builder) {
        try {
            StringBuilder sql = new StringBuilder("SELECT * from customer as c ");
            sql = customerJoinQuerry(builder, sql);
            sql.append(" where 1 = 1 ");
            sql = customerSqlWithBuilder(builder, sql);
            sql.append(" LIMIT ").append(pageable.getPageSize()).append("\n")
               .append(" OFFSET ").append(pageable.getOffset());
            Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
            return query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private StringBuilder customerJoinQuerry(CustomerSearchBuilder builder, StringBuilder sql) {
        if (ValidateUtils.isValid(builder.getStaffId())) {
            sql.append( " inner join assignmentcustomer as ac on ac.building_id = c.id inner " +
                        " join user as u on ab.user_id = u.id ");
        }
        return sql;
    }

    // sử dụng java reflection
    // name, email, phone.
    private StringBuilder customerSqlWithBuilder(CustomerSearchBuilder builder, StringBuilder sql) {
        Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (!fieldName.equals("staffId")) {
                    // getValue
                    Object objectValue = field.get(builder);
                    if (objectValue != null && objectValue != "") {
                        if (objectValue instanceof String) {
                            sql.append(" and c." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sql;
    }
}