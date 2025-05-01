package com.template.order.service;

import com.template.order.entity.DeliverDTO;
import com.template.order.repository.DeliverRepository;
import com.template.order.translators.DeliverToDeliverDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliverService {

    private final DeliverRepository deliverRepository;
    private final DeliverToDeliverDTO deliverToDeliverDTO;

    public List<DeliverDTO> getAllDeliver() {
       return deliverRepository.findAll().stream().map(deliverToDeliverDTO::deliverDTO).collect(Collectors.toList());
    }
}
