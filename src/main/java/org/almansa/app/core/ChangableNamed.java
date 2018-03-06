package org.almansa.app.core;

public interface ChangableNamed extends Named{
	void changeName(String newName);
	int getMaximumNameLength(); 
}