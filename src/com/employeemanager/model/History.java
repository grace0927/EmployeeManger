/**
 * 
 */
package com.employeemanager.model;

/**
 * @author feng
 *
 */
public class History {
	private int id;
	private Employee employee;
	private String login;
	private String logout;
	private String online;
	
	public History() {
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getLogout() {
		return this.logout;
	}
	
	public String getOnline() {
		return this.online;
	}
	
	public boolean setEmployee(Employee employee) {
		this.employee = employee;
		return true;
	}
	
	public boolean setLogin(String login) {
		this.login = login;
		return true;
	}
	
	public boolean setLogout(String logout) {
		this.logout = logout;
		return true;
	}
	
	public boolean setOnline(String online) {
		this.online = online;
		return true;
	}
}
