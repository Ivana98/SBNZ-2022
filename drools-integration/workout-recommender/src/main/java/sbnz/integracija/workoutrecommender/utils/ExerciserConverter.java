package sbnz.integracija.workoutrecommender.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sbnz.integracija.workoutrecommender.model.Exerciser;
import sbnz.integracija.workoutrecommender.model.dto.ExerciserUpdateDTO;
import sbnz.integracija.workoutrecommender.model.enums.ActivityLevel;
import sbnz.integracija.workoutrecommender.model.enums.BodyType;
import sbnz.integracija.workoutrecommender.security.model.RegistrationRequestDTO;

@Component
@AllArgsConstructor
public class ExerciserConverter {
    public Exerciser dtoToNewEntity(RegistrationRequestDTO request) {
        return new Exerciser(
                request.getEmail(),
                request.getPassword(),
                request.getName(),
                request.getSurname(),
                BodyType.valueOf(request.getBodyType()),
                ActivityLevel.valueOf(request.getActivityLevel()),
                request.getAge(),
                request.getHeight(),
                request.getWeight()
        );
    }

    public Exerciser updateEntity(ExerciserUpdateDTO dto, Exerciser e) {
        e.setName(dto.getName());
        e.setSurname(dto.getSurname());
        e.setBodyType(BodyType.valueOf(dto.getBodyType()));
        e.setActivityLevel(ActivityLevel.valueOf(dto.getActivityLevel()));
        e.setAge(dto.getAge());
        e.setHeight(dto.getWeight());
        e.setWeight(dto.getWeight());
        return e;
    }
}
