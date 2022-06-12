package sbnz.integracija.workoutrecommender.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbnz.integracija.workoutrecommender.security.model.ForAllUsersDTO;
import sbnz.integracija.workoutrecommender.security.model.User;
import sbnz.integracija.workoutrecommender.security.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/returnCurrentUser")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ForAllUsersDTO user(Principal user) {
        try {
            User u = this.userService.findByUsername(user.getName());
            ForAllUsersDTO dto = this.userService.convertUserToDTO(u);
            return  dto;
        }
        catch(NullPointerException e) {
            return null;
        }

    }

}
