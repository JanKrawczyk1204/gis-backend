package com.template.productservice.facade;

import com.template.productservice.entity.ReviewDTO;
import com.template.productservice.entity.ReviewEntity;
import com.template.productservice.entity.ReviewInputDTO;
import com.template.productservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> addReview(@RequestBody ReviewInputDTO input) {
        return ResponseEntity.ok(reviewService.addReview(input));
    }

    @GetMapping("/kebab/{kebabName}")
    public List<ReviewEntity> getReviewsByKebab(@PathVariable String kebabName) {
        return reviewService.getReviewsByKebabName(kebabName);
    }
}