package sbnz.integracija.workoutrecommender.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.workoutrecommender.exception.AlreadyExistsException;
import sbnz.integracija.workoutrecommender.exception.NotFoundException;
import sbnz.integracija.workoutrecommender.model.Exerciser;
import sbnz.integracija.workoutrecommender.model.dto.ExerciserUpdateDTO;
import sbnz.integracija.workoutrecommender.repository.ExerciserRepository;
import sbnz.integracija.workoutrecommender.security.model.RegistrationRequestDTO;
import sbnz.integracija.workoutrecommender.utils.ExerciserConverter;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ExerciserService {

    private final ExerciserRepository exerciserRepository;
    private final ExerciserConverter exerciserConverter;

    public void findOneByEmail(String email) {
        Optional<Exerciser> optional =  exerciserRepository.findByEmail(email);
        if (optional.isPresent()) {
            throw new AlreadyExistsException(String.format("Exerciser with email '%s' already exists", email));
        }
    }

    public void create(RegistrationRequestDTO request) {
        findOneByEmail(request.getEmail());
        Exerciser exerciser = exerciserConverter.dtoToNewEntity(request);
        exerciserRepository.save(exerciser);
    }

    public void update(ExerciserUpdateDTO dto) {
        Optional<Exerciser> optional =  exerciserRepository.findById(dto.getId());
        if (!optional.isPresent()) {
            throw new NotFoundException(String.format("Exerciser with id '%d' already exists", dto.getId()));
        }
        Exerciser e = exerciserConverter.updateEntity(dto, optional.get());
        exerciserRepository.save(e);
    }

    public ExerciserUpdateDTO getUserInfo(Long id) {
        Optional<Exerciser> optional =  exerciserRepository.findById(id);
        ExerciserUpdateDTO dto = exerciserConverter.toDTO(optional.get());
        return dto;
    }
}
