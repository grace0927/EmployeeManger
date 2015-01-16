/**
 * 
 */
package come.employeemanager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employeemanager.db.ConnectionFactory;
import com.employeemanager.db.DBUtil;
import com.employeemanager.model.Employee;
import com.employeemanager.model.History;

/**
 * @author feng
 *
 */
public class HistoryDAO {
	private Connection connection;
	private Statement statement;
	
	public HistoryDAO() {
		
	}
	
	public List<History> findHistoryByEmployee(Employee employee) {
		List<History> historySet = new ArrayList<>();
		ResultSet rs = null;
		String query = "SELECT * FROM history WHERE employee_id = " + employee.getId();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				String login = rs.getString("login_time");
				String logout = rs.getString("logout_time");
				History history = new History();
				
				history.setEmployee(employee);
				history.setLogin(login);
				history.setLogout(logout);
				
				historySet.add(history);
			}
		} catch(SQLException e) {
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return historySet;
	}
	
	public boolean addEmployeeLogin(Employee employee, String login) {
		String query = "INSERT INTO history SET employee_id = " + employee.getId() + ", login_time = '"
				+ login + "'";
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(query);
		} catch(SQLException e) {
			
		} finally {
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return true;
	}
	
	public boolean updateEmployeeLogout(Employee employee, String logout) {
		String query = "UPDATE history SET logout_time = '" + logout + "', "
				+ "online = 'N' WHERE employee_id = " + employee.getId() + "AND online = 'Y'";
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch(SQLException e) {
			
		} finally {
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return true;
	}
}
