package com.hryshyn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    //Mapping home.jsp
    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView defaultPage() {

        return ViewPage("Schoolar v.1.0", "Welcome", "home");

    }

    //Mapping admin.jsp
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        return ViewPage("Schoolar v.1.0 (admin)", "Welcome", "admin");

    }

    //Mapping login.jsp
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }
    //Method ViewPage for admin.jsp and home.jsp
    public ModelAndView ViewPage(String title, String message, String page) {

        ModelAndView model = new ModelAndView();
        model.addObject("title", title);
        model.addObject("message", message);
        model.setViewName(page);
        return model;

    }


}