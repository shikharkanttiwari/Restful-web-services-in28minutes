package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	//GET
	//URI-hello world
//	@GetMapping("/helloworld")
	@Autowired
	private MessageSource messageSource;
	@RequestMapping(method=RequestMethod.GET,path="/helloworld")
	public String helloWorld(){	
		return "Hello World";
		}

	@RequestMapping(method=RequestMethod.GET,path="/helloworldbean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
}
	@RequestMapping( method=RequestMethod.GET,path="/helloworld/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s", name));
}
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
		
}
