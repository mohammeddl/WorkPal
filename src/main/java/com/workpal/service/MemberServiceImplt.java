package main.java.com.workpal.service;

import main.java.com.workpal.repository.MemberRepositoryImplt;

public class MemberServiceImplt implements MemberService {


    private final MemberRepositoryImplt memberRepositoryImplt;

    public MemberServiceImplt(MemberRepositoryImplt memberRepositoryImplt) {
        this.memberRepositoryImplt = memberRepositoryImplt;
    }

    public void modifyProfile(int id, String name, String email) {
        memberRepositoryImplt.modifyProfile(id, name, email);
        System.out.println("Profile updated successfully.");
    }
    
}
