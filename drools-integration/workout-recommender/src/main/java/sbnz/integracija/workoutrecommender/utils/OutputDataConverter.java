package sbnz.integracija.workoutrecommender.utils;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import sbnz.integracija.workoutrecommender.model.ProcessInfo;
import sbnz.integracija.workoutrecommender.model.dto.OutputDataDTO;

@Component
@AllArgsConstructor
public class OutputDataConverter {
	
	private final WorkoutConverter workoutConverter;
	
	public OutputDataDTO entityToDto(ProcessInfo info) {
    	return  OutputDataDTO.builder()
                .advice(info.getAdvice())
                .recommendedWorkouts(
                		info.getFilteredWorkouts().stream().map(value -> workoutConverter.entityToDto(value)).collect(Collectors.toList()))
                .build();
    }

}
