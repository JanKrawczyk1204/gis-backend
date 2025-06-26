package com.template.productservice.repository;

import com.template.productservice.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, UUID> {
    List<ReviewEntity> findAllByKebabName(String kebabName);
}
