package org.almansa.app.core.entity.member;

import org.almansa.app.core.Entity;

public interface Member extends Entity<Long> {
    public String getLoginId();

    public String getPassword();
    
    public Boolean isAdmin();
}
