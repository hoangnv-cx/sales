package com.java.sales.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.sales.Utils.WebUtils;

@Controller

public class HomeController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
 
        return "login";
    }
	@RequestMapping(value = "/web", method = RequestMethod.GET)
    public String webPage() {
 
        return "web";
    }
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
		
		

        return "admin";
    }
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String webPagessss() {
 
        return "add";
    }
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }

//aaaaaa
}
