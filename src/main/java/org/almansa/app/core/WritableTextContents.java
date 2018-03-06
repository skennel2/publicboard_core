package org.almansa.app.core;

public interface WritableTextContents extends TextContents{
	void write(String contents);
	WriterInfomation getWriterInfomation();
}