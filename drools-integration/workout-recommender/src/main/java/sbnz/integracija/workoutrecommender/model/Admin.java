package sbnz.integracija.workoutrecommender.model;

import lombok.Getter;
import lombok.Setter;
import sbnz.integracija.workoutrecommender.model.enums.ActivityLevel;
import sbnz.integracija.workoutrecommender.model.enums.BodyType;
import sbnz.integracija.workoutrecommender.security.model.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
@Getter
@Setter
public class Admin extends User {
    public Admin() {
        super();
    }

    public Admin(String email, String password, String name, String surname) {
        super(email, password, name, surname);
    }
}
