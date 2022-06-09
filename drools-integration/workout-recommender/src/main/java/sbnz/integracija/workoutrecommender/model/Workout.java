package sbnz.integracija.workoutrecommender.model;

import lombok.*;
import sbnz.integracija.workoutrecommender.model.enums.Equipment;
import sbnz.integracija.workoutrecommender.model.enums.Mood;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutIntensity;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutType;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private double workoutDuration;

    private String name;

    private String link;

    @ElementCollection(targetClass=Equipment.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="workout_equipment")
    @Column(name="equipment")
    private Set<Equipment> equipmentSet;

    @Enumerated(EnumType.STRING)
    private WorkoutIntensity workoutIntensity;

    @Enumerated(EnumType.STRING)
    private WorkoutType workoutType;

    @ElementCollection(targetClass=Mood.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="workout_mood")
    @Column(name="mood")
    private Set<Mood> moodSet;
}
