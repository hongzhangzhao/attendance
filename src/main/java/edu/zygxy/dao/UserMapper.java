package edu.zygxy.dao;

import edu.zygxy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liangjiateng on 2017/4/17.
 */
@Mapper
public interface UserMapper {

    long countUserByDepartmentId(long departmentId);

    User getUserById(long id);

    User getUserByEmail(String email);

    List<User> listUsers();

    List<User> listUsersByDepartmentId(long departmentId);

    List<String> listUserNamesByRoleIdAndDepartmentId(@Param("roleId") long roleId, @Param("departmentId") long departmentId);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(long id);
}
