package main.java.com.workpal.dao;

import java.util.List;

import main.java.com.workpal.model.Space;

public interface MemberDao {
    
   

    void modifyProfile(int id, String name, String email);

    List<Space> viewAllSpaces();
} 