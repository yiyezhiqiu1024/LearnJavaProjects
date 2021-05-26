package com.sl.controller;

import com.sl.pojo.query.DictItemQuery;
import com.sl.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictItems")
public class DictItemController {
    @Autowired
    private DictItemService service;

    @GetMapping("/list")
    public String list(DictItemQuery query, Model model) {
        service.list(query);
        model.addAttribute("data", query);
        return "pages/dictItem";
    }
}
