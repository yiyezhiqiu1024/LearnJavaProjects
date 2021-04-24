package com.sl.servlet;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.sl.bean.User;
import com.sl.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Properties;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet<User> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 检查验证码
        String captcha = request.getParameter("captcha").toLowerCase();

        // 从Session中取出验证码
        String code = (String) request.getSession().getAttribute("code");
        if (!captcha.equals(code)) {
            forwardError(request, response, "验证码不正确");
            return;
        }

        // 检查用户名、密码
        User user = new User();
        BeanUtils.populate(user, request.getParameterMap());
        user = ((UserService) service).get(user);
        if (user != null) { // 用户名、密码正确
            redirect(request, response, "user/admin");
        } else { // 用户名、密码有问题
            forwardError(request, response, "邮箱或密码不正确");
        }
    }

    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 创建Katpcha对象
        DefaultKaptcha dk = new DefaultKaptcha();

        // 验证码的配置
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("kaptcha.properties")) {
            Properties properties = new Properties();
            properties.load(is);

            Config config = new Config(properties);
            dk.setConfig(config);
        }

        // 生成验证码字符串
        String code = dk.createText();

        // 存储到Session中（当这个客户端是首次请求服务器时，就会创建一个全新的Session）
        HttpSession session = request.getSession();
        session.setAttribute("code", code.toLowerCase());

        // 生成验证码图片
        BufferedImage image = dk.createImage(code);

        // 设置返回数据的格式
        response.setContentType("image/jpeg");

        // 将图片数据写会到客户端
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
