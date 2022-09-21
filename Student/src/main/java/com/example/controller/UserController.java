package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.UserDetails;
import com.example.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
   @GetMapping("/")
	public String home() {
		return "index";
	}
   
  
	
	@PostMapping("/usersubmit")
	public String submit(@ModelAttribute UserDetails user,HttpSession session)
	
	{
		System.out.println(user);
		repo.save(user);
		session.setAttribute("message", "done successfully");
		return   "redirect:/";
	}
	 
}
