package com.template.order.service;

import com.template.order.entity.Order;
import com.template.order.entity.OrderItemDTO;
import com.template.order.entity.OrderItems;
import com.template.order.repository.ItemRepository;
import com.template.order.translators.OrderItemTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public OrderItems save(OrderItems items) {
        return itemRepository.saveAndFlush(items);
    }

    public List<OrderItems> getByOrder(Order order) {
        return itemRepository.findOrderItemsByOrder(order);
    }

    public List<OrderItemDTO> getOrderItemsByOrder(Order order) {
        List<OrderItems> orderItems = itemRepository.findOrderItemsByOrder(order);
        return orderItems.stream().map(item -> {
            OrderItemDTO dto = new OrderItemDTO();
            dto.setProduct(item.getProduct());
            dto.setUuid(item.getUuid());
            dto.setName(item.getName());
            dto.setQuantity(item.getQuantity());
            dto.setPriceUnit(item.getPriceUnit());
            dto.setPriceSummary(dto.getPriceUnit() * dto.getQuantity());
            return dto;
        }).toList();
    }
}
