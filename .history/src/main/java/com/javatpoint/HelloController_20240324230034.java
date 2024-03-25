package com.javatpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import domain.KpiDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*") // Enable CORS globally for this controller
@RestController
public class HelloController {
@
	@RestController
	public class HelloController {
		@Value("${spring.datasource.url}")
		private String databaseUrl;

		@Value("${spring.datasource.username}")
		private String databaseUsername;

		@Value("${spring.datasource.password}")
		private String databasePassword;

		// ...

		@GetMapping("/retrieveData")
		@ResponseBody
		public List<KpiDTO> retrieveDataFromDatabase() {
			List<KpiDTO> data = new ArrayList<>();

			try {
				// Establish database connection
				Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);

				// Create and execute SQL query
				String query = "SELECT name, value FROM mytable";
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);

				// Process the result set
				while (resultSet.next()) {
					KpiDTO kpi = new KpiDTO();
					kpi.setName(resultSet.getString("name"));
					kpi.setValue(resultSet.getString("value"));
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
	@RestController
	public class HelloController {

		@Value("${spring.datasource.url}")
		private String databaseUrl;

		@Value("${spring.datasource.username}")
		private String databaseUsername;

		@Value("${spring.datasource.password}")
		private String databasePassword;

		// ...

		@GetMapping("/retrieveData")
		@ResponseBody
		public List<KpiDTO> retrieveDataFromDatabase() {
			List<KpiDTO> data = new ArrayList<>();

			try {
				// Establish database connection
				Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);

				// Create and execute SQL query
				String query = "SELECT name, value FROM mytable";
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);

				// Process the result set
				while (resultSet.next()) {
					KpiDTO kpi = new KpiDTO();
					kpi.setName(resultSet.getString("name"));
					kpi.setValue(resultSet.getString("value"));
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
	@ResponseBody
	public List<KpiDTO> retrieveDataFromDatabase() {
		List<KpiDTO> data = new ArrayList<>();
		
		try {
			// Establish database connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
			
			// Create and execute SQL query
			String query = "SELECT name, value FROM mytable";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			// Process the result set
			while (resultSet.next()) {
				KpiDTO kpi = new KpiDTO();
				kpi.setName(resultSet.getString("name"));
				kpi.setValue(resultSet.getString("value"));
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
