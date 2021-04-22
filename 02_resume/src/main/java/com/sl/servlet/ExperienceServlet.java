package com.sl.servlet;

import com.sl.bean.Company;
import com.sl.bean.Experience;
import com.sl.service.CompanyService;
import com.sl.service.impl.CompanyServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/experience/*")
public class ExperienceServlet extends BaseServlet<Experience> {
    private CompanyService companyService = new CompanyServiceImpl();

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
}
