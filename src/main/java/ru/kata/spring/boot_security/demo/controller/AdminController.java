package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String getAdminPage(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "admin";
    }
    @GetMapping(value = "/admin/edit")
    public String getEditPage(@RequestParam long id, ModelMap model) {
        model.addAttribute("currentUser", userService.getById(id));
        return "edit";
    }

    @PostMapping(value = "/admin/delete")
    public String delete(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/add")
    public String add(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }
}
