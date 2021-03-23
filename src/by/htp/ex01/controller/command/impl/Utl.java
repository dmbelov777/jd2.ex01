package by.htp.ex01.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Utl {
	
	private static final String GOTO_INDEX_PAGE_SESSION_ENDED = "myController?command=gotoindexpage&message=Your session has been ended. Please sign in.";
	private static final String GOTO_INDEX_PAGE_PLEASE_LOG_IN = "myController?command=gotoindexpage&message=Please sign in";
	
	static void checkIfAuthorised (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		HttpSession session = request.getSession(true);
		
		if(session == null) {
			response.sendRedirect(GOTO_INDEX_PAGE_SESSION_ENDED);
			return;
		}
		
		Boolean isAuth = (Boolean) session.getAttribute(Constant.SESSION_ATR_AUTHOR);
		
		if(isAuth == null || !isAuth) {
			response.sendRedirect(GOTO_INDEX_PAGE_PLEASE_LOG_IN);
			return;
		}
	}
}
