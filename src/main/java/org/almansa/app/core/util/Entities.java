package org.almansa.app.core.util;

import java.util.Objects;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.almansa.app.core.Entity;

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
