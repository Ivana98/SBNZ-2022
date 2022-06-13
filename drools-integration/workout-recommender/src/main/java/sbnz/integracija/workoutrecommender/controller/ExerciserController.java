package sbnz.integracija.workoutrecommender.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sbnz.integracija.workoutrecommender.model.dto.ExerciserUpdateDTO;
import sbnz.integracija.workoutrecommender.model.dto.WorkoutDTO;
import sbnz.integracija.workoutrecommender.service.ExerciserService;

@RestController
@RequestMapping(value = "/exerciser")
@AllArgsConstructor
public class ExerciserController {

    private final ExerciserService exerciserService;

    @PreAuthorize("hasRole('USER')")
    @PutMapping
    public void updateExerciser(@RequestBody final ExerciserUpdateDTO dto) {
        exerciserService.update(dto);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ExerciserUpdateDTO getOne(@PathVariable("id") Long id) {
        return exerciserService.getUserInfo(id);
    }

}
