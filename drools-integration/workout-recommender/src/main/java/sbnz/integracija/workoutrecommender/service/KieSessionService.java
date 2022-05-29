package sbnz.integracija.workoutrecommender.service;

import lombok.NoArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import sbnz.integracija.workoutrecommender.model.InputData;
import sbnz.integracija.workoutrecommender.model.ProcessInfo;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutIntensity;

@Service
@AllArgsConstructor
public class KieSessionService {
	
	private final KieContainer kieContainer;
//	private final WorkoutService workoutService;

	private static final WorkoutIntensity[][] WORKOUT_INTENSITY_MAT = {
//			INACTIVE; LITTLE ACTIVE; AVERAGE ACTIVE; VERY ACTIVE
			{ WorkoutIntensity.LOW, WorkoutIntensity.MEDIUM, WorkoutIntensity.MEDIUM, WorkoutIntensity.HIGH },  // MILD THINNES
			{ WorkoutIntensity.LOW, WorkoutIntensity.MEDIUM, WorkoutIntensity.HIGH, WorkoutIntensity.HIGH },	// NORMAL
			{ WorkoutIntensity.LOW, WorkoutIntensity.LOW, WorkoutIntensity.MEDIUM, WorkoutIntensity.MEDIUM },	// OVERWEIGHT
			{ WorkoutIntensity.LOW, WorkoutIntensity.LOW, WorkoutIntensity.LOW, WorkoutIntensity.LOW }			// OBESE I
	};

	public ProcessInfo getRecommendation(InputData data, ProcessInfo info) {
		//get the stateful session
		KieSession kieSession = kieContainer.newKieSession("RecommenderKsession");

//		kieSession.setGlobal("WORKOUT_INTENSITY_MAT", WORKOUT_INTENSITY_MAT);

		kieSession.insert(data);
		kieSession.insert(info);

		//insert all workouts
//		List<Workout> workoutList = workoutService.findAll();
//		for (Workout workout: workoutList) {
//			kieSession.insert(workout);
//		}

		kieSession.getAgenda().getAgendaGroup("WorkoutIntensity").setFocus();
		kieSession.getAgenda().getAgendaGroup("BodyType").setFocus();
        kieSession.getAgenda().getAgendaGroup("WeightStatus").setFocus();

		kieSession.fireAllRules();

		kieSession.dispose();
		return info;
	}
	

}
