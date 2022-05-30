package sbnz.integracija.workoutrecommender.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sbnz.integracija.workoutrecommender.model.enums.Equipment;
import sbnz.integracija.workoutrecommender.model.enums.Mood;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutIntensity;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutType;

import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    private Long id;
    private double workoutDuration;
    private String name;
    private String link;
    private Set<Equipment> equipmentSet;
    private WorkoutIntensity workoutIntensity;
    private WorkoutType workoutType;
    private Set<Mood> moodSet;
}
