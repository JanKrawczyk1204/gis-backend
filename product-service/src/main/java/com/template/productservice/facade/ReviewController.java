package com.template.productservice.facade;

import com.template.productservice.entity.ReviewDTO;
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
        ReviewDTO dto = new ReviewDTO();
        dto.setContent(input.getContent());
        dto.setRating(input.getRating());
        dto.setKebabUid(input.getKebabUid());
        dto.setUserUuid(input.getUserUuid());

        return ResponseEntity.ok(reviewService.addReview(dto));
    }


    @GetMapping("/kebab/{kebabUid}")
    public ResponseEntity<ReviewDTO> getReviewByKebab(@PathVariable String kebabUid) {
        return ResponseEntity.ok(reviewService.getReviewByKebab(kebabUid));
    }

    @GetMapping("/user/{userUuid}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByUser(@PathVariable String userUuid) {
        return ResponseEntity.ok(reviewService.getReviewsByUser(userUuid));
    }
}
