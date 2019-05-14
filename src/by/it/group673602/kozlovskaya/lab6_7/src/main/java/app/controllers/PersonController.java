package by.it.group673602.kozlovskaya.lab6_7.src.main.java.app.controllers;


import app.PersonNotFoundException;
import app.data.PersonRepository;
import app.domains.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/persons",produces = "application/json")
public class PersonController {

    private PersonRepository personRepo;

    @Autowired
    PersonController(PersonRepository personRepo){
        this.personRepo = personRepo;
    }

    @GetMapping
    List<Person> getPersons(){
        return personRepo.findAll();
    }

    @PostMapping
    List<Person> newPersons(@RequestBody @Valid List<Person> newPersons){
        return personRepo.saveAll(newPersons);
    }

    @PutMapping
    void putPersons(@RequestBody @Valid List<Person> newPersons){

        newPersons.forEach(person -> {
           putPerson(person, person.getLogin());
        });
    }

    @DeleteMapping
    void deletePerson(@RequestBody @Valid List<Person> persons){
        personRepo.deleteAll(persons);
    }


    //working with person groups
    //----------------------------------------------------------
    //working with one person



    @PostMapping("/person")
    Person newPerson(@RequestBody @Valid Person newPerson){

        return personRepo.save(newPerson);
    }

    @GetMapping("/person/{id}")
    Person one(@PathVariable Integer id){
        return personRepo.findById(id).orElseThrow(
                () -> new PersonNotFoundException(id));
    }

    @PutMapping("/person/{id}")
    Person putPerson(@RequestBody @Valid Person newPerson, @PathVariable Integer id){
        newPerson.setLogin(id);
        return personRepo.save(newPerson);
    }

    @DeleteMapping("/person/{id}")
    void deletePerson(@PathVariable Integer id){
        personRepo.deleteById(id);
    }



}
