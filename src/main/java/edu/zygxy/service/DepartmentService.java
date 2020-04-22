package edu.zygxy.service;

import edu.zygxy.pojo.Department;

import java.util.List;

/**
 * Created by liangjiateng on 2017/5/2.
 */
public interface DepartmentService {

    Department getDepartmentById(long id);

    List<Department> listDepartments();

    void insertDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartmentById(long id);
}
