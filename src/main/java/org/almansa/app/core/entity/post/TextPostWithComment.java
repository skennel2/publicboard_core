package org.almansa.app.core.entity.post;

import java.util.Date;

import org.almansa.app.core.MemberDefaultInfomation;
import org.almansa.app.core.OwnerBoardInfomation;

public final class TextPostWithComment extends DefaultTextPost{
        
    public TextPostWithComment(Long id, String name, Date creationDate, Date modifyDate, String contents,
            OwnerBoardInfomation ownerBoardInfomation, MemberDefaultInfomation writerInfomation, Integer clickCount) {
        super(id, name, creationDate, modifyDate, contents, ownerBoardInfomation, writerInfomation, clickCount);
        // TODO Auto-generated constructor stub
    }
    
    public TextPostWithComment(String name, Date creationDate, Date modifyDate, String contents,
            OwnerBoardInfomation ownerBoardInfomation, MemberDefaultInfomation writerInfomation, Integer clickCount) {
        super(name, creationDate, modifyDate, contents, ownerBoardInfomation, writerInfomation, clickCount);
        // TODO Auto-generated constructor stub
    }    
}
