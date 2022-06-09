package sbnz.integracija.workoutrecommender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sbnz.integracija.workoutrecommender.model.Exerciser;

import java.util.Optional;

public interface ExerciserRepository extends JpaRepository<Exerciser, Long> {
    Optional<Exerciser> findByEmail(String email);
}
