package sbnz.integracija.workoutrecommender.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sbnz.integracija.workoutrecommender.model.dto.WorkoutDTO;
import sbnz.integracija.workoutrecommender.service.WorkoutService;
import sbnz.integracija.workoutrecommender.utils.WorkoutConverter;

@RestController
@RequestMapping(value = "/workout")
@AllArgsConstructor
public class WorkoutController {
	
	private final WorkoutService workoutService;
    private final WorkoutConverter workoutConverter;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void createWorkout(@RequestBody final WorkoutDTO dto) {
        workoutService.create(workoutConverter.dtoToNewEntity(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public void updateWorkout(@RequestBody final WorkoutDTO dto) {
    	workoutService.update(workoutConverter.dtoToEntity(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable("id") final Long id) {
    	workoutService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public WorkoutDTO getOne(@PathVariable("id") Long id) {
        return workoutConverter.entityToDto(workoutService.findOneById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<WorkoutDTO> getAll() {
        return workoutService.findAll()
                .stream()
                .map(workoutConverter::entityToDto)
                .collect(Collectors.toList());
    }

}
