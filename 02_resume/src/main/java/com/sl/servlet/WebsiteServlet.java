package com.sl.servlet;

import com.sl.bean.Website;
import com.sl.dao.WebsiteDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet {
    private final WebsiteDao dao = new WebsiteDao();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Website> websites = dao.list();
        Website website = (websites != null && !websites.isEmpty()) ? websites.get(0) : null;
        request.setAttribute("website", website);
        request.getRequestDispatcher("/page/admin/website.jsp").forward(request, response);
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Website website = new Website();
        BeanUtils.populate(website, request.getParameterMap());
        if (dao.save(website)) {
            response.sendRedirect( request.getContextPath()+ "/website/admin");
        } else {
            forwardError(request, response, "保存网站信息失败");
        }
    }


}
