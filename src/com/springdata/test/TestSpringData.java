package com.springdata.test;

import com.springdata.entities.Person;
import com.springdata.repository.PersonRepository;
import com.springdata.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lijichen
 * @date 2020/12/2 - 14:36
 */
public class TestSpringData {
    private ApplicationContext applicationContext = null;
    private PersonRepository personRepository = null;

//    @Autowired
    private PersonService personService;
    {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        personRepository = applicationContext.getBean(PersonRepository.class);
        personService = applicationContext.getBean(PersonService.class);
    }

    @Test
    public void testSaveAndFlush() {
        Person person = new Person();
        person.setName("asdf");
        person.setEmail("@asdfa");
        Person person1 = personRepository.saveAndFlush(person);

        System.out.println(person == person1);

    }


    @Test
    public void testSave() {
        List<Person> list = new ArrayList<>();
        for (int i = 'a'; i < 'z'; i++) {
            list.add(new Person(i+1,
                    (char)i +""+ (char)i,
                    (char)i + "@springdata" + (char)i + "com"));
        }
        System.out.println(personService.savePerson(list));

    }
    @Test
    public void myRepositiory() {
        personRepository.test();
    }
    @Test
    public void testPagintAndSoringRepository2() {
//        PageRequest pageRequest = new AbstractPageRequest(1,4);
    }
    @Test
    public void testPagintAndSoringRepository() {
        int pageNo = 1 - 1;
        int pageSize = 5;
//        PageRequest pageable = new PageRequest(1,4, Sort.Direction.ASC, "id");
//        Sort pageable = new ;
//        Page<Person> page = personRepository.findAll(pageable);
//        System.out.println("当前页数:" + (page.getNumber() + 1));
//        System.out.println("当前页的记录数:" + page.getNumberOfElements());
//        System.out.println("每页记录数:" + page.getSize());
//        System.out.println("总记录数:" + page.getTotalElements());
//        System.out.println("总页数:" + page.getTotalPages());
//        System.out.println("记录:" + page.getContent());
    }
    @Test
    public void testUpdatePersonEmail() {
//        Integer result = personRepository.testUpdatePersonEmail("aaaa", 1);
//        System.out.println(result);
        System.out.println(personService.updatePersonEmail("aaaa", 11));
    }
    @Test
    public void testQueryAnnotationParam2() {
        System.out.println(personRepository.testQueryAnnotationParam2("e","n"));
    }
    @Test
    public void testQueryAnnotationParam1() {
        System.out.println(personRepository.testQueryAnnotationParam1("a", "a"));
    }
    @Test
    public void getMaxIdPerson() {
        System.out.println(personRepository.getMaxIdPerson());

    }

    @Test
    public void testGet() throws SQLException {
        List<Person> persons = personRepository.getByNameStartingWithAndIdLessThan("a", 1000);
        List<Person> personList = personRepository.getByEmailInAndNameStartingWith(Arrays.asList("AA","asfdasdf"),
                "a");
        List<Person> person3 = personRepository.getByAddress_IdGreaterThan(0);

        System.out.println(persons);
        System.out.println(personList);
        System.out.println(person3);
    }


    @Test
    public void test() throws SQLException {
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testJPA() throws SQLException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);

        }
        PersonRepository personRepository = applicationContext.getBean(PersonRepository.class);
        Person aa = personRepository.getPersonByName("aa");
        System.out.println(aa);
    }
}
