package org.almansa.app.service.memberService;

import org.almansa.app.core.member.Member;
import org.almansa.app.core.member.SimpleMember;
import org.almansa.app.core.service.ServiceBase;
import org.almansa.app.core.service.repository.MemberRepository;
import org.almansa.app.service.dto.LoginUserSessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl extends ServiceBase{
        
    private MemberRepository memberRepo;
    
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepo) {
        super();
        this.memberRepo = memberRepo;
    }

    /**
     * 로그인 성공 LoginUserSessionModel 리턴 
     * 실패 null 리턴
     * @param loginId
     * @param password
     * @return
     */
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
    
    public void joinSimply(String loginId, String password) {
        verifyNotNull(loginId);
        verifyNotNull(password);
        
        Member member = memberRepo.getByLoginId(loginId);
        
        if(member == null) {
            member = new SimpleMember(loginId, password);
            memberRepo.update(member);      
        }
    }
}
