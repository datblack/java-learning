package com.example.criteriasearch.repository;

import com.example.criteriasearch.model.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> , JpaSpecificationExecutor<OrderProduct> {
}
