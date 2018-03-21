package org.almansa.app.core.entity.post;

import java.util.Date;

import org.almansa.app.core.Immutable;
import org.almansa.app.core.MemberDefaultInfomation;
import org.almansa.app.core.TextContentsContainable;

public class CommentInPost implements Immutable, TextContentsContainable{
    private MemberDefaultInfomation writerInfomation;
    private Date writeDate;    
    private String contents;
    
    public CommentInPost(MemberDefaultInfomation writerInfomation, Date writeDate, String contents) {
        super();
        this.writerInfomation = writerInfomation;
        this.writeDate = writeDate;
        this.contents = contents;
    }
    
    public MemberDefaultInfomation getWriterInfomation() {
        return writerInfomation;
    }

    public Date getWriteDate() {
        return writeDate;
    }


    @Override
    public String getContents() {
        return contents;
    }    
}