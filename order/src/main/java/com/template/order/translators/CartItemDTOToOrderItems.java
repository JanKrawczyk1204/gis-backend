package com.template.order.translators;

import com.template.order.entity.CartItemDTO;
import com.template.order.entity.OrderItems;
import org.springframework.stereotype.Component;

@Component
public class CartItemDTOToOrderItems {

    public OrderItems toOrderItems(CartItemDTO cartItemDTO) {
        return translate(cartItemDTO);
    }

    private OrderItems translate(CartItemDTO cartItemDTO) {
        if (cartItemDTO == null)
            return null;

        OrderItems orderItems = new OrderItems();
        orderItems.setProduct(cartItemDTO.getUuid());
        orderItems.setPriceUnit(cartItemDTO.getPrice());
        orderItems.setPriceSummary(cartItemDTO.getSummaryPrice());
        orderItems.setQuantity(cartItemDTO.getQuantity());
        orderItems.setName(cartItemDTO.getName());

        return orderItems;
    }
}
