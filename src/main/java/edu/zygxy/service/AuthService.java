package edu.zygxy.service;

import edu.zygxy.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liangjiateng on 2017/5/3.
 */
public interface AuthService {

    boolean login(String username, String password, HttpServletResponse response) throws Exception;

    void logout(HttpServletRequest request,HttpServletResponse response);

    User checkAuth(HttpServletRequest request) throws Exception;
}
