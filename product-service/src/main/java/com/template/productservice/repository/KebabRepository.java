package com.template.productservice.repository;

import com.template.productservice.entity.KebabEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface KebabRepository extends JpaRepository<KebabEntity, Long> {

    @Query(nativeQuery = true,value = "SELECT count(*) from kebab")
    long countKebabs();
    List<KebabEntity> findByName(String name);
    Optional<KebabEntity> findByUid(String uuid);
}