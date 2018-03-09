package org.almansa.app.core.service;

public abstract class ServiceBase {
    protected void verifyNotNull(Object obj) {
        if (obj == null) {
            throw new RuntimeException();
        }
    }

    protected void verifyEquals(Object obj1, Object obj2) {
        if (!obj1.equals(obj2)) {
            throw new RuntimeException();
        }
    }
}
