package com.sl.servlet;

import com.sl.bean.Company;
import com.sl.bean.Project;
import com.sl.bean.UploadParams;
import com.sl.service.CompanyService;
import com.sl.service.UserService;
import com.sl.service.WebsiteService;
import com.sl.service.impl.CompanyServiceImpl;
import com.sl.service.impl.UserServiceImpl;
import com.sl.service.impl.WebsiteServiceImpl;
import com.sl.util.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/project/*")
public class ProjectServlet extends BaseServlet<Project> {
    private CompanyService companyService = new CompanyServiceImpl();
    private UserService userService = new UserServiceImpl();
    private WebsiteService websiteService = new WebsiteServiceImpl();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Project> projects = service.list();
        request.setAttribute("projects", projects);
        request.setAttribute("companies", companyService.list());
        forward(request, response, "admin/project.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UploadParams uploadParams = Uploads.parseRequest(request);

        Project project = new Project();
        BeanUtils.populate(project, uploadParams.getParams());

        // 对公司信息作特殊处理
        Company company = new Company();
        company.setId(Integer.valueOf(uploadParams.getParam("companyId").toString()));
        project.setCompany(company);

        FileItem item = uploadParams.getFileParam("imageFile");
        String image = Uploads.uploadImage(item, request, project.getImage());
        project.setImage(image);

        if (service.save(project)) {
            redirect(request, response, "project/admin");
        } else {
            forwardError(request, response, "项目经验保存失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] idStrs = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String idStr : idStrs) {
            ids.add(Integer.valueOf(idStr));
        }
        if (service.remove(ids)) {
            redirect(request, response, "project/admin");
        } else {
            forwardError(request, response, "项目经验删除失败");
        }
    }

    public void front(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("user", userService.list().get(0));
        request.setAttribute("projects", service.list());
        request.setAttribute("footer", websiteService.list().get(0).getFooter());
        forward(request, response, "front/project.jsp");
    }
}
