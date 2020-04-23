package edu.zygxy.service;

import edu.zygxy.pojo.Department;

import java.util.List;

/**
 * Created by guofumei on 2019/11/2.
 */
public interface DepartmentService {

    Department getDepartmentById(long id);

    List<Department> listDepartments();

    void insertDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartmentById(long id);
}
