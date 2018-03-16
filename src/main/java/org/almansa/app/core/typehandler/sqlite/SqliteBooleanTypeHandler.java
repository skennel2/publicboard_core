package org.almansa.app.core.typehandler.sqlite;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class SqliteBooleanTypeHandler implements TypeHandler<Boolean>{

    @Override
    public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return value.equals("T") ? true : false;
    }

    @Override
    public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return value.equals("T") ? true : false;
    }

    @Override
    public Boolean getResult(CallableStatement cs, int columnName) throws SQLException {
        String value = cs.getString(columnName);
        return value.equals("T") ? true : false;
    }

    @Override
    public void setParameter(PreparedStatement ps, int index, Boolean value, JdbcType jdvcType) throws SQLException {
        if(value) {
            ps.setString(index, "T");
        }else {
            ps.setString(index, "F");
        }        
    }
}
