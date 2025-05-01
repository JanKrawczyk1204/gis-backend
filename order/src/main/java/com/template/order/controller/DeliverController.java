package com.template.order.controller;


import com.template.order.entity.DeliverDTO;
import com.template.order.service.DeliverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/deliver")
@RequiredArgsConstructor
public class DeliverController {

    private final DeliverService deliverService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DeliverDTO> getDeliver() {
        return deliverService.getAllDeliver();
    }
}
