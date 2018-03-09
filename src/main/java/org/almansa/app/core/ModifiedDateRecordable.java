package org.almansa.app.core;

import java.util.Date;

public interface ModifiedDateRecordable {
    Date getModifiedDate();

    void changeModifiedDate(Date newDate);
}