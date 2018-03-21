package org.almansa.app.core.entity.board;

import java.util.List;

import org.almansa.app.core.ChangableNamed;
import org.almansa.app.core.CreationDateRecordable;
import org.almansa.app.core.Entity;

public interface Board extends Entity<Long>, ChangableNamed, CreationDateRecordable {
    List<String> getCategories();

    boolean isAbleToWrite();

    void blockToWrite();

    void allowToWrite();
}
