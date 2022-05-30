package sbnz.integracija.workoutrecommender.utils;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import sbnz.integracija.workoutrecommender.model.InputData;
import sbnz.integracija.workoutrecommender.model.dto.InputDataDTO;
import sbnz.integracija.workoutrecommender.model.enums.ActivityLevel;
import sbnz.integracija.workoutrecommender.model.enums.BodyType;
import sbnz.integracija.workoutrecommender.model.enums.Equipment;
import sbnz.integracija.workoutrecommender.model.enums.Mood;

@Component
@AllArgsConstructor
public class InputDataConverter {
	
	public InputData dtoToNewEntity(InputDataDTO dto) {
        return InputData.builder()
                .maxDuration(dto.getMaxDuration())
                .bodyType(BodyType.valueOf(dto.getBodyType()))
                .equipmentSet(
                		dto.getEquipmentSet().stream().map(value -> Equipment.valueOf(value)).collect(Collectors.toSet()))
                .activityLevel(ActivityLevel.valueOf(dto.getActivityLevel()))
                .currentMood(Mood.valueOf(dto.getCurrentMood()))
                .age(dto.getAge())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .build();
    }


}
