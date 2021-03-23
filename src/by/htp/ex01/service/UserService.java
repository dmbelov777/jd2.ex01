package by.htp.ex01.service;

import by.htp.ex01.bean.RegistrationInfo;
import by.htp.ex01.bean.User;

public interface UserService {
	
	User authorization(String login, String password) throws ServiceException;
	boolean registration(RegistrationInfo regInfo) throws ServiceException;

}
