package org.almansa.app.core.entity.post;

import java.util.Date;

public final class TextPostWithComment extends DefaultTextPost{
        
    public TextPostWithComment(Long id, String name, Date creationDate, Date modifyDate, String contents,
    		Long ownerBoardId, Long writerId, Integer clickCount) {
        super(id, name, creationDate, modifyDate, contents, ownerBoardId, writerId, clickCount);
    }
    
    public TextPostWithComment(String name, Date creationDate, Date modifyDate, String contents,
    		Long ownerBoardId, Long writerId, Integer clickCount) {
        super(name, creationDate, modifyDate, contents, ownerBoardId, writerId, clickCount);
    }    
}
