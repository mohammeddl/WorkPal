package main.java.com.workpal.repository;
import java.util.List;
import main.java.com.workpal.model.Space;

 interface MemberRepository {

    void modifyProfile(int id, String name, String email);


    //display all spaces
    List<Space> viewAllSpaces();
    
} 
