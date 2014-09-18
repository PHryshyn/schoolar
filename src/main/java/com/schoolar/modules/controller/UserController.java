package com.schoolar.modules.controller;


import com.schoolar.modules.model.Homework;
import com.schoolar.modules.model.User;
import com.schoolar.modules.service.DisciplineService;
import com.schoolar.modules.service.HomeworkService;
import com.schoolar.modules.service.RatingService;
import com.schoolar.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String updateProfile(@PathVariable("id") Integer id, User user, Model model) {
        model.addAttribute("user", userService.findById(id));
        userService.updateUser(user);
        return "redirect:/user/profile";
    }

    //homework
    //homework
    @RequestMapping(value = "/homeworks", method = RequestMethod.GET)
    public String Homework(Model model) {
        model.addAttribute("homework", new Homework());
       // model.addAttribute("disciplineList", disciplineService.disciplineList());
        return "homework";
    }

  /*  @RequestMapping(value = "/profile/update/**", method = RequestMethod.POST)
    public ModelAndView updateProfile(@ModelAttribute("user") User user,
                                 BindingResult result) {

        userService.updateUser(user);

        return new ModelAndView("redirect:/user/profile");
    }

 /*   @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public String addDiscipline(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userProfile", userService.getUserListByLastName());
        return "user-profile";
    }

    @RequestMapping(value = "/profile/update**", method = RequestMethod.POST)
    public ModelAndView saveDiscipline(@ModelAttribute("user") User user,
                                       BindingResult result) {
        userService.updateUser(user);

        return new ModelAndView("redirect:/user/profiles");
    }*/
   // @RequestMapping(value = "/profile/", method = RequestMethod.GET)
    //public String profile(Model model, Principal principal) {
       // String username = principal.getName();
      //  model.addAttribute("user", userService.findByUsername(username));
   //     User user = userService.findByUsername(username);
     //   Integer id = user.getId();
      //  model.addAttribute("id", userService.findById(id));
   //     model.addAttribute("user", new User());
        //  model.addAttribute("listDiscipline", disciplineService.disciplineList());
    //    return "user-profile";
   // }


}
