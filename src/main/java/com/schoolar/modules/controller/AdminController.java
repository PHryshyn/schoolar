package com.schoolar.modules.controller;

import com.schoolar.modules.model.*;
import com.schoolar.modules.service.*;
import org.apache.log4j.Logger;
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

import javax.validation.Valid;

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


    private static final Logger logger	= Logger.getLogger(AdminController.class);

    //create user
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUserForm(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("userListByLastName", userService.getUserListByLastName());
        logger.info("UserForm is loaded successfully");
        return "user-new";
    }

    @RequestMapping(value = "/user/save**", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") @Valid User user,
                                       BindingResult result) {

        if (result.hasErrors()){
            logger.warn("Input incorrect data");
            ModelAndView model = new ModelAndView();
            model.setViewName("user-new");
            return model;
        }
        else {
            if (null == user.getId()) {
                userService.saveUser(user);
                logger.info("User is saved successfully");
            } else {
                userService.updateUser(user);
                logger.info("User is updated successfully");
            }
            return new ModelAndView("redirect:/admin/users");
        }
    }

    @RequestMapping(value = "/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){

        userService.delete(id);
        logger.info("User is deleted. Id = " + id);
        return "redirect:/admin/users";
    }

    @RequestMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("user", userService.findById(id));
        model.addAttribute("userListByLastName", userService.getUserListByLastName());

        logger.info("User is edited. Id = " + id);
        return "user-new";
    }

    //discipline
    @RequestMapping(value = "/disciplines", method = RequestMethod.GET)
    public String addDiscipline(Model model) {

        model.addAttribute("discipline", new Discipline());
        model.addAttribute("disciplineList", disciplineService.disciplineList());

        logger.info("DisciplineForm is loaded successfully.");
        return "discipline";
    }

    @RequestMapping(value = "/discipline/save**", method = RequestMethod.POST)
    public ModelAndView saveDiscipline(@ModelAttribute("discipline") @Valid Discipline discipline,
                                       BindingResult result) {

        if (result.hasErrors()){
            logger.warn("Input incorrect data");
            ModelAndView model = new ModelAndView();
            model.setViewName("discipline");
            return model;
        }
        else {
            if (null == discipline.getDisciplineId()) {
                disciplineService.save(discipline);
                logger.info("Discipline is saved successfully.");
            } else {
                disciplineService.updateDiscipline(discipline);
                logger.info("Discipline is updated successfully.");
            }
            return new ModelAndView("redirect:/admin/disciplines");
        }
    }

    @RequestMapping(value = "/discipline/delete/{disciplineId}")
    public String deleteDiscipline(@PathVariable("disciplineId") Integer disciplineId){

        disciplineService.delete(disciplineId);
        logger.info("Discipline is deleted successfully. DisciplineId = " + disciplineId);
        return "redirect:/admin/disciplines";
    }

    @RequestMapping("/discipline/edit/{disciplineId}")
    public String editDiscipline(@PathVariable("disciplineId") Integer disciplineId, Model model) {
        model.addAttribute("discipline", disciplineService.findById(disciplineId));
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        logger.info("Discipline is edited successfully. DisciplineId = " + disciplineId);
        return "discipline";
    }

    //homework
    @RequestMapping(value = "/homeworks", method = RequestMethod.GET)
    public String addHomework(Model model) {
        model.addAttribute("homework", new Homework());
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        model.addAttribute("homeworkList", homeworkService.getHomeworkListByDate());
        logger.info("HomeworkForm is created successfully.");
        return "homework";
    }

    @RequestMapping(value = "/homework/save**", method = RequestMethod.POST)
    public ModelAndView saveHomework(@ModelAttribute("homework") @Valid Homework homework,
                                       BindingResult result) {

        if (result.hasErrors()){
            logger.warn("Input incorrect data");
            ModelAndView model = new ModelAndView();
            model.addObject("disciplineList", disciplineService.disciplineList());
            model.setViewName("homework");
            return model;
        }
        else {
            if (null == homework.getHomeworkId()) {
                homeworkService.saveHomework(homework);
                logger.info("Homework is saved successfully.");
            } else {
                homeworkService.updateHomework(homework);
                logger.info("Homework is updated successfully.");
            }
            return new ModelAndView("redirect:/admin/homeworks");
        }
    }

    @RequestMapping(value = "/homework/delete/{homeworkId}")
    public String deleteHomework(@PathVariable("homeworkId") Integer homeworkId){

        homeworkService.delete(homeworkId);
        logger.info("HomeworkForm is deleted successfully. HomeworkId = " + homeworkId);
        return "redirect:/admin/homeworks";
    }

    @RequestMapping("/homework/edit/{homeworkId}")
    public String editHomework(@PathVariable("homeworkId") Integer homeworkId, Model model) {
        model.addAttribute("homework", homeworkService.findById(homeworkId));
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        model.addAttribute("homeworkList", homeworkService.getHomeworkListByDate());
        logger.info("HomeworkForm is edited successfully. HomeworkId = " + homeworkId);
        return "homework";
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

    @RequestMapping(value = "/rating/save**", method = RequestMethod.POST)
    public ModelAndView saveRating(@ModelAttribute("rating") @Valid Rating rating,
                                     BindingResult result) {
        if (result.hasErrors()){
            logger.warn("Input incorrect data");
            ModelAndView model = new ModelAndView();
            model.addObject("disciplineList", disciplineService.disciplineList());
            model.setViewName("rating");
            return model;
        }
        else {
            if (null == rating.getRatingId()) {
                ratingService.saveRating(rating);
                logger.info("Rating is saved successfully.");
            } else {
                ratingService.updateRating(rating);
                logger.info("Rating is updated successfully.");
            }
            return new ModelAndView("redirect:/admin/rating");
        }
    }

    @RequestMapping(value = "/rating/delete/{ratingId}")
    public String deleteRating(@PathVariable("ratingId") Integer ratingId){

        ratingService.delete(ratingId);
        logger.info("Rating is deleted successfully. RatingId = " + ratingId);
        return "redirect:/admin/rating";
    }

    @RequestMapping("/rating/edit/{ratingId}")
    public String editRating(@PathVariable("ratingId") Integer ratingId, Model model) {
        model.addAttribute("rating", ratingService.findById(ratingId));
        model.addAttribute("disciplineList", disciplineService.disciplineList());
        model.addAttribute("userList", userService.getUserListByLastName());
        model.addAttribute("ratingList", ratingService.getRatingListByDate());
        logger.info("Rating is edited successfully. RatingId = " + ratingId);
        return "rating";
    }

}
