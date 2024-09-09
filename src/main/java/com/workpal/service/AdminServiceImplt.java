package main.java.com.workpal.service;


import main.java.com.workpal.repository.AdminRepository;

public class AdminServiceImplt implements AdminService {

    private AdminRepository adminRepository;
    

    public AdminServiceImplt(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public void addMember(String name, String email, String password, String role) {
        adminRepository.addMember(name, email, password, role); 
        System.out.println("Member added successfully.");
    }

    public void deletePerson(int memberId) {
        adminRepository.deletePerson(memberId);
        System.out.println("Member deleted successfully.");
    }
    
}
