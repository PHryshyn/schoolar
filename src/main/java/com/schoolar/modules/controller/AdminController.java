package com.schoolar.modules.controller;

import com.schoolar.modules.model.User;
import com.schoolar.modules.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelAndView saveUser(@ModelAttribute("user") User user,
                                  BindingResult result) {
        userService.saveUser(user);
        return new ModelAndView("redirect:/admin/add");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listPupil() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user",  userService.getList());

        return new ModelAndView("listOfUser", model);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addUser(@ModelAttribute("user") User user,
                                 BindingResult result) {

        return new ModelAndView("user-register","user",new User());
    }

    @RequestMapping(value="/list")
    public ModelAndView listOfUsers() {
        ModelAndView modelAndView = new ModelAndView("list-of-teams");

        List<User> userList = userService.getList();
        modelAndView.addObject("user", userList);

        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-user-form");
        User user = userService.findById(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("admin");

        userService.updateUser(user);

        String message = "User was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin");
        userService.delete(id);
        String message = "User was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }


  /*@RequestMapping(value = "/register", method = RequestMethod.GET)
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
      return "myaccount";

      userService.save(user);
      return new ModelAndView("redirect:/user-register");
  }*/


}
