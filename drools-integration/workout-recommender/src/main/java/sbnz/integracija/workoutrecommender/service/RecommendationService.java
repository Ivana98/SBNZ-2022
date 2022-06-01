package sbnz.integracija.workoutrecommender.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import sbnz.integracija.workoutrecommender.model.InputData;
import sbnz.integracija.workoutrecommender.model.ProcessInfo;
import sbnz.integracija.workoutrecommender.model.Workout;
import sbnz.integracija.workoutrecommender.model.dto.InputDataDTO;
import sbnz.integracija.workoutrecommender.model.dto.OutputDataDTO;
import sbnz.integracija.workoutrecommender.model.enums.WeightStatus;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutIntensity;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutType;
import sbnz.integracija.workoutrecommender.utils.InputDataConverter;
import sbnz.integracija.workoutrecommender.utils.OutputDataConverter;

@Service
@AllArgsConstructor
public class RecommendationService {
	
	private final KieSessionService kieSessionService;
	
	private final OutputDataConverter outputDataConverter;
	
	private final InputDataConverter inputDataConverter;
	
	public OutputDataDTO getRecommendation(InputDataDTO dto) {
		InputData data = inputDataConverter.dtoToNewEntity(dto);
		ProcessInfo info = this.prepareInfo(data);
		ProcessInfo result = kieSessionService.getRecommendation(data, info);
		// this.sortRecommendations(result);
		return outputDataConverter.entityToDto(result);
	}
	
	private ProcessInfo prepareInfo(InputData data) {
		double bmi = data.getWeight() / (data.getHeight() * data.getHeight());

		return ProcessInfo.builder()
				.weightStatus(WeightStatus.DEFAULT)
				.advice("")
				.equipmentSet(data.getEquipmentSet())
				.equipment(false)
				.bmi(bmi)
				.workoutType(WorkoutType.DEFAULT)
				.workoutIntensity(WorkoutIntensity.DEFAULT)
				.filteredWorkouts(new ArrayList<Workout>())
				.build();
	}

	private void sortRecommendations(ProcessInfo info) {
		List<Workout> sortedList = info.getFilteredWorkouts().stream()
				.sorted(Comparator.comparing((Workout w) -> w.getEquipmentSet().size()).reversed())
				.collect(Collectors.toList());
		info.setFilteredWorkouts(sortedList);
	}

}
