package by.htp.ex01.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ex01.controller.command.Command;

public class Logout implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if(session != null) {
			session.removeAttribute("auth");
		}
		
		response.sendRedirect("myController?command=gotoindexpage&message=Logout complete");
	}
}
