package edu.zygxy.service;

import edu.zygxy.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by guofumei on 2019/11/3.
 */
public interface AuthService {

    boolean login(String username, String password, HttpServletResponse response) throws Exception;

    void logout(HttpServletRequest request,HttpServletResponse response);

    User checkAuth(HttpServletRequest request) throws Exception;
}
