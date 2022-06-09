package sbnz.integracija.workoutrecommender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sbnz.integracija.workoutrecommender.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
