package org.almansa.app.service.memberService;

import org.almansa.app.core.member.Member;
import org.almansa.app.core.service.ServiceBase;
import org.almansa.app.core.service.repository.MemberRepository;

public class MemberService extends ServiceBase{
    private MemberRepository memberRepo;
    
    public boolean login(String loginId, String password) {
        Member member = memberRepo.getByLoginId(loginId);
        
        boolean isSuccess = (member != null && member.getPassword().equals(password));
        
        return isSuccess;
    }    
}
