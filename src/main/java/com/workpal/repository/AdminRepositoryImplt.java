package main.java.com.workpal.repository;


import main.java.com.workpal.dao.PersonDao;


public class AdminRepositoryImplt implements AdminRepository {

    private final PersonDao personDao;

    public AdminRepositoryImplt(PersonDao personDao) {
        this.personDao = personDao;
    }


    public void addMember(String name, String email, String password, String role) {
        personDao.saveMember(name, password, email, role);
    }
    
    public void deletePerson(int memberId) {
        personDao.deleteById(memberId);
    }
}
