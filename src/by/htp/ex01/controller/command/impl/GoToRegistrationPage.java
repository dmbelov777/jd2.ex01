package by.htp.ex01.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ex01.controller.command.Command;

public class GoToRegistrationPage implements Command {

	private static final String GOTO_REGISTRATION_PAGE = "/WEB-INF/jsp/registration.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reDispatcher = request.getRequestDispatcher(GOTO_REGISTRATION_PAGE);
		reDispatcher.forward(request, response);
	}

}
