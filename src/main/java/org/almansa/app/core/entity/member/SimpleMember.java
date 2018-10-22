package org.almansa.app.core.entity.member;

public class SimpleMember implements Member {

    private Long id;
    private String loginId;
    private String password;
    
    private Boolean isAdmin;

    public SimpleMember(Long id, String loginId, String password, Boolean isAdmin) {
        super();
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public SimpleMember(String loginId, String password, Boolean isAdmin) {
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
    public Boolean isAdmin() {
        return isAdmin;
    }
    
    @Override
    public String toString() {
        return "SimpleMember [id=" + id + ", loginId=" + loginId + ", password=" + password + ", isAdmin=" + isAdmin
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimpleMember other = (SimpleMember) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }               
}
