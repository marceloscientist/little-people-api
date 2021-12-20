package me.dio.personapi.repository;

import me.dio.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface PersonRepository extends JpaRepository<Person, Long> {
}
