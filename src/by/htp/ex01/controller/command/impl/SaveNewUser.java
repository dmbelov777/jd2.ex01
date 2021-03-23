package by.htp.ex01.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ex01.bean.RegistrationInfo;
import by.htp.ex01.controller.command.Command;

public class SaveNewUser implements Command {

	private static final String GOTO_INDEX_PAGE_REG_FAIL ="myController?command=gotoindexpage&message=Registration failed";
	private static final String GOTO_INDEX_PAGE_REG_OK ="myController?command=gotoindexpage&message=Registration complete";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegistrationInfo regInfo = new RegistrationInfo(); 
		
		String name = request.getParameter(Constant.USER_NAME);
		String surname = request.getParameter(Constant.USER_LAST_NAME);
		int year = Integer.parseInt(request.getParameter(Constant.USER_BIRTH_YEAR));
		String phone = request.getParameter(Constant.USER_PHONE);
		String login = request.getParameter(Constant.USER_LOGIN);
		String password = request.getParameter(Constant.USER_PASSWORD);
		
		if (name == "" || surname == "" || year == 0 || phone == "" || login == "" || password == "") {
			response.sendRedirect(GOTO_INDEX_PAGE_REG_FAIL);
			return;
		}
		
		response.sendRedirect(GOTO_INDEX_PAGE_REG_OK);
	}
}
