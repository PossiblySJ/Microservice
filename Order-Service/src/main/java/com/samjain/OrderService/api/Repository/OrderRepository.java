package com.samjain.OrderService.api.Repository;

import com.samjain.OrderService.api.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
