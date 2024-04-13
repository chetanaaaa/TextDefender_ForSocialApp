package com.example.techtalenttwitter.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.techtalenttwitter.twitter.model.User;
import com.example.techtalenttwitter.twitter.repository.AdminRepository;
import com.example.techtalenttwitter.twitter.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	 @Autowired
	 private AdminRepository adminRepository;

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // Assuming "admin.html" is your admin page template
    }
    
    @GetMapping("/admin/manage")
    public String manageAdmin(Model model) {
        // Assuming userService is a service class that provides user-related operations
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin_manage"; // Assuming your HTML template name is admin_manage.html
    }
    
    @GetMapping("/login1")
    public String adminLogin() {
        return "login1"; // Assuming your admin login page is named "login1.html"
    }
}

