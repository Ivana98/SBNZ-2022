package sbnz.integracija.workoutrecommender.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbnz.integracija.workoutrecommender.model.dto.ExerciserUpdateDTO;
import sbnz.integracija.workoutrecommender.model.dto.WorkoutDTO;
import sbnz.integracija.workoutrecommender.service.ExerciserService;

@RestController
@RequestMapping(value = "/exerciser")
@AllArgsConstructor
public class ExerciserController {

    private final ExerciserService exerciserService;

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public void updateExerciser(@RequestBody final ExerciserUpdateDTO dto) {
        exerciserService.update(dto);
    }

}
