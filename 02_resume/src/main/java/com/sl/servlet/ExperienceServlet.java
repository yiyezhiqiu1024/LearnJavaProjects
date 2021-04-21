package com.sl.servlet;

import com.sl.bean.Experience;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: 路径需改为小写字母开头
@WebServlet("/Experience/*")
public class ExperienceServlet extends BaseServlet<Experience> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    }
}
