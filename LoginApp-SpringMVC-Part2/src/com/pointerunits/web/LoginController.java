package com.pointerunits.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.pointerunits.service.*;

@Controller
@RequestMapping("/Login.spring")
public class LoginController {
	@Autowired //Here the authenticate service is automatically injected into this controller
	private AuthticateService authenticateService;
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processCredentials(@RequestParam("userName")String userName,@RequestParam("password")String password) {
		String message = "Invalid credentials";
		if(authenticateService.verifyUserNameAndPassword(userName, password)) {
			message = "Welcome " + userName + "!!";
		}
		return new ModelAndView("results","message",message);
	}
}
