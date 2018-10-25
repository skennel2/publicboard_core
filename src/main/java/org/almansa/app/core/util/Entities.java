package org.almansa.app.core.util;

import java.util.Objects;

import org.almansa.app.core.Entity;
import org.almansa.app.core.exception.EntityExistsException;
import org.almansa.app.core.exception.EntityNotFoundException;

public final class Entities {
	
	private Entities() {
	}
	
	static public void assertEntityFound(Entity<Long> entity, String message) throws EntityNotFoundException {
		if (Objects.isNull(entity)) {
			throw new EntityNotFoundException(message);
		}
		
		if (Objects.isNull(entity.getId())) {
			throw new EntityNotFoundException(message);
		}
	}
	
	static public void assertEntityNotAleadyExists(Entity<Long> entity, String message) throws EntityExistsException {
		if (Objects.nonNull(entity)) {
			throw new EntityExistsException(message);
		}
	}
}
