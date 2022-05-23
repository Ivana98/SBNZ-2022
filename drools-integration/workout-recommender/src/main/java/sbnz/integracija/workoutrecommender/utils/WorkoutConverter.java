package sbnz.integracija.workoutrecommender.utils;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import sbnz.integracija.workoutrecommender.model.Workout;
import sbnz.integracija.workoutrecommender.model.dto.WorkoutDTO;
import sbnz.integracija.workoutrecommender.model.enums.Equipment;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutIntensity;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutType;

@Component
public class WorkoutConverter {

	public Workout dtoToEntity(WorkoutDTO dto) {
        return  Workout.builder()
                .id(dto.getId())
                .duration(dto.getDuration())
                .name(dto.getName())
                .link(dto.getLink())
                .workoutIntensity(WorkoutIntensity.valueOf(dto.getWorkoutIntensity()))
                .workoutType(WorkoutType.valueOf(dto.getWorkoutType()))
                .equipmentSet(
                		dto.getEquipmentSet().stream().map(value -> Equipment.valueOf(value)).collect(Collectors.toSet()))
                .build();
    }

    public WorkoutDTO entityToDto(Workout workout) {
    	return  WorkoutDTO.builder()
                .id(workout.getId())
                .duration(workout.getDuration())
                .name(workout.getName())
                .link(workout.getLink())
                .workoutIntensity(workout.getWorkoutIntensity().toString())
                .workoutType(workout.getWorkoutType().toString())
                .equipmentSet(
                		workout.getEquipmentSet().stream().map(value -> value.toString()).collect(Collectors.toSet()))
                .build();
    }

    public Workout dtoToNewEntity(WorkoutDTO dto) {
    	return  Workout.builder()
                .duration(dto.getDuration())
                .name(dto.getName())
                .link(dto.getLink())
                .workoutIntensity(WorkoutIntensity.valueOf(dto.getWorkoutIntensity()))
                .workoutType(WorkoutType.valueOf(dto.getWorkoutType()))
                .equipmentSet(
                		dto.getEquipmentSet().stream().map(value -> Equipment.valueOf(value)).collect(Collectors.toSet()))
                .build();
    }
	
}
