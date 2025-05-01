package com.template.order.repository;

import com.template.order.entity.Order;
import com.template.order.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<OrderItems,Long> {
    List<OrderItems> findOrderItemsByOrder(Order order);
}
