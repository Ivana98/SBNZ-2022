package sbnz.integracija.workoutrecommender.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDTO {
	private String email;
	private String password;

	private String name;
	private String surname;

	private String bodyType;
	private String activityLevel;
	private int age;
	private double height;
	private double weight;
}
