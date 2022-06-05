package sbnz.integracija.workoutrecommender.model;

import lombok.*;
import sbnz.integracija.workoutrecommender.model.enums.Equipment;
import sbnz.integracija.workoutrecommender.model.enums.WeightStatus;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutIntensity;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutType;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessInfo {
    private WeightStatus weightStatus;
    private String advice;
    private Set<Equipment> equipmentSet;
    private double bmi;
    private WorkoutType workoutType;
    private WorkoutIntensity workoutIntensity;
    private List<Workout> filteredWorkouts;
    private List<Workout> sortedWorkouts;

    public void addSortedWorkout(Workout workout) {
        this.sortedWorkouts.add(workout);
    }
}
