package sbnz.integracija.workoutrecommender.service;

import lombok.NoArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import sbnz.integracija.workoutrecommender.model.InputData;
import sbnz.integracija.workoutrecommender.model.ProcessInfo;
import sbnz.integracija.workoutrecommender.model.Workout;
import sbnz.integracija.workoutrecommender.model.enums.Equipment;
import sbnz.integracija.workoutrecommender.model.enums.Mood;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutIntensity;
import sbnz.integracija.workoutrecommender.model.enums.WorkoutType;

import java.util.*;

@Service
@AllArgsConstructor
public class KieSessionService {
	
	private final KieContainer kieContainer;
	private final WorkoutService workoutService;

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
		List<Workout> workoutList = workoutService.findAll();
		for (Workout workout: workoutList) {
			kieSession.insert(workout);
		}

		kieSession.getAgenda().getAgendaGroup("Sorting results").setFocus();
		kieSession.getAgenda().getAgendaGroup("Result").setFocus();
		kieSession.getAgenda().getAgendaGroup("WorkoutIntensity").setFocus();
		kieSession.getAgenda().getAgendaGroup("BodyType").setFocus();
        kieSession.getAgenda().getAgendaGroup("WeightStatus").setFocus();

		kieSession.fireAllRules();

		kieSession.dispose();
		return info;
	}
	
	private List<Workout> getDummyWorkouts() {
		Set<Mood> moodSet1 = new HashSet<>(Arrays.asList(Mood.NORMAL, Mood.GOOD_HAPPY, Mood.BORED));
		ArrayList<Workout> list = new ArrayList<>();

		list.add(new Workout((long) 1, 45.0, "Cardio 6", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(Arrays.asList(Equipment.DUMBBELLS)), WorkoutIntensity.HIGH, WorkoutType.CARDIO, moodSet1));
		list.add(new Workout((long) 2, 45.0, "Cardio 1", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(), WorkoutIntensity.HIGH, WorkoutType.CARDIO, moodSet1));
		list.add(new Workout((long) 3, 30.0, "Cardio 2", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(), WorkoutIntensity.MEDIUM, WorkoutType.CARDIO, moodSet1));
		list.add(new Workout((long) 4, 30.0, "Cardio 3", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(), WorkoutIntensity.LOW, WorkoutType.CARDIO, moodSet1));
		list.add(new Workout((long) 5, 45.0, "Cardio 6", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(Arrays.asList(Equipment.EXPANDER, Equipment.DUMBBELLS)), WorkoutIntensity.HIGH, WorkoutType.CARDIO, moodSet1));
		list.add(new Workout((long) 6, 45.0, "Cardio 4", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(), WorkoutIntensity.MEDIUM, WorkoutType.CARDIO, moodSet1));
		list.add(new Workout((long) 7, 45.0, "Cardio 5", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(Arrays.asList(Equipment.EXPANDER)), WorkoutIntensity.HIGH, WorkoutType.CARDIO, moodSet1));
		list.add(new Workout((long) 8, 45.0, "Cardio 6", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(Arrays.asList(Equipment.EXPANDER, Equipment.DUMBBELLS)), WorkoutIntensity.HIGH, WorkoutType.CARDIO, moodSet1));
		list.add(new Workout((long) 9, 45.0, "Cardio 7", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(), WorkoutIntensity.MEDIUM, WorkoutType.CARDIO, moodSet1));
		list.add(new Workout((long) 10, 45.0, "Cardio 8", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(), WorkoutIntensity.LOW, WorkoutType.STRENGTH, moodSet1));
		list.add(new Workout((long) 11, 45.0, "Cardio 9", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(), WorkoutIntensity.MEDIUM, WorkoutType.STRENGTH, moodSet1));
		list.add(new Workout((long) 12, 45.0, "Cardio 10", "https://www.youtube.com/watch?v=dummy", new HashSet<Equipment>(), WorkoutIntensity.HIGH, WorkoutType.STRENGTH, moodSet1));

		return list;
	}

}
