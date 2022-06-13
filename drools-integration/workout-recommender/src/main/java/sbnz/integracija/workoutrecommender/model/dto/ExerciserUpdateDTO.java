package sbnz.integracija.workoutrecommender.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
