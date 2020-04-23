package edu.zygxy.web;

import edu.zygxy.permission.*;
import edu.zygxy.pojo.*;
import edu.zygxy.pojo.Role;
import edu.zygxy.service.DepartmentService;
import edu.zygxy.service.RoleService;
import edu.zygxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guofumei on 2019/11/2.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/employee")
    public String employee(@RequestParam(defaultValue = "0") long departmentId, ModelMap modelMap) {
        List<User> users;
        if (departmentId != 0) {
            users = userService.listUsersByDepartmentId(departmentId);
        } else {
            users = userService.listUsers();
        }

        List<UserVO> userVOList = new ArrayList<UserVO>();
        for (User user : users) {
            UserVO userVO = new UserVO();
            userVO.setName(user.getName());
            userVO.setId(user.getId());
            Department department = departmentService.getDepartmentById(user.getDepartmentId());
            if (department != null)
                userVO.setDepartment(department.getName());
            userVO.setEmail(user.getEmail());
            userVO.setPhone(user.getPhone());
            Role role = roleService.getRoleById(user.getRoleId());
            if (role != null)
                userVO.setRole(role.getName());
            userVOList.add(userVO);
        }
        List<Department> departments = departmentService.listDepartments();
        modelMap.addAttribute("users", userVOList);
        modelMap.addAttribute("departments", departments);
        return "employee";
    }

    @RequestMapping("/employee/add")
    public String addEmployee(ModelMap modelMap) {
        List<Role> roles = roleService.listRoles();
        List<Department> departments = departmentService.listDepartments();

        modelMap.addAttribute("roles", roles);
        modelMap.addAttribute("departments", departments);
        return "employee_add";
    }

    @RequestMapping("/employee/update")
    public String updateEmployee(@RequestParam long userId, ModelMap modelMap) {
        List<Role> roles = roleService.listRoles();
        List<Department> departments = departmentService.listDepartments();
        User user = userService.getUserById(userId);
        modelMap.addAttribute("roles", roles);
        modelMap.addAttribute("departments", departments);
        modelMap.addAttribute("user", user);
        return "employee_update";
    }
    @edu.zygxy.permission.Role({"1","2","3"})
    @RequestMapping(value = "/api/users", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JsonResponse insertUser(@RequestBody User user) throws Exception {
        userService.insertUser(user);
        return new JsonResponse(null);
    }
    @edu.zygxy.permission.Role({"1","2","3"})
    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public JsonResponse updateUser(@PathVariable long id, @RequestBody User user) throws Exception {
        String tResult = "";
    	if(id==1 || "root".equals(user.getName())) {
    		tResult = "超级管理员账号信息不可修改";
        }else {
        	user.setId(id);
        	userService.updateUser(user);
        	tResult = "更新员工信息成功!";
        }
        return new JsonResponse(tResult);
    }
    @edu.zygxy.permission.Role({"1","2","3"})
    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public JsonResponse deleteUser(@PathVariable long id) throws Exception {
    	String tResult = "";
    	if(id==1) {
    		tResult = "超级管理员账号信息不可删除";
    	}else {
    		userService.deleteUserById(id);
    		tResult = "删除成功!";
    	}
    	return new JsonResponse(tResult);
    	
    }
}
