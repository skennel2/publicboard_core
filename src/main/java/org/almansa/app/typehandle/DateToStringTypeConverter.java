package org.almansa.app.typehandle;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateToStringTypeConverter implements Converter<Date, String>{
    
    private String dateStringFormat;
           
    public DateToStringTypeConverter(String dateStringFormat) {
        super();
        this.dateStringFormat = dateStringFormat;
    }

    @Override
    public String convert(Date source) {        
        String date = new SimpleDateFormat(dateStringFormat).format(source);
        return date;
    }
}