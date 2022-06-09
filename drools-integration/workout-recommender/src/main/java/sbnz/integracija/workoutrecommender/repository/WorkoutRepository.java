package sbnz.integracija.workoutrecommender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sbnz.integracija.workoutrecommender.model.Workout;

import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Optional<Workout> findByName(String name);
}
