package sbnz.integracija.workoutrecommender.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class InputDataDTO {
    private double maxDuration;
    private String bodyType;
    private Set<String> equipmentSet;
    private String activityLevel;
    private int currentMood;
    private int age;
    private double height;
    private double weight;
}
