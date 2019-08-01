package com.springboot.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PersonController {
	
	@Autowired
	private PersonDao persondao;
	@RequestMapping
	public String get()
	{
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Person person)
	{
		System.out.println(person);
		Person p = new Person("virat","virat");
		persondao.save(p);
		Person per = persondao.findUser(person.getUsername(), person.getPassword());
		
		//if((person.getUsername().equals(p.getUsername()))&&(person.getPassword().equals(p.getPassword())))
		if(per != null)
		{
			System.out.println("success");
			return "success.jsp";
		}
		else {
			System.out.println("failed");
			return "failed.jsp";
		}
	}
}
