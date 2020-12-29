package com.springdata.repository;

import com.springdata.dao.PersonDao;
import com.springdata.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author lijichen
 * @date 2020/12/2 - 20:12
 */
public class PersonRepositoryImpl implements PersonDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void test() {
        System.out.println("--->>>" + entityManager.find(Person.class, 11));
    }
}
