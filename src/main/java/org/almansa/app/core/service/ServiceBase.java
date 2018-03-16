package org.almansa.app.core.service;

public abstract class ServiceBase {
    protected void verifyNotNull(Object obj) {
        if (obj == null) {
            throw new RuntimeException("obj" +"is null");
        }
    }

    protected void verifyEquals(Object obj1, Object obj2) {
        verifyNotNull(obj1);
        verifyNotNull(obj2);
        
        if (!obj1.equals(obj2)) {
            throw new RuntimeException(obj1.toString() + "not equals" + obj2.toString());
        }
    }
}
