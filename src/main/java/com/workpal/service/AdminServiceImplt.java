package main.java.com.workpal.service;


import main.java.com.workpal.model.Member;


import main.java.com.workpal.repository.AdminRepository;

public class AdminServiceImplt implements AdminService {

    private AdminRepository adminRepository;


    public AdminServiceImplt(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public void addPerson(String name, String email, String password) {
        Member member = new Member(0, name, password, email);  
        adminRepository.addPerson(member);  
        System.out.println("Member added successfully.");
    }

    public void deletePerson(int memberId) {
        adminRepository.deletePerson(memberId);  
        System.out.println("Member deleted successfully.");
    }
    
}
