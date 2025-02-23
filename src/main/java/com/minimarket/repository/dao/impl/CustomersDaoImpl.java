package com.minimarket.repository.dao.impl;

import com.minimarket.domain.dto.response.CustomerResponseDto;
import com.minimarket.repository.dao.CustomersDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomersDaoImpl implements CustomersDao {
    private final EntityManager entityManager;

    @Override
    public List findAll(MultiValueMap<String, Object> filter) {

        StringBuilder where = new StringBuilder();

        if (filter.containsKey("name") && filter.getFirst("name") != null) {
            where.append(" AND t.name ilike '%' || :name || '%' ");
        }


        String sql = """
                SELECT
                    t.id,
                    t.name
                FROM customers t
                WHERE TRUE""" + where + """
                 order by t.created_date desc
                """;

        Query query = entityManager.createNativeQuery(sql, CustomerResponseDto.class);

        if (filter.containsKey("name") && filter.getFirst("name") != null) {
            query.setParameter("name", filter.get("name"));
        }
        return query.getResultList();
    }
}
