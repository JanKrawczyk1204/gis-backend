package com.template.productservice.facade;

import com.template.productservice.entity.*;
import com.template.productservice.service.KebabService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/kebab")
@RequiredArgsConstructor
public class KebabController {

    private final KebabService kebabService;

    @PostMapping
    public ResponseEntity<KebabDTO> addKebab(@RequestBody KebabInputDTO kebabInput) {
        KebabDTO kebabDTO = new KebabDTO();
        kebabDTO.setName(kebabInput.getName());
        kebabDTO.setLocationX(kebabInput.getLocationX());
        kebabDTO.setLocationY(kebabInput.getLocationY());
        kebabDTO.setRating(kebabInput.getRating());
        kebabDTO.setHours(kebabInput.getHours());
        kebabDTO.setAddress(kebabInput.getAddress());

        return ResponseEntity.ok(kebabService.addKebab(kebabDTO));
    }


    @GetMapping
    public ResponseEntity<List<KebabResponseDTO>> getAllKebabs() {
        List<KebabDTO> kebabs = kebabService.getKebabs();

        List<KebabResponseDTO> response = kebabs.stream()
                .map(kebab -> {
                    KebabResponseDTO dto = new KebabResponseDTO();
                    dto.setName(kebab.getName());
                    dto.setLocation(List.of(kebab.getLocationX(), kebab.getLocationY()));
                    dto.setHours(kebab.getHours());
                    dto.setRating(kebab.getRating());
                    dto.setAddress(kebab.getAddress());
                    return dto;
                })
                .toList();

        return ResponseEntity.ok(response);
    }


    @GetMapping("/search")
    public ResponseEntity<List<KebabDTO>> getKebabByName(@RequestParam String name) {
        return ResponseEntity.ok(kebabService.getKebabByName(name));
    }
}