package com.schoolar.modules.controller;


import com.schoolar.modules.service.DisciplineService;
import com.schoolar.modules.service.NotesService;
import com.schoolar.modules.service.RatingService;
import com.schoolar.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/profiles")
    public String account(Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));
        return "user-profile";
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
