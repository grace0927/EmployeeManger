/**
 * 
 */
package com.employeemanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.employeemanager.db.ConnectionFactory;
import com.employeemanager.db.DBUtil;
import com.employeemanager.model.Employee;

/**
 * @author feng
 *
 */
public class EmployeeDAO {
	private Connection connection;
	private Statement statement;
	
	public EmployeeDAO() {
		
	}
	
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		String query = "SELECT * FROM employee";
		ResultSet res = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			res = statement.executeQuery(query);
			
			while(res.next()) {
				String username = res.getString("username");
				String password = res.getString("password");
				Employee employee = new Employee(username, password);
				employees.add(employee);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(res);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return employees;
	}
	
	public Employee findByUsername(String username) {
		Employee employee = new Employee();
		employee.setUsername(username);
		String query = "SELECT * FROM employee WHERE username = '" + username + "'";
		ResultSet res = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			res = statement.executeQuery(query);
			while(res.next()) {
				String password = res.getString("password");
				String email = res.getString("email");
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				employee.setPassword(password);
				employee.setEmail(email);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}
}
