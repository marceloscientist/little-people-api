package me.dio.personapi.controller;

import me.dio.personapi.dto.MessageResponseDTO;
import me.dio.personapi.entity.Person;
import me.dio.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    MessageResponseDTO createPerson (@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public
    List<Person> listPeople ( ) {
        return personService.listPeople();
    }

}
