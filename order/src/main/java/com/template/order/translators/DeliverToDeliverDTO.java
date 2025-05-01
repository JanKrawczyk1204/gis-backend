package com.template.order.translators;

import com.template.order.entity.Deliver;
import com.template.order.entity.DeliverDTO;
import org.springframework.stereotype.Component;

@Component
public class DeliverToDeliverDTO {

    public DeliverDTO deliverDTO(Deliver deliver) {
        return translate(deliver);
    }

    private DeliverDTO translate(Deliver deliver) {
        if (deliver == null)
            return null;

        DeliverDTO deliverDTO = new DeliverDTO();
        deliverDTO.setUuid(deliver.getUuid());
        deliverDTO.setName(deliver.getName());
        deliverDTO.setPrice(deliver.getPrice());

        return deliverDTO;
    }
}