package com.springdata.service;

import com.springdata.entities.Person;
import com.springdata.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author lijichen
 * @date 2020/12/2 - 18:30
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Iterable<Person> savePerson(List<Person> personList) {
        return personRepository.saveAll(personList);
    }

    @Transactional
    public Integer updatePersonEmail(String email, Integer id) {
        return personRepository.testUpdatePersonEmail(email, id);
    }
}
