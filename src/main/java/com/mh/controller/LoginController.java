package com.mh.controller;

import com.mh.util.JsonMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 对用户名和密码进行判断
     * @param request
     * @return
     */
    @RequestMapping("/dologin")
    @ResponseBody
    public JsonMsg doLogin(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+"  "+password);
        if(username.equals("admin")&&password.equals("1234")){
            return JsonMsg.success();
        }else return JsonMsg.fail().addInfo("login_error", "账号密码不匹配，请重新输入!");
    }

    /**
     * 跳转到主界面
     * @return
     */
    @RequestMapping("/main")
    public String goMain(){
        return "main";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        return "login";
    }
}
