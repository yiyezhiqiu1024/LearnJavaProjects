package com.sl.servlet;

import com.sl.bean.Award;
import com.sl.service.AwardService;
import com.sl.service.impl.AwardServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/award/*")
public class AwardServlet extends BaseServlet {
    private AwardService service = new AwardServiceImpl();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Award> awards = service.list();
        request.setAttribute("awards", awards);
        request.getRequestDispatcher("/WEB-INF/page/admin/award.jsp").forward(request, response);
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Award award = new Award();
        BeanUtils.populate(award, request.getParameterMap());
        if (service.save(award)) {
            response.sendRedirect( request.getContextPath()+ "/award/admin");
        } else {
            forwardError(request, response, "保存获奖成就失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] idStrs = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String idStr : idStrs) {
            ids.add(Integer.valueOf(idStr));
        }
        if (service.remove(ids)) {
            response.sendRedirect( request.getContextPath()+ "/award/admin");
        } else {
            forwardError(request, response, "删除获奖成就失败");
        }
    }


}
