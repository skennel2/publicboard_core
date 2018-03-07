package org.almansa.app.core;

public interface ClickCountable {
	int getClickCount();
	void increaseClickCount(long clickUserId);
}
