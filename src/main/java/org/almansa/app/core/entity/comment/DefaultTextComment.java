package org.almansa.app.core.entity.comment;

import java.util.Date;

public class DefaultTextComment implements Comment {

	private Long id;
	private Date creationDate;
	private String contents;
	private Long ownerPostId;
	private Long writerId;

	public DefaultTextComment(Long id, Date creationDate, String contents, Long ownerPostId, Long writerId) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.contents = contents;
		this.ownerPostId = ownerPostId;
		this.writerId = writerId;
	}

	public DefaultTextComment(Date creationDate, String contents, Long ownerPostId, Long writerId) {
		super();
		this.creationDate = creationDate;
		this.contents = contents;
		this.ownerPostId = ownerPostId;
		this.writerId = writerId;
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
	public Long getWriterId() {
		return writerId;
	}

	@Override
	public Long getOwnerPostId() {
		return ownerPostId;
	}

	@Override
	public boolean isPossibleToDelete(Long userId) {
		return userId.equals(writerId);
	}

	@Override
	public String toString() {
		return "DefaultTextComment [id=" + id + ", creationDate=" + creationDate + ", contents=" + contents
				+ ", ownerPostId=" + ownerPostId + ", writerId=" + writerId + "]";
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