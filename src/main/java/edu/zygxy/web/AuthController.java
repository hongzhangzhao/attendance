package edu.zygxy.web;

import edu.zygxy.pojo.JsonResponse;
import edu.zygxy.pojo.User;
import edu.zygxy.service.AuthService;
import edu.zygxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by guofumei on 2019/11/3.
 */
@Controller
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JsonResponse login(@RequestBody User user, HttpServletResponse httpServletResponse, HttpSession session) throws Exception {
        if (authService.login(user.getEmail(), user.getPassword(), httpServletResponse)) {
            User u = userService.getUserByEmail(user.getEmail());
            session.setAttribute("username", user.getEmail());
            session.setAttribute("roleId", u.getRoleId());
            return new JsonResponse(null);
        } else {
            return new JsonResponse(400, "登录失败，请检查用户名密码");
        }

    }

    @RequestMapping(value = "/api/logout", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JsonResponse logout(HttpServletRequest request, HttpServletResponse response) {
        authService.logout(request, response);
        return new JsonResponse(null);
    }

    @RequestMapping(value = "/system")
    public String system() {
        return "system";
    }

}
