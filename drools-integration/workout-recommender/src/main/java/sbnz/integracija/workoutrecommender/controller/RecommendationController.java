package sbnz.integracija.workoutrecommender.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sbnz.integracija.workoutrecommender.model.dto.InputDataDTO;
import sbnz.integracija.workoutrecommender.model.dto.OutputDataDTO;
import sbnz.integracija.workoutrecommender.service.RecommendationService;

@RestController
@RequestMapping(value = "/recommendation")
@AllArgsConstructor
public class RecommendationController {
	
	private final RecommendationService recommendationService;
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutputDataDTO> getRecommendation(@RequestBody InputDataDTO dto) {
		OutputDataDTO recommendation = recommendationService.getRecommendation(dto);
        return new ResponseEntity<>(recommendation, HttpStatus.OK);
    }

}
