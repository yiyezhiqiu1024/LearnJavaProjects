package com.sl.servlet;

import com.sl.bean.Skill;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/skill/*")
public class SkillServlet extends BaseServlet<Skill> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Skill> skills = service.list();
        request.setAttribute("skills", skills);
        forward(request, response, "admin/skill.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Skill skill = new Skill();
        BeanUtils.populate(skill, request.getParameterMap());
        if (service.save(skill)) {
           redirect(request, response,"skill/admin");
        } else {
            forwardError(request, response, "保存专业技能失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] idStrs = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String idStr : idStrs) {
            ids.add(Integer.valueOf(idStr));
        }
        if (service.remove(ids)) {
            redirect(request, response,"skill/admin");
        } else {
            forwardError(request, response, "删除专业技能失败");
        }
    }


}
