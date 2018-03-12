package org.almansa.app.service.memberService;

import org.almansa.app.service.dto.LoginUserSessionModel;

public interface MemberService {

    /**
     * 로그인 성공 LoginUserSessionModel 리턴 
     * 실패 null 리턴
     * @param loginId
     * @param password
     * @return
     */
    LoginUserSessionModel loginAndGetUserSessionModel(String loginId, String password);

    void joinSimply(String loginId, String password);

}