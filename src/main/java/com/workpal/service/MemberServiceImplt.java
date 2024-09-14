package main.java.com.workpal.service;

import main.java.com.workpal.repository.MemberRepositoryImplt;
import main.java.com.workpal.model.Member;
import main.java.com.workpal.model.Space;
import java.util.List;
import java.util.UUID;

public class MemberServiceImplt implements MemberService {


    private final MemberRepositoryImplt memberRepositoryImplt;
    private EmailServiceImpl emailService;

    public MemberServiceImplt(MemberRepositoryImplt memberRepositoryImplt, EmailServiceImpl emailService) {
        this.memberRepositoryImplt = memberRepositoryImplt;
        this.emailService = emailService;
        
    }

    public MemberServiceImplt(MemberRepositoryImplt memberRepositoryImplt) {
        this.memberRepositoryImplt = memberRepositoryImplt;
    }

    public void modifyProfile(int id, String name, String email) {
        memberRepositoryImplt.modifyProfile(id, name, email);
        System.out.println("Profile updated successfully.");
    }

    public List<Space> viewAllSpaces() {
        return memberRepositoryImplt.viewAllSpaces();
    }

     public void resetPassword(String email) {
        try{
            Member member = memberRepositoryImplt.findByEmail(email);
            if (member != null) {
                String temporaryPassword = UUID.randomUUID().toString().substring(0, 8);
                memberRepositoryImplt.updateTemporaryPassword(member.getId(), temporaryPassword);
                String message = "Your temporary password is: " + temporaryPassword;
                emailService.sendEmail("daali.22.ss@gmail.com", "Password Reset", message);
                System.out.println("Temporary password sent to your email.");
            } else {
                System.out.println("No member found with that email.");
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }finally{
            System.out.println("Password reset successful.");
        }
    }

    
    public void changePassword(int memberId, String newPassword) {
        memberRepositoryImplt.updatePassword(memberId, newPassword);
    }

    
}
