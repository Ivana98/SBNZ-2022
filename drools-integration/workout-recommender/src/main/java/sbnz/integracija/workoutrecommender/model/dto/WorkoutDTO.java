package sbnz.integracija.workoutrecommender.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
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
