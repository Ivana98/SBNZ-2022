package sbnz.integracija.workoutrecommender.model.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class OutputDataDTO {
    private List<WorkoutDTO> recommendedWorkouts;
    private String advice;
}
