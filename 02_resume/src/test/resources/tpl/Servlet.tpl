package com.sl.servlet;

import com.sl.bean.#0#;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/#1#/*")
public class #0#Servlet extends BaseServlet<#0#> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<#0#> #1#s = service.list();
        request.setAttribute("#1#s", #1#s);
        forward(request, response, "admin/#1#.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        #0# #1# = new #0#();
        BeanUtils.populate(#1#, request.getParameterMap());
        if (service.save(#1#)) {
            redirect(request, response, "#1#/admin");
        } else {
            forwardError(request, response, "保存失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] idStrs = request.getParameterValues("id");
            List<Integer> ids = new ArrayList<>();
            for (String idStr : idStrs) {
                ids.add(Integer.valueOf(idStr));
            }
            if (service.remove(ids)) {
                redirect(request, response, "#1#/admin");
            } else {
                forwardError(request, response, "删除失败");
            }
    }
}
