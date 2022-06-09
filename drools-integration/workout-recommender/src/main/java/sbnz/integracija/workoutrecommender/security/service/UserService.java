package sbnz.integracija.workoutrecommender.security.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sbnz.integracija.workoutrecommender.security.model.User;
import sbnz.integracija.workoutrecommender.security.repository.UserRepository;


@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	// Funkcija koja na osnovu username-a iz baze vraca objekat User-a
	//username je email adresa
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userRepository.findByEmail(username);

		if (user != null) {
			return user;
		}
		
		throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	}

	public User findByUsername(String username) {
		User u;
		
		try {
			if((u = userRepository.findByEmail(username)) != null)
				return u;
		}
		catch(UsernameNotFoundException e) {}

		return null;
	}

	public User findById(Long id) throws AccessDeniedException {
		User u = userRepository.findById(id).orElseGet(null);
		return u;	
	}
}
