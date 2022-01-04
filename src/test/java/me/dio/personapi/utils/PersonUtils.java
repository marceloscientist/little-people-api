package me.dio.personapi.utils;

import me.dio.personapi.dto.request.PersonDTO;
import me.dio.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;
import me.dio.personapi.utils.PhoneUtils;
public class PersonUtils {
    
    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(LocalDate.of(2010, 4, 4))
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }




}