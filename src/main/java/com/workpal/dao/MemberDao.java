package main.java.com.workpal.dao;

import java.util.List;

import main.java.com.workpal.model.Member;
import main.java.com.workpal.model.Space;

public interface MemberDao {
    
   

    void modifyProfile(int id, String name, String email);

    List<Space> viewAllSpaces();


    Member findByEmail(String email);  // Find a member by email
    void updateTemporaryPassword(int memberId, String tempPassword); // Update temporary password
    void updatePassword(int memberId, String newPassword);
} 