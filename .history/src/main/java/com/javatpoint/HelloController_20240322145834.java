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
		Object obj1 = new KpiDTO();
		obj1 = "name";
		obj1.value = "behzad";
		data[0] = obj1;
		
	

		
		return data;
	}
}
