package com.nimsoc.springweb.controllers;

import com.nimsoc.springweb.services.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {

    @Autowired
    private RandomNumberService randomNumberService; //uses a proxy

    @GetMapping("/home")
    public String indexAction(Model model) {
        //model.addAttribute("message", "Hello from the controller!");
        model.addAttribute("message", randomNumberService.getValue());

        return "index.html";
    }
}
