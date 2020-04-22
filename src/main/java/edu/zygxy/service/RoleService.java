package edu.zygxy.service;

import edu.zygxy.pojo.Role;

import java.util.List;

/**
 * Created by liangjiateng on 2017/5/2.
 */
public interface RoleService {

    Role getRoleById(long id);

    List<Role> listRoles();
}
