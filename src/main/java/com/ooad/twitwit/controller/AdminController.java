package com.ooad.twitwit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ooad.twitwit.model.User;
import com.ooad.twitwit.service.TweetService;
import com.ooad.twitwit.service.UserService;


@Controller
public class AdminController {
    
    @Autowired
	private UserService userService;

	@Autowired
	private TweetService tweetService;

    @GetMapping("/admin/login")
    public String adminlogin() {
        return "admin_login";
    }
    @GetMapping("/")
    public String landing() {
        return "index";
    }
    
    @GetMapping("/admin/home")
    public String adminhome() {
        return "admin";
    }
    @GetMapping("/admin/manage")
    public String adminmanage(Model model) {
    	List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin_manage";
    }
    @GetMapping("/admin/filter")
    public String adminFILTER() {
        return "filter";
    }
    
    @DeleteMapping("/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/manage"; // Redirect to the admin user management page after deletion
    }
    
    
}
