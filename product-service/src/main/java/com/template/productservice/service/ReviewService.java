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
    private final KebabRepository kebabRepository;
    private final UserRepository userRepository;

    @Transactional
    public ReviewDTO addReview(ReviewDTO dto) {
        ReviewEntity review = new ReviewEntity();
        review.setUuid(UUID.randomUUID().toString());
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());

        KebabEntity kebab = kebabRepository.findByUid(dto.getKebabUid())
                .orElseThrow(() -> new EntityNotFoundException("Kebab not found"));

        UserEntity user = userRepository.findByUuid(dto.getUserUuid())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        review.setKebab(kebab);
        review.setUser(user);

        ReviewEntity saved = reviewRepository.save(review);
        return toDTO(saved);
    }

    public List<ReviewDTO> getReviewsByUser(String userUuid) {
        return reviewRepository.findAllByUser_Uuid(userUuid).stream()
                .map(this::toDTO)
                .toList();
    }

    public ReviewDTO getReviewByKebab(String kebabUid) {
        return reviewRepository.findByKebab_Uid(kebabUid)
                .map(this::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Review not found for kebab: " + kebabUid));
    }

    private ReviewDTO toDTO(ReviewEntity entity) {
        return new ReviewDTO(
                entity.getUuid(),
                entity.getContent(),
                entity.getRating(),
                entity.getKebab().getUid(),
                entity.getUser().getUuid()
        );
    }
}
