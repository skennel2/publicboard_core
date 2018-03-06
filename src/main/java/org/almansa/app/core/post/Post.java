package org.almansa.app.core.post;

import org.almansa.app.core.ChangableNamed;
import org.almansa.app.core.ClickCountable;
import org.almansa.app.core.Entity;
import org.almansa.app.core.CreationDateRecordable;
import org.almansa.app.core.ModifiedDateRecordable;
import org.almansa.app.core.Named;
import org.almansa.app.core.OwnerBoardInfomation;
import org.almansa.app.core.TextContents;
import org.almansa.app.core.WritableTextContentsContainable;
import org.almansa.app.core.WriterInfomation;

public interface Post extends Entity<Long>, ChangableNamed, ClickCountable, WritableTextContentsContainable, CreationDateRecordable, ModifiedDateRecordable{
	OwnerBoardInfomation getOwnerBoardInfomation();
	WriterInfomation getWriterInfomation();
	
	int getMaximumNameLength();
}