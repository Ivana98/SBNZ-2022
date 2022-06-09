package sbnz.integracija.workoutrecommender.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sbnz.integracija.workoutrecommender.exception.AlreadyExistsException;
import sbnz.integracija.workoutrecommender.exception.NotFoundException;
import sbnz.integracija.workoutrecommender.model.Workout;
import sbnz.integracija.workoutrecommender.repository.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public void create(Workout workout) {
        findOneByName(workout.getName());
        workoutRepository.save(workout);
    }

    public void update(Workout updatedWorkout) {
        Workout oldWorkout = findOneById(updatedWorkout.getId());
        checkNameIsUnique(oldWorkout.getName(), updatedWorkout.getName());
        workoutRepository.save(updatedWorkout);
    }

    public void delete(Long id) {
        findOneById(id);
        workoutRepository.deleteById(id);
    }

    public Workout findOneById(Long id) {
        Optional<Workout> workoutOptional = workoutRepository.findById(id);
        if (!workoutOptional.isPresent()) {
            throw new NotFoundException(String.format("Workout with id '%d' does not exist", id));
        }
        return workoutOptional.get();
    }

    public void findOneByName(String name) {
        Optional<Workout> workoutOptional =  workoutRepository.findByName(name);
        if (workoutOptional.isPresent()) {
            throw new AlreadyExistsException(String.format("Workout with name '%s' already exists", name));
        }
    }

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    private void checkNameIsUnique(String oldName, String newName) {
        if(!oldName.equals(newName)) {
            findOneByName(newName);
        }
    }
}
