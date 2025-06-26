package com.template.productservice.service;

import com.template.productservice.entity.*;
import com.template.productservice.repository.KebabRepository;
import com.template.productservice.repository.ReviewRepository;
import com.template.productservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public ReviewDTO addReview(ReviewInputDTO input) {
        ReviewEntity review = new ReviewEntity();
        review.setUuid(UUID.randomUUID().toString());
        review.setContent(input.getContent());
        review.setRating(input.getRating());
        review.setKebabName(input.getKebabName());
        review.setUserLogin(input.getUserLogin());

        ReviewEntity saved = reviewRepository.save(review);
        return toDTO(saved);
    }

    public List<ReviewEntity> getReviewsByKebabName(String kebabName) {
        return reviewRepository.findAllByKebabName(kebabName);
    }

    private ReviewDTO toDTO(ReviewEntity entity) {
        return new ReviewDTO(
                entity.getUuid(),
                entity.getContent(),
                entity.getRating(),
                entity.getKebabName(),
                entity.getUserLogin()
        );
    }
}

