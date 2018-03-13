package org.almansa.app.core.service.member;

import org.almansa.app.core.member.Member;
import org.almansa.app.core.member.SimpleMember;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.service.ServiceBase;
import org.almansa.app.core.service.dto.LoginUserSessionModel;
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

    /* (non-Javadoc)
     * @see org.almansa.app.service.memberService.MemberService#loginAndGetUserSessionModel(java.lang.String, java.lang.String)
     */
    @Override
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
    
    /* (non-Javadoc)
     * @see org.almansa.app.service.memberService.MemberService#joinSimply(java.lang.String, java.lang.String)
     */
    @Override
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
