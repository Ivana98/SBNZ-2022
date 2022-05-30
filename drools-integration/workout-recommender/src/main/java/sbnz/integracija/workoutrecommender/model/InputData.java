package sbnz.integracija.workoutrecommender.model;

import lombok.*;
import sbnz.integracija.workoutrecommender.model.enums.ActivityLevel;
import sbnz.integracija.workoutrecommender.model.enums.BodyType;
import sbnz.integracija.workoutrecommender.model.enums.Equipment;
import sbnz.integracija.workoutrecommender.model.enums.Mood;

import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputData {
    private double maxDuration;
    private BodyType bodyType;
    private Set<Equipment> equipmentSet;
    private ActivityLevel activityLevel;
    private Mood currentMood;
    private int age;
    private double height;
    private double weight;
}
