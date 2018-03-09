package org.almansa.app.service.memberService;

import org.almansa.app.core.member.Member;
import org.almansa.app.core.service.ServiceBase;
import org.almansa.app.core.service.repository.MemberRepository;
import org.almansa.app.service.dto.LoginUserSessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl extends ServiceBase{
    
    @Autowired
    private MemberRepository memberRepo;
    
    public LoginUserSessionModel loginAndGetUserSessionModel(String loginId, String password) {
        Member member = memberRepo.getByLoginId(loginId);
        
        if(member != null && member.getPassword().equals(password)) {
            
            LoginUserSessionModel sessionModel = new LoginUserSessionModel();
            sessionModel.setId(member.getId());
            sessionModel.setLoginId(member.getLoginId());
            
            return sessionModel;
        }
        
        return null;
    }    
}
