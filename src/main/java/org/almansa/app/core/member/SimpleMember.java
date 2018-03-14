package org.almansa.app.core.member;

public class SimpleMember implements Member {

    private Long id;
    private String loginId;
    private String password;
    
    private boolean isAdmin;

    public SimpleMember(Long id, String loginId, String password, boolean isAdmin) {
        super();
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public SimpleMember(String loginId, String password, boolean isAdmin) {
        super();        
        this.loginId = loginId;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getLoginId() {
        return loginId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAdmin() {
        return isAdmin;
    }
    
    @Override
    public String toString() {
        return "SimpleMember [id=" + id + ", loginId=" + loginId + "]";
    }
}
