package com.javatpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.KpiDTO;
@Controller
public class HelloController {
@RequestMapping("/")
	public String display()
	{
		return "index";
	}	
	@GetMapping("/data")
	@ResponseBody
	public Object[] getData() {
		Object[] data = new KpiDTO[3];
		
		// First object
		Object obj1 = new Object();
		obj1.key = "name";
		obj1.value = "behzad";
		data[0] = obj1;
		
		// Second object
		Object obj2 = new Object();
		obj2.key = "name";
		obj2.value = "ali";
		data[1] = obj2;
		
		// Third object
		Object obj3 = new Object();
		obj3.key = "name";
		obj3.value = "ali";
		data[2] = obj3;
		
		return data;
	}
}
