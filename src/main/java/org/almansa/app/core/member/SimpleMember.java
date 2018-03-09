package org.almansa.app.core.member;

public class SimpleMember implements Member {

    private Long id;
    private String loginId;
    private String password;

    public SimpleMember(Long id, String loginId, String password) {
        super();
        this.id = id;
        this.loginId = loginId;
        this.password = password;
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
    public String toString() {
        return "SimpleMember [id=" + id + ", loginId=" + loginId + "]";
    }
}
