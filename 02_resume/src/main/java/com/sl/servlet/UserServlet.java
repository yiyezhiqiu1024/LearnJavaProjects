package com.sl.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.sl.bean.UploadParams;
import com.sl.bean.User;
import com.sl.service.AwardService;
import com.sl.service.SkillService;
import com.sl.service.UserService;
import com.sl.service.WebsiteService;
import com.sl.service.impl.AwardServiceImpl;
import com.sl.service.impl.SkillServiceImpl;
import com.sl.service.impl.WebsiteServiceImpl;
import com.sl.util.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet<User> {
    private SkillService skillService = new SkillServiceImpl();
    private AwardService awardService = new AwardServiceImpl();
    private WebsiteService websiteService = new WebsiteServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String[] cmps = uri.split("/");
        String methodName = "/" + cmps[cmps.length - 1];
        if (methodName.equals(request.getContextPath())) {
            try {
                front(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            super.doPost(request, response);
        }
    }

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
        // 设置编码
        response.setContentType("text/json; charset=UTF-8");
        Map<String, Object> result = new HashMap();

        // 检查验证码
        String captcha = request.getParameter("captcha").toLowerCase();

        HttpSession session = request.getSession();
        // 从Session中取出验证码
        String code = (String) session.getAttribute("code");

        if (!captcha.equals(code)) {
            // forwardError(request, response, "验证码不正确");
            result.put("success", false);
            result.put("msg", "验证码不正确");
        } else {
            // 检查用户名、密码
            User user = new User();
            BeanUtils.populate(user, request.getParameterMap());
            user = ((UserService) service).get(user);
            if (user != null) { // 用户名、密码正确
                // 登录成功后，将User对象放入Session中
                session.setAttribute("user", user);
                // redirect(request, response, "user/admin");
                result.put("success", true);
            } else { // 用户名、密码有问题
                // forwardError(request, response, "邮箱或密码不正确");
                result.put("success", false);
                result.put("msg", "邮箱或密码不正确");
            }
        }

        // 延长 JSESSION 在客户端的寿命
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(3600 * 24 * 7); // 7天免登录
        response.addCookie(cookie);

        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
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

    public void front(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 用户信息
        User user = service.list().get(0);
        request.setAttribute("user", user);

        // 个人特质
        request.setAttribute("traits", user.getTrait().split(","));

        // 兴趣爱好
        request.setAttribute("interests", user.getInterests().split(","));

        // 专业技能
        request.setAttribute("skills", skillService.list());
        // 获奖成就
        request.setAttribute("awards", awardService.list());
        // 网站的底部信息
        request.setAttribute("footer", websiteService.list().get(0).getFooter());

        forward(request, response, "front/user.jsp");
    }
}
