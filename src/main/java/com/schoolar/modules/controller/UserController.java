package com.schoolar.modules.controller;


import com.schoolar.modules.model.Rating;
import com.schoolar.modules.model.User;
import com.schoolar.modules.service.DisciplineService;
import com.schoolar.modules.service.HomeworkService;
import com.schoolar.modules.service.RatingService;
import com.schoolar.modules.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @Autowired
    @Qualifier(value = "disciplineService")
    private DisciplineService disciplineService;

    @Autowired
    @Qualifier(value = "homeworkService")
    private HomeworkService homeworkService;

    @Autowired
    @Qualifier(value = "ratingService")
    private RatingService ratingService;

    private static final Logger logger	= Logger.getLogger(UserController.class);


    @RequestMapping(value = "/profile")
    public String account(Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));
        return "user-profile";
    }

    @RequestMapping(value = "/profile/edit/{id}", method = RequestMethod.GET)
    public String editProfile(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit-user-profile";
    }

    @RequestMapping(value = "/profile/update/{id}", method = RequestMethod.POST)
    public String updateProfile(@PathVariable("id") Integer id, @Valid User user, Model model, BindingResult result) {
        if (result.hasErrors()){
            logger.warn("Input incorrect data");
            return "user-profile";

        }
        else {
            model.addAttribute("user", userService.findById(id));
            userService.updateUser(user);
            return "redirect:/user/profile";
        }
    }


    //rating
    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public String addRating(Model model) {
        model.addAttribute("rating", new Rating());
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        model.addAttribute("userList", userService.getUserListByLastName());
        model.addAttribute("ratingList", ratingService.getRatingListByDate());
        logger.info("RatingForm is created successfully.");
        return "rating";
    }



}
