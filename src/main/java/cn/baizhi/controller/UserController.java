package cn.baizhi.controller;

import cn.baizhi.entity.User;
import cn.baizhi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("userLogin")
    @ResponseBody
    public Map<String, Object> userLogin(HttpServletRequest request, HttpServletResponse response, User user, String username, String password, String code) {
        HttpSession session = request.getSession();
        List<User> users = userService.selectAll(new User(username, null, null, null));
        for (User use : users) {
            user = use;
        }
        Map<String, Object> map = new HashMap();
        String code1 = (String) session.getAttribute("code");

        log.info("code1: {}",code1);
        System.out.println(code1);
        log.info("code: {}",code);
        System.out.println(code);
        log.info("username: {}",username);
        System.out.println(username);
        log.info("password: {}",password);
        System.out.println(password);

        if (code1.equals(code)) {
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    session.setAttribute("user", user);
                    map.put("success", true);
                } else {
                    map.put("success", false);
                    map.put("msg", "密码错误！");
                }
            } else {
                map.put("success", false);
                map.put("msg", "用户名错误！");
            }
        } else {
            map.put("success", false);
            map.put("msg", "验证码错误！");
        }
        return map;
    }

    @RequestMapping("regiest")
    public String regiest(User user) {
        System.out.println(user);
        userService.insertUser(user);
        return "redirect:/login.jsp";
    }
}
