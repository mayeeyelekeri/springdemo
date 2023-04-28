package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController	
public class HelloController {

	@Value("${message}")
	private String message;
	
	@Value ("${myenvironment}")
	private String myEnv; 
	
	@GetMapping("/")
	public String index() {
		return "hello from \"" + myEnv +"\", message is " + message; 
	}
	
	@GetMapping("/greetings")
	public String greetings() {
		String dburl = System.getenv().getOrDefault("example.datasource.url", "got default value");
		return "db URL : " + dburl; 
	}
	
	@RequestMapping(value = "/env", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getEnv() {
		System.out.println("inside getEnv(), environment = "+myEnv);
		ModelAndView mv = new ModelAndView(); 
		if (myEnv.equals("prod")) {
			mv.addObject("env", myEnv); 
			mv.setViewName("production");
		} else {		
			mv.addObject("env", myEnv); 			
			mv.setViewName("development");	
		}
	    System.out.println("returning view" + mv); 
        return mv;   
	}

}
