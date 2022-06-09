package sbnz.integracija.workoutrecommender.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sbnz.integracija.workoutrecommender.security.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByName(String name);
}
