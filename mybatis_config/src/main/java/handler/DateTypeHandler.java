package handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    // 将java类型转换成数据库需要的类型
    public void setNonNullParameter(PreparedStatement ps, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        ps.setLong(i, time);
    }

    /**
     * 将数据库中类型转换成java类型
     * @param rs            查询出的结果集
     * @param columnName    要转换的字段名称
     * @return
     * @throws SQLException
     */
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        //获得结果集中需要的数据(1ong)转换成Date类型返回
        long aLong = rs.getLong(columnName);
        Date date = new Date(aLong);
        return date;
    }

    // 将数据库中类型转换成java类型
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long aLong = rs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }

    // 将数据库中类型转换成java类型
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long aLong = cs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }
}
