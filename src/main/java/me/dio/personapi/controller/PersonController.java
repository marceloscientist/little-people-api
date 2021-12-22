package me.dio.personapi.controller;

import me.dio.personapi.dto.MessageResponseDTO;
import me.dio.personapi.dto.request.PersonDTO;
import me.dio.personapi.exception.PersonNotFoundException;
import me.dio.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public
class PersonController {

    private final
    PersonService personService;

    @Autowired
    public
    PersonController (PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public
    MessageResponseDTO createPerson (@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public
    List<PersonDTO> listPeople ( ) {
        return personService.listPeople();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findById (@PathVariable Long id) throws PersonNotFoundException {
        return personService.findOne(id);
    }


}
