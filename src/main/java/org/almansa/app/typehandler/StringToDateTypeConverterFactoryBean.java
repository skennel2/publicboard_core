package org.almansa.app.typehandler;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service
public class StringToDateTypeConverterFactoryBean implements FactoryBean<StringToDateTypeConverter>{

    public static final String dateFormat = "yyyyMMdd:hhmmss";
    
    private StringToDateTypeConverter instance;
           
    public StringToDateTypeConverterFactoryBean() {
        super();
        instance = new StringToDateTypeConverter(dateFormat);
    }

    @Override
    public StringToDateTypeConverter getObject() throws Exception {
        return instance;
    }

    @Override
    public Class<?> getObjectType() {
        return StringToDateTypeConverter.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}