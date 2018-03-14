package org.almansa.app.typehandler;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service
public class DateToStringTypeConverterFactoryBean implements FactoryBean<DateToStringTypeConverter>{

    public static final String dateFormat = "yyyyMMdd:hhmmss";
    
    private DateToStringTypeConverter instance;
           
    public DateToStringTypeConverterFactoryBean() {
        super();
        instance = new DateToStringTypeConverter(dateFormat);
    }

    @Override
    public DateToStringTypeConverter getObject() throws Exception {
        return instance;
    }

    @Override
    public Class<?> getObjectType() {
        return DateToStringTypeConverter.class; 
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
