package main.java.com.workpal.repository;

import java.util.List;

import main.java.com.workpal.dao.PersonDao;
import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Person;


public class PersonRepositoryImplt implements PersonRepository {

    private final PersonDao personDao;

    public PersonRepositoryImplt(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void registerUser(String name, String email, String plainPassword, String role) {
        personDao.registerUser(name, email, plainPassword, role);
    }

    public void registerManager(String name, String email, String plainPassword, String role) {
        personDao.registerManager(name, email, plainPassword, role);
    }

    public Person findByEmailAndPassword(String email, String password) {
        return  personDao.login(email, password);
    }

    public List<Person> getAllMembers() {
        return personDao.getAllMembers();
    }

    public List<Event> getAllEvents() {
        return personDao.getAllEvents();
    }
    
}
