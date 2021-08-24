package cn.baizhi.controller;

import cn.baizhi.util.AuthImg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/commom")
public class CommonController {
    //生成验证码
    @GetMapping("authImg")
    public void authImg(HttpSession session, HttpServletResponse response) throws IOException {

        System.out.println("dsfsdfsdfsdfsdf");
        System.out.println("dsfsdfsdfsdfsdf");
        System.out.println("dsfsdfsdfsdfsdf");

        //生成验证码
        String securityCode = AuthImg.getSecurityCode();
        //将验证码放入session
        session.setAttribute("code",securityCode);
        //生成图片
        BufferedImage image = AuthImg.createImage(securityCode);
        //输出图片
        ServletOutputStream outputStream = response.getOutputStream();
        //调用工具类
        ImageIO.write(image,"png",outputStream);
    }

}
