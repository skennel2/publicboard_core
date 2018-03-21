package org.almansa.app.core.entity.post;

import java.util.Date;

import org.almansa.app.core.OwnerBoardInfomation;
import org.almansa.app.core.MemberDefaultInfomation;

public class DefaultTextPost implements Post {

    private Long id;
    private String name;
    private Date creationDate;
    private Date modifyDate;
    private String contents;
    private OwnerBoardInfomation ownerBoardInfomation;
    private MemberDefaultInfomation writerInfomation;

    private int clickCount;

    public DefaultTextPost(String name, Date creationDate, Date modifyDate, String contents,
            OwnerBoardInfomation ownerBoardInfomation, MemberDefaultInfomation writerInfomation, Integer clickCount) {
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
            OwnerBoardInfomation ownerBoardInfomation, MemberDefaultInfomation writerInfomation, Integer clickCount) {
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
    public MemberDefaultInfomation getWriterInfomation() {
        return writerInfomation;
    }

    @Override
    public int getClickCount() {
        return clickCount;
    }

    @Override
    public void increaseClickCount(long clickUserId) {
        if (clickUserId != writerInfomation.getMemberId()) {
            this.clickCount++;
        }
    }

    @Override
    public boolean isPossibleDelete(long userId) {
        return userId == this.writerInfomation.getMemberId();
    }

    @Override
    public boolean isPossibleModify(long userId) {
        return userId == this.writerInfomation.getMemberId();
    }

    @Override
    public String toString() {
        return "DefaultTextPost [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", modifyDate="
                + modifyDate + ", contents=" + contents + ", ownerBoardInfomation=" + ownerBoardInfomation
                + ", writerInfomation=" + writerInfomation + ", clickCount=" + clickCount + "]";
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
        DefaultTextPost other = (DefaultTextPost) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }  
}