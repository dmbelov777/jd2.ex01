package by.htp.ex01.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLBaseConnector {
	
	private static final String BASE_NAME = "jdbc:mysql://localhost/news_management?useSSL=false&serverTimezone=UTC";
	private static final String BASE_USER_NAME = "root";
	private static final String PASSWORD = "12345678";
	
	static Connection connectDB() throws SQLException {
			Connection connection = DriverManager.getConnection(BASE_NAME, BASE_USER_NAME, PASSWORD);
		return connection;
	}
	
}
