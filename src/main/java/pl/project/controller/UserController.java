package pl.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.project.model.User;
import pl.project.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "registerForm";
	}

	@PostMapping("/register")
	public String addUser(@ModelAttribute @Valid User user,
			BindingResult bindResult) {
		if(bindResult.hasErrors())
			return "registerForm";
		else {
			userService.addWithDefaultRole(user);
			return "registerSuccess";
		}
	}		
	
	@GetMapping("/loginform")
	public String loginForm() {
	    return "login_form";
	}	
	
	@GetMapping("/logout")
	public String logout() {
	    return "logout";
	}
		
	
	@GetMapping("/processlogin")
	public String login(){
		return "loginSuccess";
	}
	
	@PostMapping("/processlogin")
	public String loginSuccess() {
		return "loginSuccess";
	}
	
	
	
	
	
}