package sbnz.integracija.workoutrecommender.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDTO {
    private Long id;
    private double duration;
    private String name;
    private String link;
    private Set<String> equipmentSet;
    private String workoutIntensity;
    private String workoutType;
    private Set<String> moodSet;
}
