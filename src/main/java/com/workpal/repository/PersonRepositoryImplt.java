package main.java.com.workpal.repository;

import main.java.com.workpal.dao.PersonDao;
import main.java.com.workpal.model.Person;


public class PersonRepositoryImplt implements PersonRepository {

    private final PersonDao personDao;

    public PersonRepositoryImplt(PersonDao personDao) {
        this.personDao = personDao;
    }



       public Person findByEmailAndPassword(String email, String password) {
        return  personDao.login(email, password);
    }



    
}
