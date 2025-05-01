package com.template.order.translators;

import com.template.order.entity.Items;
import com.template.order.entity.OrderItems;
import org.springframework.stereotype.Component;

@Component
public class OrderItemsToItems {

    public Items toItems(OrderItems orderItems) {
        return translate(orderItems);
    }

    private Items translate(OrderItems orderItems) {
        if (orderItems == null)
            return null;

        Items items = new Items();
        items.setUuid(orderItems.getUuid());
        items.setName(orderItems.getName());
        items.setQuantity(orderItems.getQuantity());
        items.setPrice(orderItems.getPriceUnit());
        items.setSummaryPrice(orderItems.getQuantity() * items.getPrice());
        return items;
    }
}
