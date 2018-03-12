package org.almansa.app.core.comment;

import java.util.Date;

import org.almansa.app.core.OwnerPostInfomation;
import org.almansa.app.core.WriterInfomation;

public class DefaultTextComment implements Comment {

    private Long id;
    private Date creationDate;
    private String contents;
    private OwnerPostInfomation ownerPostInfomation;
    private WriterInfomation writerInfomation;

    private int maximumContentsLength;

    public DefaultTextComment(Long id, Date creationDate, String contents, OwnerPostInfomation ownerPostInfomation,
            WriterInfomation writerInfomation, int maximumContentsLength) {
        super();
        this.id = id;
        this.creationDate = creationDate;
        this.contents = contents;
        this.ownerPostInfomation = ownerPostInfomation;
        this.writerInfomation = writerInfomation;
        this.maximumContentsLength = maximumContentsLength;
    }

    public DefaultTextComment(Date creationDate, String contents, OwnerPostInfomation ownerPostInfomation,
            WriterInfomation writerInfomation, int maximumContentsLength) {
        super();
        this.creationDate = creationDate;
        this.contents = contents;
        this.ownerPostInfomation = ownerPostInfomation;
        this.writerInfomation = writerInfomation;
        this.maximumContentsLength = maximumContentsLength;
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
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(Date creationTime) {
        this.creationDate = creationTime;
    }

    @Override
    public void write(String contents) {
        this.contents = contents;
    }

    @Override
    public String getContents() {
        return contents;
    }

    @Override
    public WriterInfomation getWriterInfomation() {
        return writerInfomation;
    }

    @Override
    public int getMaximumTextLength() {
        return maximumContentsLength;
    }

    @Override
    public OwnerPostInfomation getOwnerPostInfomation() {
        return ownerPostInfomation;
    }

}