package org.almansa.app.core.util;

import java.util.Objects;

import javax.persistence.EntityNotFoundException;

public final class Entities {
	
	private Entities() {
	}
	
	static public void assertEntityNotFound(Object entity, String message) throws EntityNotFoundException {
		if (Objects.isNull(entity)) {
			throw new EntityNotFoundException(message);
		}
	}

	static public Object requireEntityFound(Object entity, String message) throws EntityNotFoundException {
		assertEntityNotFound(entity, message);

		return entity;
	}
}
