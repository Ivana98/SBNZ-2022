package sbnz.integracija.workoutrecommender.service;

import lombok.NoArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import sbnz.integracija.workoutrecommender.model.InputData;
import sbnz.integracija.workoutrecommender.model.ProcessInfo;

@Service
@AllArgsConstructor
public class KieSessionService {
	
	private final KieContainer kieContainer;
//	private final WorkoutService workoutService;

	public ProcessInfo getRecommendation(InputData data, ProcessInfo info) {
		//get the stateful session
		KieSession kieSession = kieContainer.newKieSession();
		
		kieSession.insert(data);
		kieSession.insert(info);

		//insert all workouts
//		List<Workout> workoutList = workoutService.findAll();
//		for (Workout workout: workoutList) {
//			kieSession.insert(workout);
//		}

        kieSession.getAgenda().getAgendaGroup("WeightStatus").setFocus();

		kieSession.fireAllRules();

		kieSession.dispose();
		return info;
	}
	

}
