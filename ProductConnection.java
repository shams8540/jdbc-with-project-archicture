package com.ibm.jdbc_preparedstatement_crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ProductConnection {

	public static Connection getProductConnection() {
		
		//step-1 load/register driver
		/**
		 * if you want to register driver
		 * 
		 * step-1 create object of Driver class
		 * Driver class is present in com.mysql.cj.jdbc package
		 * 
		 * pass driver class reference variable to registerDriver(Driver d) method
		 * which is present in DriverManager class
		 */
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//step-2  create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-e3";
			String user = "root";
			String pass = "root";
			
			Connection connection=DriverManager.getConnection(url, user, pass);
			
			return connection;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return null;
		}
		
	}
}
