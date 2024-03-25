package com.javatpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import domain.KpiDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

@CrossOrigin(origins = "*", allowedHeaders = "*") // Enable CORS globally for this controller
@RestController
public class HelloController {
	@Value("${spring.datasource.url}")
	private String databaseUrl;

	@Value("${spring.datasource.username}")
	private String databaseUsername;

	@Value("${spring.datasource.password}")
	private String databasePassword;

	@RequestMapping("/")
	public String display() {
		return "index";
	}

	@GetMapping("/data")
	@ResponseBody
	public Object[] getData() {
		KpiDTO[] data = new KpiDTO[3];

		// First object
		KpiDTO obj1 = new KpiDTO();
		obj1.setName("ABQQ=123");
		obj1.setValue("12/23/44");
		data[0] = obj1;

		// First object
		KpiDTO obj2 = new KpiDTO();
		obj2.setName("ABQQ-456");
		obj2.setValue("12/12/2024");
		data[1] = obj2;

		// Third object
		KpiDTO obj3 = new KpiDTO();
		obj3.setName("HRDH-456");
		obj3.setValue("12/12/2024");
		data[2] = obj3;

		return data;
	}

	@GetMapping("/retrieveData")
	@ResponseBody
	public List<KpiDTO> retrieveDataFromDatabase(String query) {
		List<KpiDTO> data = new ArrayList<>();

		try {
			// Establish database connection
			Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);

			// Create and execute SQL query
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			// Get column names from result set metadata
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			String columnName1 = metaData.getColumnName(1);
			String columnName2 = metaData.getColumnName(2);

			// Process the result set
			while (resultSet.next()) {
				KpiDTO kpi = new KpiDTO();
				kpi.setName(resultSet.getString(columnName1));
				kpi.setValue(resultSet.getString(columnName2));
				data.add(kpi);
			}

			// Close resources
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return data;
	}
		
}
