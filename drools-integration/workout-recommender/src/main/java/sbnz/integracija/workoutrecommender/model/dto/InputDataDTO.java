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
public class InputDataDTO {
    private double maxDuration;
    private String bodyType;
    private Set<String> equipmentSet;
    private String activityLevel;
    private String currentMood;
    private int age;
    private double height;
    private double weight;
}
