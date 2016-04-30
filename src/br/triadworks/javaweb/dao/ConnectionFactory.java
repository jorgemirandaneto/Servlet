package br.triadworks.javaweb.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public java.sql.Connection getConnection(){
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","1q2w3e4r");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
