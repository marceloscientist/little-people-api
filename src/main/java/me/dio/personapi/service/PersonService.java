package me.dio.personapi.service;

import me.dio.personapi.dto.MessageResponseDTO;
import me.dio.personapi.entity.Person;
import me.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public
    PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public
    MessageResponseDTO createPerson (Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public
    List<Person> listPeople ( ) {
        return personRepository.findAll();
    }


}
