package com.sl.servlet;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.sl.bean.UploadParams;
import com.sl.bean.User;
import com.sl.service.UserService;
import com.sl.util.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

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
        User user = service.list().get(0);
        request.setAttribute("user", user);
        forward(request, response, "admin/user.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UploadParams params = Uploads.parseRequest(request);

        // 请求参数转成User
        User user = new User();
        BeanUtils.populate(user, params.getParams());

        // 从Session中拿到邮箱、密码
        User loginUser = (User) request.getSession().getAttribute("user");
        user.setEmail(loginUser.getEmail());
        user.setPassword(loginUser.getPassword());

        // 处理用户的头像
        FileItem item = params.getFileParam("photoFile");
        user.setPhoto(Uploads.uploadImage(item, request, user.getPhoto()));

        if (service.save(user)) { // 保存成功
            // 更新session中的用户
            request.getSession().setAttribute("user", user);
            redirect(request, response, "user/admin");
        } else { // 保存失败
            forwardError(request, response, "个人信息保存失败");
        }
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
            // 登录成功后，将User对象放入Session中
            request.getSession().setAttribute("user", user);
            redirect(request, response, "user/admin");
        } else { // 用户名、密码有问题
            forwardError(request, response, "邮箱或密码不正确");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 清除登录信息（将session中的用户删除）
        request.getSession().removeAttribute("user");

        // 重定向到登录页面
        redirect(request, response, "page/login.jsp");
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

    public void password(HttpServletRequest request, HttpServletResponse response) throws Exception {
        forward(request, response, "admin/password.jsp");
    }

    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String oldPassword = request.getParameter("oldPassword");
        // 对比session中用户的密码
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPassword().equals(oldPassword)) {
            forwardError(request, response, "旧密码不正确");
            return;
        }

        // 保存新密码
        String newPassword = request.getParameter("newPassword");
        user.setPassword(newPassword);
        if (service.save(user)) { // 保存成功
            redirect(request, response, "page/login.jsp");
        } else {
            forwardError(request, response, "修改密码失败");
        }
    }


}
