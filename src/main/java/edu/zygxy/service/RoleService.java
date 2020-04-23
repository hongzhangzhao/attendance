package edu.zygxy.service;

import edu.zygxy.pojo.Role;

import java.util.List;

/**
 * Created by guofumei on 2019/11/2.
 */
public interface RoleService {

    Role getRoleById(long id);

    List<Role> listRoles();
}
