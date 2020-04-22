package edu.zygxy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liangjiateng on 2017/5/3.
 */
@Controller
public class IndexController {


    @RequestMapping("/index")
    public String index(){

        return "index";
    }
}
