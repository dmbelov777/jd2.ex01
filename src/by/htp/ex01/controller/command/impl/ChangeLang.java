package by.htp.ex01.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ex01.controller.command.Command;

public class ChangeLang implements Command {

	private static final String LOCALE = "local";
	private static final String SESSION_URL = "url";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		
		session.setAttribute(LOCALE, request.getParameter(LOCALE));
		String url = (String) session.getAttribute(SESSION_URL);		
		
		response.sendRedirect(url);
	}
}
