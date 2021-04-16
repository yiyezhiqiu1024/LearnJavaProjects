package com.sl.servlet;

import com.sl.bean.Education;
import com.sl.dao.EducationDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/education/*")
public class EducationServlet extends BaseServlet {
    private final EducationDao dao = new EducationDao();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Education> educations = dao.list();
        request.setAttribute("educations", educations);
        request.getRequestDispatcher("/WEB-INF/page/admin/education.jsp").forward(request, response);
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Education education = new Education();
        BeanUtils.populate(education, request.getParameterMap());
        if (dao.save(education)) {
            response.sendRedirect( request.getContextPath()+ "/education/admin");
        } else {
            forwardError(request, response, "保存教育经验失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] idStrs = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String idStr : idStrs) {
            ids.add(Integer.valueOf(idStr));
        }
        if (dao.remove(ids)) {
            response.sendRedirect( request.getContextPath()+ "/education/admin");
        } else {
            forwardError(request, response, "删除教育经验失败");
        }
    }


}
