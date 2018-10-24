package org.almansa.app.core.service.member;

import java.util.Objects;

import javax.persistence.EntityExistsException;

import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.entity.member.SimpleMember;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.service.dto.LoginMemberSessionModel;
import org.almansa.app.core.util.Entities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component
public class MemberServiceImpl implements MemberService{
        
    private MemberRepository memberRepo;
    
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepo) {
        super();
        this.memberRepo = memberRepo;
    }
    
    @Override
    @Transactional(readOnly = true)
    public LoginMemberSessionModel loginAndGetUserSessionModel(String loginId, String password) {
        Member member = getByLoginId(loginId);
        
        Entities.assertEntityFound(member, "member can't found");
        
        if(Objects.equals(member.getPassword(), password)) {            
            LoginMemberSessionModel sessionModel = new LoginMemberSessionModel();
            sessionModel.setId(member.getId());
            sessionModel.setLoginId(member.getLoginId());
            
            return sessionModel;
        }
        return null;
    }
    
    @Override 
    @Transactional(readOnly = true)
    public Member getByLoginId(String loginId) {
    	return memberRepo.getByLoginId(loginId);
    }
    
    @Override
    @Transactional
    public void joinSimply(String loginId, String password) throws EntityExistsException{
    	Assert.notNull(loginId, "loginId can't be null");
    	Assert.notNull(password, "password can't be null");

        Member member = getByLoginId(loginId);
        
        Entities.assertEntityNotAleadyExists(member, "member aleady exists");
        
        member = new SimpleMember(loginId, password, false);
        memberRepo.update(member);
    }
}
