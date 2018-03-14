package org.almansa.app.core.post;

import java.util.Date;

import org.almansa.app.core.OwnerBoardInfomation;
import org.almansa.app.core.WriterInfomation;

public class DefaultTextPost implements Post {

    private Long id;
    private String name;
    private Date creationDate;
    private Date modifyDate;
    private String contents;
    private OwnerBoardInfomation ownerBoardInfomation;
    private WriterInfomation writerInfomation;

    private int clickCount;

    public DefaultTextPost(String name, Date creationDate, Date modifyDate, String contents,
            OwnerBoardInfomation ownerBoardInfomation, WriterInfomation writerInfomation, Integer clickCount) {
        super();
        this.name = name;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.contents = contents;
        this.ownerBoardInfomation = ownerBoardInfomation;
        this.writerInfomation = writerInfomation;
        this.clickCount = clickCount;
    }

    public DefaultTextPost(Long id, String name, Date creationDate, Date modifyDate, String contents,
            OwnerBoardInfomation ownerBoardInfomation, WriterInfomation writerInfomation, Integer clickCount) {
        super();
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.contents = contents;
        this.ownerBoardInfomation = ownerBoardInfomation;
        this.writerInfomation = writerInfomation;
        this.clickCount = clickCount;
    }    

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void changeName(String newName) {
        this.name = newName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCreationDate(Date creationTime) {
        this.creationDate = creationTime;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public Date getModifiedDate() {
        return modifyDate;
    }

    @Override
    public void changeModifiedDate(Date newDate) {
        this.modifyDate = newDate;
    }

    @Override
    public OwnerBoardInfomation getOwnerBoardInfomation() {
        return ownerBoardInfomation;
    }

    @Override
    public String getContents() {
        return contents;
    }

    @Override
    public void write(String contents) {
        this.contents = contents;
    }

    @Override
    public WriterInfomation getWriterInfomation() {
        return writerInfomation;
    }

    @Override
    public int getClickCount() {
        return clickCount;
    }

    @Override
    public void increaseClickCount(long clickUserId) {
        if (clickUserId != writerInfomation.getWriterId()) {
            this.clickCount++;
        }
    }

    @Override
    public boolean isPossibleDelete(long userId) {
        return userId == this.writerInfomation.getWriterId();
    }

    @Override
    public boolean isPossibleModify(long userId) {
        return userId == this.writerInfomation.getWriterId();
    }
}