package main.java.com.workpal.service;

import java.util.List;

import main.java.com.workpal.model.Space;

public interface MemberService {

    void modifyProfile(int id, String name, String email);

    //display all spaces
    List<Space> viewAllSpaces();
    
} 
