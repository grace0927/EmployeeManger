/**
 * 
 */
package com.employeemanager.model;

/**
 * @author feng
 *
 */
public class Employee {
	private String username;
	private String password;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Employee() {
		
	}
	
	public Employee(String username) {
		this.username = username;
	}
	
	public Employee(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public boolean setUsername(String username) {
		this.username = username;
		return true;
	}
	
	public boolean setPassword(String password) {
		this.password = password;
		return true;
	}
	
	public boolean setFirstName(String firstName) {
		this.firstName = firstName;
		return true;
	}
	
	public boolean setLastName(String lastName) {
		this.lastName = lastName;
		return true;
	}
	
	public boolean setEmail(String email) {
		this.email = email;
		return true;
	}
}
