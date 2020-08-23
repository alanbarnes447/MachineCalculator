package volSfmCalculator;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.*;




//This class is the DAO class that connects to mysql
//initializing the DAO object creates the driver for the database

public class JobsDAO 
{
	private Connection myConn;
	
	public JobsDAO() throws Exception 
	{
		//get properties that are saved in properties file in project
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		//get connection to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		JOptionPane.showMessageDialog(null, "DB connection successful to: " + dburl);
	}
	
//	create methods in the DAO that are called through the executing program
//	Methods are called after initializing a DAO object
//	all calls to methods of the DAO must be in a try catch block
//	DAO = data access object
	
//	need to create a model class that describes the database in order to hold the data
//	that is queried from the database
	
	
	
	
	
//	Example methods for the DAO
	/*
	
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from employees");
		
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			return list;
			
		}
		finally {
			close(myStmt, myRs);
			
		}
	}
	
	public List<Employee> searchEmployees(String lastName) throws Exception {
		List<Employee> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		 
		try {
			lastName += "%";
			myStmt = myConn.prepareStatement("select * from employyes where last_name like ?");
			myStmt.setString(1, lastName);
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub 
		
	}
	
	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	private Employee convertRowToEmployee (ResultSet myRs) throws Exception {
		return null;
		
	}
	
	public static void main(String[] args) {
		EmployeeDAO dao = new EmpolyeeDAO();
		System.out.println(dao.searchEmployees("thom"));
		System.out.println(dao.getAllEmployees());
	}
	*/

}
