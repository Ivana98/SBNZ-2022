package sbnz.integracija.workoutrecommender.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.workoutrecommender.security.model.Authority;
import sbnz.integracija.workoutrecommender.security.repository.AuthorityRepository;


@Service
public class AuthorityService {
	@Autowired
	  private AuthorityRepository authorityRepository;

	  public List<Authority> findById(Long id) {
	    Authority auth = this.authorityRepository.getById(id);
	    List<Authority> auths = new ArrayList<>();
	    auths.add(auth);
	    return auths;
	  }

	  public List<Authority> findByname(String name) {
	    Authority auth = this.authorityRepository.findByName(name);
	    List<Authority> auths = new ArrayList<>();
	    auths.add(auth);
	    return auths;
	  }
}
