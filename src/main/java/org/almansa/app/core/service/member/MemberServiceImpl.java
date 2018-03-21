package org.almansa.app.core.service.member;

import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.entity.member.SimpleMember;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.service.ServiceBase;
import org.almansa.app.core.service.dto.LoginMemberSessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl extends ServiceBase implements MemberService{
        
    private MemberRepository memberRepo;
    
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepo) {
        super();
        this.memberRepo = memberRepo;
    }

    @Override
    public LoginMemberSessionModel loginAndGetUserSessionModel(String loginId, String password) {
        Member member = memberRepo.getByLoginId(loginId);
        
        if(member != null && member.getPassword().equals(password)) {            
            LoginMemberSessionModel sessionModel = new LoginMemberSessionModel();
            sessionModel.setId(member.getId());
            sessionModel.setLoginId(member.getLoginId());
            
            return sessionModel;
        }
        return null;
    }    
    
    @Override
    public void joinSimply(String loginId, String password) {
        verifyNotNull(loginId);
        verifyNotNull(password);
        
        Member member = memberRepo.getByLoginId(loginId);
        
        if(member == null) {
            member = new SimpleMember(loginId, password, false);
            memberRepo.update(member);      
        }
    }
}
