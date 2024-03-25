package com.javatpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.KpiDTO;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;
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
