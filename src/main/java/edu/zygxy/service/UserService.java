package edu.zygxy.service;

import edu.zygxy.pojo.User;

import java.util.List;

/**
 * Created by liangjiateng on 2017/5/2.
 */
public interface UserService {

    long countUserByDepartmentId(long id);

    User getUserById(long id);

    User getUserByEmail(String email);

    List<User> listUsers();

    List<User> listUsersByDepartmentId(long departmentId);

    List<String> listUserNamesByRoleIdAndDepartmentId(long roleId,long departmentId);

    void insertUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUserById(long id);
}
