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

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        //  model.addAttribute("listDiscipline", disciplineService.disciplineList());
        return "user-profile";
    }


}
