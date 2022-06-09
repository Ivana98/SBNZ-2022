package sbnz.integracija.workoutrecommender.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sbnz.integracija.workoutrecommender.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	/*
    User findByUsername(String username);
    */
	User findByEmail(String email);
}
