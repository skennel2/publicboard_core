package org.almansa.app.core.repository.post;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class SqliteDateTypeHandler implements TypeHandler<Date>{

    private final String dateFormat = "yyyyMMdd:hhmmss";
    
    @Override
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
         String date = new SimpleDateFormat(dateFormat).format(parameter);
         ps.setString(i, date);
    }

    @Override
    public Date getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        
        Date date = null;
        try {
            date = new SimpleDateFormat(dateFormat).parse(value);
        } catch (ParseException e) {
            Date oldDate = new Date();
            oldDate.setYear(2000);
            oldDate.setMonth(1);
            oldDate.setDate(1);
            return oldDate;
        }
        
        return date;
    }

    @Override
    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        
        Date date = null;
        try {
            date = new SimpleDateFormat(dateFormat).parse(value);
        } catch (ParseException e) {
            Date oldDate = new Date();
            oldDate.setYear(2000);
            oldDate.setMonth(1);
            oldDate.setDate(1);
            return oldDate;
        }
        
        return date;
    }

    @Override
    public Date getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        
        Date date = null;
        try {
            date = new SimpleDateFormat(dateFormat).parse(value);
        } catch (ParseException e) {
            Date oldDate = new Date();
            oldDate.setYear(2000);
            oldDate.setMonth(1);
            oldDate.setDate(1);
            return oldDate;
        }
        
        return date;
    }
}
