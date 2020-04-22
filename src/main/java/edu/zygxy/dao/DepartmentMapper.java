package edu.zygxy.dao;

import edu.zygxy.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Created by liangjiateng on 2017/4/17.
 */
@Mapper
public interface DepartmentMapper {

    int insertDepartment(Department department);

    int updateDepartment(Department department);

    Department getDepartmentById(long id);

    List<Department> listDepartments();

    int deleteDepartmentById(long id);
}
