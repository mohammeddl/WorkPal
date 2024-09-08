package main.java.com.workpal.repository;



import main.java.com.workpal.dao.PersonDao;
import main.java.com.workpal.model.Person;

public class AdminRepositoryImplt implements AdminRepository {

    private final PersonDao personDao;

    public AdminRepositoryImplt(PersonDao personDao) {
        this.personDao = personDao;
    }


    public void addPerson(Person person) {
        personDao.save(person);
    }
    
    public void deletePerson(int memberId) {
        personDao.deleteById(memberId);
    }
}
