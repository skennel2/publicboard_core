package org.almansa.app.core.comment;

import java.util.Date;

import org.almansa.app.core.OwnerPostInfomation;
import org.almansa.app.core.WriterInfomation;

public class DefaultTextComment implements Comment{

	private long id;
	private Date creationDate;
	private String contents;
	private OwnerPostInfomation ownerPostInfomation;
	private WriterInfomation writerInfomation;
	
	private int maximumContentsLength;

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