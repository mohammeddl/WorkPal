package main.java.com.workpal.repository;
import java.util.List;

import main.java.com.workpal.model.Member;
import main.java.com.workpal.model.Space;

 interface MemberRepository {

    void modifyProfile(int id, String name, String email);
    
    Member findByEmail(String email);  
    void updateTemporaryPassword(int memberId, String tempPassword); 
    void updatePassword(int memberId, String newPassword);

    //display all spaces
    List<Space> viewAllSpaces();
    
} 
