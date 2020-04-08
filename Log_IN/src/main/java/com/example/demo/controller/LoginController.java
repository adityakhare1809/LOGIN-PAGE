package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.form.LoginForm;

@Controller
public class LoginController {

	//to get login form page
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginForm()
	{
		return "login";//return html page name
	}
	
	//checking for login credentials
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm")LoginForm loginForm,Model model) {
		
		String username=loginForm.getUsername();
		String password=loginForm.getPassword();
		
		if(username.equals("fresherpro") && password.contentEquals("fresherpro"))
		{
			return "home";
		}
		else
		{
			model.addAttribute("invalidCredentials",true);
			return "login";
		}
	}
}
