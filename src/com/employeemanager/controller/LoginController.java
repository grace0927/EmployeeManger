package com.employeemanager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.findByUsername(username);
		
		if(employee.getPassword().equals(password)) {
			rd = request.getRequestDispatcher("/profile.jsp");
			request.setAttribute("employee", employee);
		} else {
			rd = request.getRequestDispatcher("/index.jsp");
		}
		
		rd.forward(request, response);
	}

}
