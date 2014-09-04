package com.schoolar.modules.controller;

import com.schoolar.modules.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;
}
