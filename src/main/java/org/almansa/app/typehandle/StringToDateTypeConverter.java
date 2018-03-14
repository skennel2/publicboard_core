package org.almansa.app.typehandle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component()
public class StringToDateTypeConverter implements Converter<String, Date>{
    
    private String dateStringFormat;
    
    public StringToDateTypeConverter(String dateStringFormat) {
        super();
        this.dateStringFormat = dateStringFormat;
    }
    
    @Override
    public Date convert(String source){
        Date date = null;
        try {
            date = new SimpleDateFormat(dateStringFormat).parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }    
}