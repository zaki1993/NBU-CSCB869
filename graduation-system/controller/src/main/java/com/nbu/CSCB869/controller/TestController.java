package com.nbu.CSCB869.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("title", "zdr");
        model.addAttribute("description", "<strong>kpr</strong>");
        return "test";
    }
/*
    @RequestMapping(value = "/js", method = RequestMethod.GET)
    public String getExampleJS(Model model) {
        return "studentCheck.js";
    }

    @RequestMapping(value = "/plain", method = RequestMethod.GET)
    public String getExamplePlain(Model model) {
        return "studentsList.txt";
    }*/
}