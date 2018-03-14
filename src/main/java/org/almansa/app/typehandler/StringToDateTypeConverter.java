package org.almansa.app.typehandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateTypeConverter implements Converter<String, Date>{
    
    private String dateStringFormat;
    
    public StringToDateTypeConverter(String dateStringFormat) {
        super();
        this.dateStringFormat = dateStringFormat;
    }
    
    public String getDateStringFormat() {
        return dateStringFormat;
    }

    public void setDateStringFormat(String dateStringFormat) {
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