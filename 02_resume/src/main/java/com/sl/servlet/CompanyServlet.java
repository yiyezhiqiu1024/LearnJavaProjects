package com.sl.servlet;

import com.sl.bean.Award;
import com.sl.bean.Company;
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

@WebServlet("/company/*")
public class CompanyServlet extends BaseServlet<Company> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Company> companies = service.list();
        request.setAttribute("companies", companies);
        forward(request, response, "admin/company.jsp");
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

        Company company = new Company();
        BeanUtils.populate(company, params);

        FileItem item = fileParams.get("logoFile");
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
