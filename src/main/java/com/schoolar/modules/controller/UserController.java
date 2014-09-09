package com.schoolar.modules.controller;

import com.schoolar.modules.model.UserData;
import com.schoolar.modules.service.UserDataService;
import com.schoolar.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userDataService")
    private UserDataService userDataService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/schoolbook")
    public String users(Model model) {
        model.addAttribute("users", userDataService.getList());
        return "users";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(){

        return "my";
    }
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelAndView saveUserData(@ModelAttribute("userData")UserData userData,
                                    BindingResult result) {

        userDataService.updateUserData(userData);
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addUserData(@ModelAttribute("userData") UserData userData,
                                   BindingResult result) {

        return new ModelAndView("myaccount");
    }


}
