package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController {

    UserService userService;

    @GetMapping(value = "/")
    public String setPage() {
        return "redirect:/users";
    }
    @GetMapping(value = "/users")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @RequestMapping(value = "/delete/{id}")
    private String deleteUser(@PathVariable(name = "id") String id){
        userService.delete(userService.getById(Integer.parseInt(id)));
        return "redirect:/users";
    }

    @RequestMapping(value = "/edit/{id}")
    private ModelAndView editUser(@PathVariable(name = "id") int id) {
        System.out.println("User : "+id);
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUserPage(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.edit(user);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-user");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user);
        modelAndView.setViewName("redirect:/users");
        userService.add(user);
        return modelAndView;
    }
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
