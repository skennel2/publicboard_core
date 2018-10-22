package org.almansa.app.core.entity.post;

import java.util.Date;

import org.almansa.app.core.Immutable;
import org.almansa.app.core.TextContentsContainable;

public class CommentInPost implements Immutable, TextContentsContainable{
    private Long writerId;
    private Date writeDate;    
    private String contents;
    
    public CommentInPost(Long writerId, Date writeDate, String contents) {
        super();
        this.writerId = writerId;
        this.writeDate = writeDate;
        this.contents = contents;
    }
    
    public Long getWriterId() {
        return writerId;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    @Override
    public String getContents() {
        return contents;
    }    
}