package com.sl.servlet;

import com.sl.bean.Education;
import com.sl.dao.EducationDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/education/*")
public class EducationServlet extends BaseServlet {
    private final EducationDao dao = new EducationDao();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Education> educations = dao.list();
        request.setAttribute("educations", educations);
        request.getRequestDispatcher("/page/admin/education.jsp").forward(request, response);
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Education education = new Education();
        education.setName(request.getParameter("name"));
        education.setIntro(request.getParameter("intro"));
        education.setType(Integer.valueOf(request.getParameter("type")));
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        education.setBeginDay(fmt.parse(request.getParameter("beginDay")));
        education.setEndDay(fmt.parse(request.getParameter("endDay")));
        if (dao.save(education)) {
            response.sendRedirect( request.getContextPath()+ "/education/admin");
        } else {
            forwardError(request, response, "保存教育经验失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        if (dao.remove(id)) {
            response.sendRedirect( request.getContextPath()+ "/education/admin");
        } else {
            forwardError(request, response, "删除教育经验失败");
        }
    }


}
