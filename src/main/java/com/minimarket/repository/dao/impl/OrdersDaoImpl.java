package com.minimarket.repository.dao.impl;

import com.minimarket.domain.dto.response.OrderResponseDto;
import com.minimarket.repository.dao.OrdersDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrdersDaoImpl implements OrdersDao {
    private final EntityManager entityManager;

    @Override
    public List findAll(MultiValueMap<String, Object> filter) {

        StringBuilder where = new StringBuilder();

        if (filter.containsKey("customerId") && filter.getFirst("customerId") != null) {
            where.append(" AND t.customer_id = :customerId ");
        }


        String sql = """
                SELECT
                    t.id,
                    t.customer_id,
                    t.status
                FROM orders t
                WHERE TRUE""" + where + """
                 order by t.created_date desc
                """;

        Query query = entityManager.createNativeQuery(sql, OrderResponseDto.class);

        if (filter.containsKey("customerId") && filter.getFirst("customerId") != null) {
            query.setParameter("customerId", filter.get("customerId"));
        }
        return query.getResultList();
    }
}
