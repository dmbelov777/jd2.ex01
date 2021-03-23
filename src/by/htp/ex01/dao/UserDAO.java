package by.htp.ex01.dao;

import by.htp.ex01.bean.RegistrationInfo;
import by.htp.ex01.bean.User;

public interface UserDAO {
	
	User authorization(String login, String password) throws DAOException; 
	boolean registration(RegistrationInfo regInfo) throws DAOException;

}
