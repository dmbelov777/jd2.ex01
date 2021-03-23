package by.htp.ex01.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ex01.controller.command.Command;

public class EditNews implements Command{

	private static final String GOTO_EDIT_CONTENT_PAGE = "/WEB-INF/jsp/editcontentpage.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utl.checkIfAuthorised(request, response);
		
		String id = (String) request.getParameter(Constant.NEWS_ID);
		request.setAttribute(Constant.NEWS_ID, id);
		request.setAttribute(Constant.NEWS_TITLE, request.getParameter(Constant.NEWS_TITLE));
		request.setAttribute(Constant.NEWS_BRIEF, request.getParameter(Constant.NEWS_BRIEF));
		request.setAttribute(Constant.NEWS_CONTENT, request.getParameter(Constant.NEWS_CONTENT));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(GOTO_EDIT_CONTENT_PAGE);
		requestDispatcher.forward(request, response);
		
	}

}
