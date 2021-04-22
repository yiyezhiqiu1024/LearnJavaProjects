package com.sl.servlet;

import com.sl.bean.Company;
import com.sl.bean.Project;
import com.sl.service.CompanyService;
import com.sl.service.impl.CompanyServiceImpl;
import com.sl.util.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/project/*")
public class ProjectServlet extends BaseServlet<Project> {
    private CompanyService companyService = new CompanyServiceImpl();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Project> projects = service.list();
        request.setAttribute("projects", projects);
        request.setAttribute("companies", companyService.list());
        forward(request, response, "admin/project.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("UTF-8");
        // 一个 FileItem 就代表一个请求参数（文件参数、非文件参数）
        List<FileItem> items = upload.parseRequest(request);
        // 非文件参数
        Map<String, Object> params = new HashMap<>();
        // 文件参数
        Map<String, FileItem> fileParams = new HashMap<>();
        // 遍历请求参数
        for (FileItem item: items) {
            String fieldName = item.getFieldName();
            if (item.isFormField()) { // 非文件参数
                params.put(fieldName, item.getString("UTF-8"));
            } else { // 文件参数
                fileParams.put(fieldName, item);
            }
        }

        Project project = new Project();
        BeanUtils.populate(project, params);

        // 对公司信息作特殊处理
        Company company = new Company();
        company.setId(Integer.valueOf(params.get("companyId").toString()));
        project.setCompany(company);

        FileItem item = fileParams.get("imageFile");
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
}
