package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
public class UserController {

    UserService userService;
    @GetMapping(value = "/users")
    public String printCars(ModelMap model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
