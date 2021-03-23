package by.htp.ex01.service.impl;

import by.htp.ex01.bean.RegistrationInfo;
import by.htp.ex01.bean.User;
import by.htp.ex01.dao.DAOException;
import by.htp.ex01.dao.DAOProvider;
import by.htp.ex01.dao.UserDAO;
import by.htp.ex01.service.ServiceException;
import by.htp.ex01.service.UserService;

public class UserServiceImpl implements UserService {

	private static final String MSG_WRONG_LOGIN_OR_PASSWORD = "Wrong login or password";
	private static final String MSG_ERROR = "error message";
	
	@Override
	public User authorization(String login, String password) throws ServiceException {
		// validation
		
		if(login == null || "".equals(login) || password == null || "".equals(password)) { //proceed with password
			throw new ServiceException(MSG_WRONG_LOGIN_OR_PASSWORD);
		}
		
		UserDAO userDAO = DAOProvider.getInstance().getUserDAO();
		
		User user = null;
		
		try {
			user = userDAO.authorization(login, password);
		} catch(DAOException e) {
			throw new ServiceException(MSG_ERROR, e);
		}
 		return user;
	}

	@Override
	public boolean registration(RegistrationInfo regInfo) throws ServiceException {
		
		
		return false;
	}

}
