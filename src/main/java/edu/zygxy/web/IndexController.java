package edu.zygxy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guofumei on 2019/11/3.
 */
@Controller
public class IndexController {


    @RequestMapping("/index")
    public String index(){

        return "index";
    }
}
