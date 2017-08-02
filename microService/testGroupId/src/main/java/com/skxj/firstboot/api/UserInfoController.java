package com.skxj.firstboot.api;

import com.skxj.firstboot.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Snow on 7/10/2017.
 */

@RestController
public class UserInfoController {
    private static Logger logger = Logger.getLogger(UserInfoController.class);
     @Autowired
     private UserService userService;

    @RequestMapping("/")
    public ModelAndView mainpage(Model model){
        ModelAndView mv = new ModelAndView("index");
        model.addAttribute("name","苹果");
        model.addAttribute("price","88.5");
        return mv;
    }

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        logger.info("HomeController.login()");

        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        logger.info("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                logger.info("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                logger.info("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                logger.info("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(Model model) throws Exception{
        logger.info("HomeController.logout()");
        Subject currentUser = SecurityUtils.getSubject();
        String userName = (String) currentUser.getPrincipal();
        currentUser.logout();
        model.addAttribute("name",userName);
        ModelAndView mv = new ModelAndView("logout");
        return mv;
    }

    @RequestMapping("/main")
    public ModelAndView main(){
        ModelAndView mv = new ModelAndView("main");
        return mv;
    }

    @RequestMapping("/index/{name}")
    public String hellName(@PathVariable String name){
        logger.info("输出前台传递的参数！");
        return "hello:"+name;
    }

    @RequestMapping("/param")
    public String param(HttpServletRequest request){
        String username=request.getParameter("username");
        logger.info("输出前台传递的参数！HttpServletRequest : ");
        return "HttpServletRequest:"+username;
    }

    @RequestMapping(value = "/show")
    //如果请求地址是/show，返回的函数如下
    public String show(){

        return userService.show();
    }

    @RequestMapping(value = "/add")
    public String add(){
        userService.add();
        return "新增人员成功";
    }

    @RequestMapping("/403")
    public ModelAndView unauthorizedRole(Model model) throws Exception{
        logger.info("HomeController.unauthorizedRole()");
        ModelAndView mv = new ModelAndView("403");
        return mv;
    }

}
