package sbnz.integracija.workoutrecommender.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciserUpdateDTO {
    private Long id;
    private String name;
    private String surname;

    private String bodyType;
    private String activityLevel;
    private int age;
    private double height;
    private double weight;
}
