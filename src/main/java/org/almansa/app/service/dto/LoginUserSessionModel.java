package org.almansa.app.service.dto;

public class LoginUserSessionModel {
    private Long id;
    private String loginId;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    
    @Override
    public String toString() {
        return "LoginUserSessionModel [id=" + id + ", loginId=" + loginId + "]";
    }
}
