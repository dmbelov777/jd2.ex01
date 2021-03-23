package by.htp.ex01.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ex01.controller.command.Command;
import by.htp.ex01.service.NewsService;
import by.htp.ex01.service.ServiceException;
import by.htp.ex01.service.ServiceProvider;

public class DeleteNews implements Command {
	
	private static final String PUT_REQUEST_ATR_MESSAGE= "message";
	
	private static final String MSG_ISNOT_FOUND = "Could not find this news";
	private static final String MSG_NEWS_DELETED = "News Deleted";
	private static final String MSG_ISNOT_DELETED= "Could not delete this news";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId = request.getParameter(Constant.NEWS_ID);
		int id = 0;
		
		String message = "";
		
		if(!strId.matches("[-+]?\\d+")) {
			message += "MSG_ISNOT_FOUND"; 
		} else {
			id = Integer.parseInt(strId);
			message += "MSG_NEWS_DELETED";
		}
		
		request.setAttribute("PUT_REQUEST_ATR_MESSAGE", message);
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		
		try {
			service.deleteNews(id);
		} catch (ServiceException e) {
			System.out.println("MSG_ISNOT_DELETED");
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("myController?command=gotomainpage");
		requestDispatcher.forward(request, response);
	}
}
