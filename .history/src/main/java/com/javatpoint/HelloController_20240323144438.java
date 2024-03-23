package com.javatpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import domain.KpiDTO;
@CrossOrigin(origins = "*", allowedHeaders = "*") // Enable CORS globally for this controller
@RestController
public class HelloController {
@RequestMapping("/")
	public String display()
	{
		return "index";
	}	
	@GetMapping("/data")
	@ResponseBody
	public Object[] getData() {
		KpiDTO[] data = new KpiDTO[3];
		
		// First object
		KpiDTO obj1 = new KpiDTO();
		obj1.setName("name");
		obj1.setValue("behzad");
		data[0] = obj1;
		
		// First object
		KpiDTO obj2 = new KpiDTO();
		obj2.setName("name");
		obj2.setValue("behzad");
		data[1] = obj2;

		
		return data;
	}
}
