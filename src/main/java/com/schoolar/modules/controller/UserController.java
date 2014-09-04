package com.schoolar.modules.controller;

import com.schoolar.modules.model.User;
import com.schoolar.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/admin/save", method = RequestMethod.GET)
    public ModelAndView saveUser(@ModelAttribute("user") User user,
                                  BindingResult result) {
        userService.addUser(user);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView listUser() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("users", userService.getUsers());

        return new ModelAndView("admin", model);


    }

}
