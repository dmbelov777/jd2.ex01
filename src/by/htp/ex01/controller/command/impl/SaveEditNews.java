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

public class SaveEditNews implements Command {
	
	private static final String MSG_NEWS_NOT_FOUND = "Could not find the News";
	private static final String MSG_NEWS_UPDATED = "News updated successfully";
	private static final String GOTO_CONTENT_PAGE_WITH_MSG = "myController?command=gotocontentpage&message=";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utl.checkIfAuthorised(request, response);
		
		String strId = (String) request.getParameter(Constant.NEWS_ID);
		int id = 0;
		String message = "";
		
		if(!strId.matches("[-+]?\\d+")) {
			message += MSG_NEWS_NOT_FOUND;
		}else {
			id = Integer.parseInt(strId);
			message += MSG_NEWS_UPDATED; 
		}
		
		request.setAttribute(Constant.NEWS_ID, id);
		
		String title = request.getParameter(Constant.NEWS_TITLE);
		String brief = request.getParameter(Constant.NEWS_BRIEF);
		String content = request.getParameter(Constant.NEWS_CONTENT);

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		
		try {
			service.changeNews(title, brief, content, id);
		} catch (ServiceException e) {
			System.out.println("Somewhat went wrong with changing news");;
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(GOTO_CONTENT_PAGE_WITH_MSG + message);
		requestDispatcher.forward(request, response);
	}
}
