package org.almansa.app.core.entity.comment;

import org.almansa.app.core.CreationDateRecordable;
import org.almansa.app.core.Entity;
import org.almansa.app.core.PostDefaultInfomation;
import org.almansa.app.core.WritableTextContentsContainable;

public interface Comment extends Entity<Long>, WritableTextContentsContainable, CreationDateRecordable {
    PostDefaultInfomation getOwnerPostInfomation();

    boolean isPossibleToDelete(Long userId);
}
