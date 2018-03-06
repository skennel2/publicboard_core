package org.almansa.app.core.board;

import java.util.List;

import org.almansa.app.core.ChangableNamed;
import org.almansa.app.core.Entity;
import org.almansa.app.core.CreationDateRecordable;
import org.almansa.app.core.TextContents;

public interface Board extends Entity<Long>, ChangableNamed, CreationDateRecordable{
	List<String> getCategories();
	boolean isAbleToWrite();
	void blockToWrite();
	void allowToWrite();
}
