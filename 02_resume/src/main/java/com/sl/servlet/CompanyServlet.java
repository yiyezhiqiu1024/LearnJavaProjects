package com.sl.servlet;

import com.sl.bean.Company;
import com.sl.bean.UploadParams;
import com.sl.util.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/company/*")
public class CompanyServlet extends BaseServlet<Company> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Company> companies = service.list();
        request.setAttribute("companies", companies);
        forward(request, response, "admin/company.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UploadParams uploadParams = Uploads.parseRequest(request);

        Company company = new Company();
        BeanUtils.populate(company, uploadParams.getParams());

        FileItem item = uploadParams.getFileParam("logoFile");
        String logo = Uploads.uploadImage(item, request, company.getLogo());
        company.setLogo(logo);

        if (service.save(company)) {
            redirect(request, response, "company/admin");
        } else {
            forwardError(request, response, "保存公司信息失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] idStrs = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String idStr : idStrs) {
            ids.add(Integer.valueOf(idStr));
        }
        if (service.remove(ids)) {
            redirect(request, response, "company/admin");
        } else {
            forwardError(request, response, "删除公司信息失败");
        }
    }
}
