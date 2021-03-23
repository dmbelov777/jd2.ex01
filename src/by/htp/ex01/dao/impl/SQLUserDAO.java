package by.htp.ex01.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.ex01.bean.RegistrationInfo;
import by.htp.ex01.bean.User;
import by.htp.ex01.controller.command.impl.Constant;
import by.htp.ex01.dao.DAOException;
import by.htp.ex01.dao.UserDAO;

public class SQLUserDAO implements UserDAO {
	
	static {
		MYSQLDriverLoader.getInstance();
	}

	@Override
	public User authorization(String login, String password) throws DAOException {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			con = MYSQLBaseConnector.connectDB();
			st = con.createStatement();
			rs = st.executeQuery(DBRequest.FIND_LOGIN + login 
								+ DBRequest.FIND_PASSWORD + password + "'");
		
			user = new User();
		
		while(rs.next()) {
			String name = rs.getString(Constant.USER_NAME);
			String role = rs.getString(Constant.USER_ROLE);
			
			user.setName(name);
			user.setRole(role);
		}
		
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		return user;
	}

	@Override
	public boolean registration(RegistrationInfo regInfo) {
		// TODO Auto-generated method stub
		return false;
	}

}
