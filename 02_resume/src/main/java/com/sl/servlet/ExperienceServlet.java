package com.sl.servlet;

import com.sl.bean.Company;
import com.sl.bean.Experience;
import com.sl.bean.User;
import com.sl.service.CompanyService;
import com.sl.service.UserService;
import com.sl.service.WebsiteService;
import com.sl.service.impl.CompanyServiceImpl;
import com.sl.service.impl.UserServiceImpl;
import com.sl.service.impl.WebsiteServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/experience/*")
public class ExperienceServlet extends BaseServlet<Experience> {
    private CompanyService companyService = new CompanyServiceImpl();
    private UserService userService = new UserServiceImpl();
    private WebsiteService websiteService = new WebsiteServiceImpl();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Experience> experiences = service.list();
        request.setAttribute("experiences", experiences);
        request.setAttribute("companies", companyService.list());
        forward(request, response, "admin/experience.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Experience experience = new Experience();
        BeanUtils.populate(experience, request.getParameterMap());

        // 对公司信息做特殊处理
        Company company = new Company();
        company.setId(Integer.valueOf(request.getParameter("companyId")));
        experience.setCompany(company);

        if (service.save(experience)) {
            redirect(request, response, "experience/admin");
        } else {
            forwardError(request, response, "工作经验保存失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] idStrs = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String idStr : idStrs) {
            ids.add(Integer.valueOf(idStr));
        }
        if (service.remove(ids)) {
            redirect(request, response, "experience/admin");
        } else {
            forwardError(request, response, "工作经验删除失败");
        }
    }

    public void front(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 用户信息
        request.setAttribute("user", userService.list().get(0));
        // 工作经验
        request.setAttribute("experiences", service.list());
        // 网站的底部信息
        request.setAttribute("footer", websiteService.list().get(0).getFooter());

        forward(request, response, "front/experience.jsp");
    }
}
