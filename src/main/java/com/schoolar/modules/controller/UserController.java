package com.schoolar.modules.controller;


import com.schoolar.modules.model.User;
import com.schoolar.modules.service.DisciplineService;
import com.schoolar.modules.service.NotesService;
import com.schoolar.modules.service.RatingService;
import com.schoolar.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Qualifier(value = "notesService")
    private NotesService notesService;

    @Autowired
    @Qualifier(value = "ratingService")
    private RatingService ratingService;

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String profile(Model model, Principal principal) {
       // String username = principal.getName();
      //  model.addAttribute("user", userService.findByUsername(username));
   //     User user = userService.findByUsername(username);
     //   Integer id = user.getId();
      //  model.addAttribute("id", userService.findById(id));
        model.addAttribute("user", new User());
        //  model.addAttribute("listDiscipline", disciplineService.disciplineList());
        return "user-profile";
    }


}
