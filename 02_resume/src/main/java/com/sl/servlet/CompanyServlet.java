package com.sl.servlet;

import com.sl.bean.Company;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: 路径需改为小写字母开头
@WebServlet("/Company/*")
public class CompanyServlet extends BaseServlet<Company> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    }
}
