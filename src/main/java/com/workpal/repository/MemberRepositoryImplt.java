package main.java.com.workpal.repository;

import main.java.com.workpal.dao.MemberDaoImplt;

public class MemberRepositoryImplt implements MemberRepository {

     private final MemberDaoImplt memberDao;

     public MemberRepositoryImplt(MemberDaoImplt memberDao) {
        this.memberDao = memberDao;
    }

    public void modifyProfile(int id, String name, String email) {
        memberDao.modifyProfile(id, name, email);
    }
    
}
