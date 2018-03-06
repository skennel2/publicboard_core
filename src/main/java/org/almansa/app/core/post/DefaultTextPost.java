package org.almansa.app.core.post;

import java.util.Date;

import org.almansa.app.core.OwnerBoardInfomation;
import org.almansa.app.core.WriterInfomation;

public class DefaultTextPost implements Post{

	private long id;
	private String name;
	private Date creationDate;
	private Date modifyDate;
	private String contents;
	private OwnerBoardInfomation ownerBoardInfomation;
	private WriterInfomation writerInfomation;
	
	private int maximumContentsLength;
	private int maximumNameLength;

	public DefaultTextPost(String name, Date creationDate, Date modifyDate, String contents,
			OwnerBoardInfomation ownerBoardInfomation, WriterInfomation writerInfomation, int maximumContentsLength,
			int maximumNameLength) {
		super();
		this.name = name;
		this.creationDate = creationDate;
		this.modifyDate = modifyDate;
		this.contents = contents;
		this.ownerBoardInfomation = ownerBoardInfomation;
		this.writerInfomation = writerInfomation;
		this.maximumContentsLength = maximumContentsLength;
		this.maximumNameLength = maximumNameLength;
	}
	
	public DefaultTextPost(long id, String name, Date creationDate, Date modifyDate, String contents,
			OwnerBoardInfomation ownerBoardInfomation, WriterInfomation writerInfomation, int maximumContentsLength,
			int maximumNameLength) {
		super();
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.modifyDate = modifyDate;
		this.contents = contents;
		this.ownerBoardInfomation = ownerBoardInfomation;
		this.writerInfomation = writerInfomation;
		this.maximumContentsLength = maximumContentsLength;
		this.maximumNameLength = maximumNameLength;
	}	

	@Override
	public Long getId() {
		return id;
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
		// TODO Auto-generated method stub
		return writerInfomation;
	}

	@Override
	public int getMaximumNameLength() {
		return maximumNameLength;
	}
	
	@Override
	public int getMaximumTextLength() {
		// TODO Auto-generated method stub
		return maximumContentsLength;
	}
}