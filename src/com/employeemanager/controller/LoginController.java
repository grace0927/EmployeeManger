package com.employeemanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanager.model.Employee;
import come.employeemanager.dao.EmployeeDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.findByUsername(username);
		
		if(employee.getPassword().equals(password)) {
			request.setAttribute("employee", employee);
			response.setContentType("text/html");
			String html = "First Name: " + employee.getFirstName() + "<br> Last Name: " + employee.getLastName()
					+ "<br> Email: " + employee.getEmail();
			response.getWriter().write(html);
		}
	}

}
