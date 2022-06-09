package sbnz.integracija.workoutrecommender.security.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.workoutrecommender.security.model.LoginDTO;
import sbnz.integracija.workoutrecommender.security.model.RegistrationRequestDTO;
import sbnz.integracija.workoutrecommender.security.model.User;
import sbnz.integracija.workoutrecommender.security.model.UserTokenState;
import sbnz.integracija.workoutrecommender.security.service.UserService;
import sbnz.integracija.workoutrecommender.security.utils.TokenUtils;
import sbnz.integracija.workoutrecommender.service.ExerciserService;

//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;

	@Autowired
	private ExerciserService exerciserService;

	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody LoginDTO authenticationRequest,
																	HttpServletResponse response) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

	// Endpoint for registration of new exerciser
	@PostMapping("/registerRequest")
	public ResponseEntity<?> registerRequest(@RequestBody RegistrationRequestDTO userRequest) {

		//check if user with requested email exists
		User existUser = this.userService.findByUsername(userRequest.getEmail());
		Map<String, String> result = new HashMap<>();
		
		if (existUser != null) {
			result.put("result", "that email adress is in use");
			return ResponseEntity.badRequest().body(result);
		}
		
		//save new user
		exerciserService.create(userRequest);

		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	}

}
