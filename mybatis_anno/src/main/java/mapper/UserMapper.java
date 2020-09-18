package mapper;

import domain.Order;
import domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user values(#{id}, #{username}, #{password}, #{birthday})")
    void save(User user);

    @Delete("delete from user where id = #{id}")
    void delete(int id);

    @Update("update user set username = #{username}, password = #{password}, birthday = #{birthday} where id = #{id}")
    void update(User user);

    @Select("select * from user where id = #{id}")
    User findById(int id);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    javaType = List.class,
                    column = "id",
                    property = "orderList",
                    many = @Many(select = "mapper.OrderMapper.findByUid")
            )
    })
    List<User> findUserAndOrderAll();

    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    javaType = List.class,
                    column = "id",
                    property = "roleList",
                    many = @Many(select = "mapper.RoleMapper.findByUid")
            )
    })
    List<User> findUserAndRoleAll();
}
