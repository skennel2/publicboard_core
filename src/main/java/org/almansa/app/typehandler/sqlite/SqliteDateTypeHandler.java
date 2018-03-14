package org.almansa.app.typehandler.sqlite;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.almansa.app.typehandler.DateToStringTypeConverter;
import org.almansa.app.typehandler.StringToDateTypeConverter;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Sqlite에는 Date 타입이 없기 때문에 자바에서 Date로 관리되는 값을 Sqlite의 TEXT 값으로 바라 볼수 있게 해준다. 
 * 
 * Mybatis에서 매핑시 이 클래스를 사용하게 될때 스프링에서 빈으로 취득해서 사용하는 것이 아니다... 
 * 때문에 안에서 사용한 빈들은 안먹힌다. 
 * @author skennel
 *
 */
public class SqliteDateTypeHandler implements TypeHandler<Date>{

    public static final String dateFormat = "yyyyMMdd:hhmmss";

    private DateToStringTypeConverter dateToStringTypeConverter = new DateToStringTypeConverter(dateFormat);   
    private StringToDateTypeConverter stringToDateTypeConverter = new StringToDateTypeConverter(dateFormat); 
       
    private Date getOldDate() {
        Calendar cal= Calendar.getInstance();
        cal.set(1900, 1, 1);
        
        return cal.getTime();
    }
    
    @Override
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
         String date = dateToStringTypeConverter.convert(parameter);
         ps.setString(i, date);      
    }

    @Override
    public Date getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);           
        return stringToDateTypeConverter.convert(value);
    }

    @Override
    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);         
        return stringToDateTypeConverter.convert(value);
    }

    @Override
    public Date getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);            
        return stringToDateTypeConverter.convert(value);
    }
}
