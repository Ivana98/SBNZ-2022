package sbnz.integracija.workoutrecommender.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OutputDataDTO {
    private List<WorkoutDTO> recommendedWorkouts;
    private String advice;
}
