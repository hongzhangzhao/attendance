package edu.zygxy.dao;

import edu.zygxy.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liangjiateng on 2017/5/2.
 */
@Mapper
public interface RoleMapper {

    Role getRoleById(long id);

    List<Role> listRoles();
}
