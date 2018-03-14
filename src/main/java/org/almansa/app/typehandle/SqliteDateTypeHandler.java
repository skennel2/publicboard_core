package org.almansa.app.typehandle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Sqlite에는 Date 타입이 없기 때문에 자바에서 Date로 관리되는 값을 Sqlite의 TEXT 값으로 바라 볼수 있게 해준다. 
 * @author skennel
 *
 */
@Component
public class SqliteDateTypeHandler implements TypeHandler<Date>{

    public static final String dateFormat = "yyyyMMdd:hhmmss";

    private Date getOldDate() {
        Calendar cal= Calendar.getInstance();
        cal.set(2000, 1, 1);
        
        return cal.getTime();
    }
    
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
            return getOldDate();
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
            return getOldDate();
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
            return getOldDate();
        }
        
        return date;
    }
}
