package com.sl.servlet;

import com.sl.bean.Contact;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/contact/*")
public class ContactServlet extends BaseServlet<Contact> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Contact> contacts = service.list();
        request.setAttribute("contacts", contacts);
        forward(request, response, "admin/contact.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contact contact = new Contact();
        BeanUtils.populate(contact, request.getParameterMap());
        if (service.save(contact)) {
            redirect(request, response, "contact/admin");
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
                redirect(request, response, "contact/admin");
            } else {
                forwardError(request, response, "删除失败");
            }
    }
}
