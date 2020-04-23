package edu.zygxy.dao;

import edu.zygxy.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by guofumei on 2019/11/2.
 */
@Mapper
public interface RoleMapper {

    Role getRoleById(long id);

    List<Role> listRoles();
}
