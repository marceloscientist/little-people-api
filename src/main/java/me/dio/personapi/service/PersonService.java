package me.dio.personapi.service;

import me.dio.personapi.dto.MessageResponseDTO;
import me.dio.personapi.dto.request.PersonDTO;
import me.dio.personapi.entity.Person;
import me.dio.personapi.exception.PersonNotFoundException;
import me.dio.personapi.mapper.PersonMapper;
import me.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public
class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public
    PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public
    MessageResponseDTO createPerson (PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID");
    }

    public
    List<PersonDTO> listPeople ( ) {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public
    PersonDTO findOne (Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(()->new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }

    public
    void delete (Long id) throws PersonNotFoundException {
        verifyIfExistsPerson(id);
        personRepository.deleteById(id);
    }

    public
    MessageResponseDTO updateById (Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExistsPerson(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    private
    MessageResponseDTO createMessageResponse (Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private
    Person verifyIfExistsPerson (Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(()->new PersonNotFoundException(id));
    }


}
