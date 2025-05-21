package com.template.productservice.service;

import com.template.productservice.entity.KebabDTO;
import com.template.productservice.entity.KebabEntity;
import com.template.productservice.repository.KebabRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class KebabService {
    private static final Logger logger = LoggerFactory.getLogger(KebabService.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${file-service.url}")
    private String FILE_SERVICE;
    private final KebabRepository kebabRepository;

    @Transactional
    public KebabDTO addKebab(KebabDTO kebabDTO) {
        KebabEntity entity = new KebabEntity();
        entity.setUid(UUID.randomUUID().toString());
        entity.setName(kebabDTO.getName());
        entity.setLocationX(kebabDTO.getLocationX());
        entity.setLocationY(kebabDTO.getLocationY());
        entity.setRating(kebabDTO.getRating());
        entity.setHours(kebabDTO.getHours());
        entity.setAddress(kebabDTO.getAddress());

        KebabEntity saved = kebabRepository.save(entity);

        KebabDTO result = new KebabDTO();
        result.setUid(saved.getUid());
        result.setName(saved.getName());
        result.setLocationX(saved.getLocationX());
        result.setLocationY(saved.getLocationY());
        result.setRating(saved.getRating());
        result.setHours(saved.getHours());
        result.setAddress(saved.getAddress());
        return result;
    }

    public List<KebabDTO> getKebabByName(String name) {
        return kebabRepository.findByName(name)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public List<KebabDTO> getKebabs() {
        return kebabRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private KebabDTO toDTO(KebabEntity entity) {
        KebabDTO dto = new KebabDTO();
        dto.setUid(entity.getUid());
        dto.setName(entity.getName());
        dto.setLocationX(entity.getLocationX());
        dto.setLocationY(entity.getLocationY());
        dto.setRating(entity.getRating());
        dto.setHours(entity.getHours());
        dto.setAddress(entity.getAddress());
        return dto;
    }

}