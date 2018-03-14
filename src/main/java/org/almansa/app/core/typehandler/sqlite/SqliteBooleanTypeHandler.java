package org.almansa.app.core.typehandler.sqlite;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class SqliteBooleanTypeHandler implements TypeHandler<Boolean>{

    @Override
    public Boolean getResult(ResultSet arg0, String arg1) throws SQLException {
        String value = arg0.getString(arg1);
        return value.equals("T") ? true : false;
    }

    @Override
    public Boolean getResult(ResultSet arg0, int arg1) throws SQLException {
        String value = arg0.getString(arg1);
        return value.equals("T") ? true : false;
    }

    @Override
    public Boolean getResult(CallableStatement arg0, int arg1) throws SQLException {
        String value = arg0.getString(arg1);
        return value.equals("T") ? true : false;
    }

    @Override
    public void setParameter(PreparedStatement arg0, int arg1, Boolean arg2, JdbcType arg3) throws SQLException {
        if(arg2) {
            arg0.setString(arg1, "T");
        }else {
            arg0.setString(arg1, "F");
        }
        
    }

}
