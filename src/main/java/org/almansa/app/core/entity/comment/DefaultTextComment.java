package org.almansa.app.core.entity.comment;

import java.util.Date;

import org.almansa.app.core.OwnerPostInfomation;
import org.almansa.app.core.WriterInfomation;

public class DefaultTextComment implements Comment {

    private Long id;
    private Date creationDate;
    private String contents;
    private OwnerPostInfomation ownerPostInfomation;
    private WriterInfomation writerInfomation;

    public DefaultTextComment(Long id, Date creationDate, String contents, OwnerPostInfomation ownerPostInfomation,
            WriterInfomation writerInfomation) {
        super();
        this.id = id;
        this.creationDate = creationDate;
        this.contents = contents;
        this.ownerPostInfomation = ownerPostInfomation;
        this.writerInfomation = writerInfomation;
    }

    public DefaultTextComment(Date creationDate, String contents, OwnerPostInfomation ownerPostInfomation,
            WriterInfomation writerInfomation) {
        super();
        this.creationDate = creationDate;
        this.contents = contents;
        this.ownerPostInfomation = ownerPostInfomation;
        this.writerInfomation = writerInfomation;
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
    public OwnerPostInfomation getOwnerPostInfomation() {
        return ownerPostInfomation;
    }

    @Override
    public boolean isPossibleToDelete(Long userId) {        
        return userId.equals(writerInfomation.getWriterId());
    }

    @Override
    public String toString() {
        return "DefaultTextComment [id=" + id + ", creationDate=" + creationDate + ", contents=" + contents
                + ", ownerPostInfomation=" + ownerPostInfomation + ", writerInfomation=" + writerInfomation + "]";
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
        DefaultTextComment other = (DefaultTextComment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }      
}