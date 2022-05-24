package sbnz.integracija.workoutrecommender.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OutputDataDTO {
    private List<WorkoutDTO> recommendedWorkouts;
    private String advice;
}
