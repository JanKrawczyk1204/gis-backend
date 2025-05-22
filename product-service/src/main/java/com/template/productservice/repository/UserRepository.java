package com.template.productservice.repository;

import com.template.productservice.entity.ReviewEntity;
import com.template.productservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUuid(String uuid);
}
