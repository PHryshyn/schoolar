package com.schoolar.modules.controller;

import com.schoolar.modules.model.Discipline;
import com.schoolar.modules.model.Homework;
import com.schoolar.modules.model.Rating;
import com.schoolar.modules.model.User;
import com.schoolar.modules.service.DisciplineService;
import com.schoolar.modules.service.HomeworkService;
import com.schoolar.modules.service.RatingService;
import com.schoolar.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {


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


    //user
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userListByLastName", userService.getUserListByLastName());
        return "user-new";
    }

    @RequestMapping(value = "/user/save**", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") User user,
                                       BindingResult result) {
          if (null == user.getId()) {
        userService.saveUser(user);
          } else {
        userService.updateUser(user);
          }
        return new ModelAndView("redirect:/admin/users");
    }

    @RequestMapping(value = "/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){

        userService.delete(id);
        return "redirect:/admin/users";
    }

    @RequestMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("userListByLastName", userService.getUserListByLastName());
        return "user-new";
    }

    //discipline
    @RequestMapping(value = "/disciplines", method = RequestMethod.GET)
    public String addDiscipline(Model model) {
        model.addAttribute("discipline", new Discipline());
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        return "discipline";
    }

    @RequestMapping(value = "/discipline/save**", method = RequestMethod.POST)
    public ModelAndView saveDiscipline(@ModelAttribute("discipline") Discipline discipline,
                                       BindingResult result) {
        if (null == discipline.getDisciplineId()) {
            disciplineService.save(discipline);
        } else {
           disciplineService.updateDiscipline(discipline);
        }
        return new ModelAndView("redirect:/admin/disciplines");
    }

    @RequestMapping(value = "/discipline/delete/{disciplineId}")
    public String deleteDiscipline(@PathVariable("disciplineId") Integer disciplineId){

        disciplineService.delete(disciplineId);
        return "redirect:/admin/disciplines";
    }

    @RequestMapping("/discipline/edit/{disciplineId}")
    public String editDiscipline(@PathVariable("disciplineId") Integer disciplineId, Model model) {
        model.addAttribute("discipline", disciplineService.findById(disciplineId));
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        return "discipline";
    }

    //homework
    @RequestMapping(value = "/homeworks", method = RequestMethod.GET)
    public String addHomework(Model model) {
        model.addAttribute("homework", new Homework());
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        model.addAttribute("homeworkList", homeworkService.getHomeworkListByDate());
        return "homework";
    }

    @RequestMapping(value = "/homework/save**", method = RequestMethod.POST)
    public ModelAndView saveHomework(@ModelAttribute("homework") Homework homework,
                                       BindingResult result) {
        if (null == homework.getHomeworkId()) {
            homeworkService.saveHomework(homework);
        } else {
            homeworkService.updateHomework(homework);
        }
        return new ModelAndView("redirect:/admin/homeworks");
    }

    @RequestMapping(value = "/homework/delete/{homeworkId}")
    public String deleteHomework(@PathVariable("homeworkId") Integer homeworkId){

        homeworkService.delete(homeworkId);
        return "redirect:/admin/homeworks";
    }

    @RequestMapping("/homework/edit/{homeworkId}")
    public String editHomework(@PathVariable("homeworkId") Integer homeworkId, Model model) {
        model.addAttribute("homework", homeworkService.findById(homeworkId));
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        model.addAttribute("homeworkList", homeworkService.getHomeworkListByDate());
        return "homework";
    }

    //rating
    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public String addRating(Model model) {
        model.addAttribute("rating", new Rating());
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        model.addAttribute("userList", userService.getUserListByLastName());
        model.addAttribute("ratingList", ratingService.getRatingListByDate());
        return "rating";
    }

    @RequestMapping(value = "/rating/save**", method = RequestMethod.POST)
    public ModelAndView saveRating(@ModelAttribute("rating")Rating rating,
                                     BindingResult result) {
        if (null == rating.getRatingId()) {
            ratingService.saveRating(rating);
        } else {
            ratingService.updateRating(rating);
        }
        return new ModelAndView("redirect:/admin/rating");
    }

    @RequestMapping(value = "/rating/delete/{ratingId}")
    public String deleteRating(@PathVariable("ratingId") Integer ratingId){

        ratingService.delete(ratingId);
        return "redirect:/admin/rating";
    }

    @RequestMapping("/rating/edit/{ratingId}")
    public String editRating(@PathVariable("ratingId") Integer ratingId, Model model) {
        model.addAttribute("rating", ratingService.findById(ratingId));
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        model.addAttribute("userList", userService.getUserListByLastName());
        model.addAttribute("ratingList", ratingService.getRatingListByDate());
        return "rating";
    }
}
