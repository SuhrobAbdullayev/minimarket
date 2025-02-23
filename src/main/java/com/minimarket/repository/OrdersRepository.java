package com.minimarket.repository;

import com.minimarket.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders findAllByCustomerId(Long customerId);
}