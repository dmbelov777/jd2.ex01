package by.htp.ex01.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ex01.bean.News;
import by.htp.ex01.controller.command.Command;
import by.htp.ex01.service.NewsService;
import by.htp.ex01.service.ServiceException;
import by.htp.ex01.service.ServiceProvider;

public class GoToMainPage implements Command{

	private static final String GOTO_MAIN_PAGE = "/WEB-INF/jsp/main.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utl.checkIfAuthorised(request, response); 
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		List<News> news = null;
		
		try {
			 	news = newsService.takeAll();
			 	
			 	request.setAttribute(Constant.LIST_NEWS, news);
			 	
			 	RequestDispatcher requestDispatcher = request.getRequestDispatcher(GOTO_MAIN_PAGE);
				requestDispatcher.forward(request, response);
		} catch (ServiceException e) {
			
			String message = Constant.NEWS_READ_ERROR;
			request.setAttribute(Constant.PUT_REQUEST_ATR_MESSAGE, message);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher(Constant.GOTO_ERROR_PAGE);
			reqDispatcher.forward(request, response);
		} 
	}
}