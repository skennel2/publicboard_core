package org.almansa.app.core.entity.post;

import org.almansa.app.core.ChangableNamed;
import org.almansa.app.core.ClickCountable;
import org.almansa.app.core.CreationDateRecordable;
import org.almansa.app.core.Entity;
import org.almansa.app.core.ModifiedDateRecordable;
import org.almansa.app.core.WritableTextContentsContainable;

public interface Post extends Entity<Long>, ChangableNamed, ClickCountable, WritableTextContentsContainable,
		CreationDateRecordable, ModifiedDateRecordable {
	Long getOwnerBoardId();

	Long getWriterId();

	boolean isPossibleDelete(Long userId);

	boolean isPossibleModify(Long userId);
}