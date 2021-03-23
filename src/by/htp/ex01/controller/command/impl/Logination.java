package by.htp.ex01.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ex01.bean.User;
import by.htp.ex01.bean.UserLoginationInfo;
import by.htp.ex01.controller.command.Command;
import by.htp.ex01.service.ServiceException;
import by.htp.ex01.service.ServiceProvider;
import by.htp.ex01.service.UserService;

public class Logination implements Command {

	private static final String GOTO_INDEX_PAGE_MSG_USER_NULL="\"myController?command=gotoindexpage&message=wrong user null\"";
	private static final String GOTO_INDEX_PAGE_MSG_WRONG_LOGIN_INFO="myController?command=gotoindexpage&message=Wrong login or password";
	private static final String GOTO_MAIN_PAGE="myController?command=gotomainpage";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login;
		String password;
		
		UserLoginationInfo userLogInfo = new UserLoginationInfo();
		
		userLogInfo.setLogin(request.getParameter(Constant.USER_LOGIN));
		userLogInfo.setPassword(request.getParameter(Constant.USER_PASSWORD));
		
		login = userLogInfo.getLogin();
		password = userLogInfo.getPassword();
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService(); 
		
		User user = null;
		RequestDispatcher requestDispatcher = null;
		
		try {
			user = userService.authorization(login, password);
			
			if(user == null) {
				requestDispatcher =  request.getRequestDispatcher(GOTO_INDEX_PAGE_MSG_USER_NULL);
				return;
			}
			
			HttpSession session = request.getSession(true);
			
			session.setAttribute(Constant.SESSION_ATR_AUTHOR, true);
			session.setAttribute(Constant.USER_LOGIN, login);
			session.setAttribute(Constant.USER_NAME, user.getName());
			session.setAttribute(Constant.USER_ROLE, user.getRole());
			
			response.sendRedirect(GOTO_MAIN_PAGE);
			
		}catch(ServiceException e) {
			response.sendRedirect(GOTO_INDEX_PAGE_MSG_WRONG_LOGIN_INFO);
		}
	}
}
