package org.almansa.app.core;

public interface WritableTextContentsContainable extends TextContents {
    void write(String contents);

    WriterInfomation getWriterInfomation();
}