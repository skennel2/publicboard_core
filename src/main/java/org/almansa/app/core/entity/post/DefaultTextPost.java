package org.almansa.app.core.entity.post;

import java.util.Date;

public class DefaultTextPost implements Post {

    private Long id;
    private String name;
    private Date creationDate;
    private Date modifyDate;
    private String contents;
    private Long ownerBoardId;
    private Long writerId;

    private int clickCount;

    public DefaultTextPost(String name, Date creationDate, Date modifyDate, String contents,
    		Long ownerBoardId, Long writerId, Integer clickCount) {
        super();
        this.name = name;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.contents = contents;
        this.ownerBoardId = ownerBoardId;
        this.writerId = writerId;
        this.clickCount = clickCount;
    }

    public DefaultTextPost(Long id, String name, Date creationDate, Date modifyDate, String contents,
    		Long ownerBoardId, Long writerId, Integer clickCount) {
        super();
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.contents = contents;
        this.ownerBoardId = ownerBoardId;
        this.writerId = writerId;
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

    public Long getOwnerBoardId() {
		return ownerBoardId;
	}

	public void setOwnerBoardId(Long ownerBoardId) {
		this.ownerBoardId = ownerBoardId;
	}
	
	@Override
	public Long getWriterId() {
		return writerId;
	}

	public void setWriterId(Long writerId) {
		this.writerId = writerId;
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
    public int getClickCount() {
        return clickCount;
    }

    @Override
    public void increaseClickCount(Long clickUserId) {
        if (clickUserId != writerId) {
            this.clickCount++;
        }
    }

    @Override
    public boolean isPossibleDelete(Long userId) {
        return userId == writerId;
    }

    @Override
    public boolean isPossibleModify(Long userId) {
        return userId == this.writerId;
    }

    @Override
	public String toString() {
		return "DefaultTextPost [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", modifyDate="
				+ modifyDate + ", contents=" + contents + ", ownerBoardId=" + ownerBoardId + ", writerId=" + writerId
				+ ", clickCount=" + clickCount + "]";
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