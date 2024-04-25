package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController  {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
    @GetMapping("/add")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addusers";
    }
    @PostMapping("/add")
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
    @GetMapping("/update")
    public String updateUser(@RequestParam Long id, ModelMap model) {
        model.addAttribute("update", userService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String saveUpdateUser(@RequestParam Long id, @ModelAttribute("user") User user) {
        user.setId(id);
        userService.edit(user);
        return "redirect:/users";
    }

}