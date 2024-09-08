package main.java.com.workpal.repository;

import main.java.com.workpal.dao.PersonDao;


public class PersonRepositoryImplt implements PersonRepository {

    private final PersonDao personDao;

    public PersonRepositoryImplt(PersonDao personDao) {
        this.personDao = personDao;
    }



    public void  findByEmailAndPassword(String email, String password) {
         personDao.login(email, password);
    }



    
}
