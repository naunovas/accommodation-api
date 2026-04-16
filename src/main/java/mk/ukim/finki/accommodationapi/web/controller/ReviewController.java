package mk.ukim.finki.accommodationapi.web.controller;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.accommodationapi.model.dto.CreateReviewDto;
import mk.ukim.finki.accommodationapi.model.dto.DisplayReviewDto;
import mk.ukim.finki.accommodationapi.service.application.ReviewApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewApplicationService reviewApplicationService;

    @GetMapping
    public List<DisplayReviewDto> findAll(){
        return reviewApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public DisplayReviewDto findById(@PathVariable Long id){
        return reviewApplicationService.findById(id);
    }

    @PostMapping
    public DisplayReviewDto save(@RequestBody CreateReviewDto dto){
        return reviewApplicationService.save(dto);
    }

    @GetMapping("/average/{accomendationId}")
    public Double findAverageRating(@PathVariable Long accomendationId){
       return  reviewApplicationService.findAverageRatingByAccomendationId(accomendationId);
    }
}
