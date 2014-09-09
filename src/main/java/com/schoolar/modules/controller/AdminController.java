package com.schoolar.modules.controller;

import com.schoolar.modules.model.User;
import com.schoolar.modules.service.*;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired(required=false)
    @Qualifier("userDataService")
    private UserDataService userDataService;

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @Autowired
    @Qualifier(value = "disciplineService")
    private DisciplineService disciplineService;

    @Autowired
    @Qualifier(value = "notesService")
    private NotesService notesService;

    @Autowired
    @Qualifier(value = "ratingService")
    private RatingService ratingService;



  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView createUser(@ModelAttribute("user") User user,
                                 BindingResult result) {

      return new ModelAndView("user-register");
  }


  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public ModelAndView saveUser( Model model, User user, BindingResult result) {
      /*User existing = userService.findByUsername(user.getUsername());
      if (existing != null) {
          model.addAttribute("status", "exist");
          return "myaccount";
      }
      userService.saveUser(user);
      model.addAttribute("saved", "success");
      return "myaccount";*/

      userService.save(user);
      return new ModelAndView("redirect:/user-register");
  }
}
