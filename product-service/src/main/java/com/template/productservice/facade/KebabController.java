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
    public ResponseEntity<KebabDTO> addKebab(@RequestBody KebabDTO kebabDTO) {
        return ResponseEntity.ok(kebabService.addKebab(kebabDTO));
    }

    @GetMapping
    public ResponseEntity<List<KebabDTO>> getAllKebabs() {
        return ResponseEntity.ok(kebabService.getKebabs());
    }

    @GetMapping("/search")
    public ResponseEntity<List<KebabDTO>> getKebabByName(@RequestParam String name) {
        return ResponseEntity.ok(kebabService.getKebabByName(name));
    }
}