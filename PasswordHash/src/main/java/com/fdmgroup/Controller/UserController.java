package com.fdmgroup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.User.UserObj;


@Controller 
public class UserController {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("context.xml");
	
	@RequestMapping (value ="/createNewUser" )
	public String createNewUser(Model model) {
		
		model.addAttribute("createNewUser", "helloworld");
		return "CreateUser";
		
	};
	
//	@RequestMapping (value ="/main")
//	public String homePage() {
//		return "home";
//	}
//	
	
}
