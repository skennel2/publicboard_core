package org.almansa.app.core.post;

import org.almansa.app.core.ChangableNamed;
import org.almansa.app.core.Entity;
import org.almansa.app.core.MarkCreationDate;
import org.almansa.app.core.MarkModifyDate;
import org.almansa.app.core.TextContents;
import org.almansa.app.core.WritableTextContents;
import org.almansa.app.core.WriterInfomation;

public interface Post extends Entity<Long>, ChangableNamed, WritableTextContents, MarkCreationDate, MarkModifyDate{
	OwnerBoardInfomation getOwnerBoardInfomation();
	WriterInfomation getWriterInfomation();
	
	int getMaximumNameLength();
}
