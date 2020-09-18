package mapper;

import domain.Order;
import domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

//    @Select("select *, o.id oid from orders o, user u where o.uid = u.id")
//    @Results({
//            @Result(column = "oid", property = "id"),
//            @Result(column = "ordertime", property = "ordertime"),
//            @Result(column = "total", property = "total"),
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "username", property = "user.username"),
//            @Result(column = "password", property = "user.password"),
//            @Result(column = "birthday", property = "user.birthday")
//    })
//    List<Order> findAll();

    @Select("select * from orders")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    javaType = User.class,      // 要封装的实体类型
                    property = "user",          // 要封装的属性名称
                    column = "uid",             // 根据这个字段去查询user表的数据
                    // select属性代表查询那个接口的方法获得数据
                    one = @One(select = "mapper.UserMapper.findById")
            )
    })
    List<Order> findAll();

    @Select("select * from orders where uid = #{uid}")
    List<Order> findByUid(int uid);
}
