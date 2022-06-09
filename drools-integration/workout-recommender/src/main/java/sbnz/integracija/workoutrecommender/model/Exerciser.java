package sbnz.integracija.workoutrecommender.model;

import lombok.Getter;
import lombok.Setter;
import sbnz.integracija.workoutrecommender.model.enums.ActivityLevel;
import sbnz.integracija.workoutrecommender.model.enums.BodyType;
import sbnz.integracija.workoutrecommender.security.model.User;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "Exerciser")
@Getter
@Setter
public class Exerciser extends User {
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;

    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

    private int age;
    private double height;
    private double weight;

    public Exerciser() {
        super();
    }

    public Exerciser(String email, String password, String name, String surname, BodyType bodyType, ActivityLevel activityLevel, int age, double height, double weight) {
        super(email, password, name, surname);
        this.bodyType = bodyType;
        this.activityLevel = activityLevel;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
