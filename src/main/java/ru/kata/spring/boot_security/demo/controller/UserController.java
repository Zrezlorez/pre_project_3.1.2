package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserService;




@Controller
public class UserController {
	private final UserService userService;
	private final PasswordEncoder encoder;

	public UserController(UserService userService, PasswordEncoder encoder) {
		this.userService = userService;
		this.encoder = encoder;
	}

	@GetMapping(value = "/user")
	public String getUser(Authentication auth, ModelMap model) {
		var user = userService.getUserByAuth(auth);
		System.out.println(user);
		model.addAttribute("user", user);
		model.addAttribute("encoder", encoder);
		return "user";
	}
}