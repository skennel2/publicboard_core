package org.almansa.app.core.comment;

import org.almansa.app.core.Entity;
import org.almansa.app.core.MarkCreationDate;
import org.almansa.app.core.WritableTextContents;

public interface Comment extends Entity<Long>, WritableTextContents, MarkCreationDate{
	OwnerPostInfomation getOwnerPostInfomation();
}
