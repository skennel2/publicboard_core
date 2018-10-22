package org.almansa.app.core;

public interface WritableTextContentsContainable extends TextContentsContainable {
    void write(String contents);

    Long getWriterId();
}