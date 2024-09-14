package main.java.com.workpal.model;

public class Member extends Person {

    private String temporary_password;

    public Member(int id, String name, String password, String email, String role , String temporary_password) {
        super(id, name, password, email, role);
        this.temporary_password = temporary_password;
    }

    public String getTemporary_password() {
        return temporary_password;
    }
    

    
    
}
