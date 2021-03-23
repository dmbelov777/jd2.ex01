package by.htp.ex01.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ex01.bean.News;
import by.htp.ex01.controller.command.Command;
import by.htp.ex01.service.NewsService;
import by.htp.ex01.service.ServiceException;
import by.htp.ex01.service.ServiceProvider;

public class GoToIndexPage implements Command {
	
	private static final String SET_INTO_SESSION_PRIVIOUS_URL= "url";
	private static final String GOTO_INDEX_PAGE = "/WEB-INF/jsp/main-index.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try {
			List<News> news = newsService.takeAll();
			
			request.setAttribute(Constant.LIST_NEWS, news);
			
			HttpSession session = request.getSession(true);	
			String url = request.getRequestURL().toString() + "?" + request.getQueryString();
			session.setAttribute(SET_INTO_SESSION_PRIVIOUS_URL, url);
			
			RequestDispatcher reDispatcher = request.getRequestDispatcher(GOTO_INDEX_PAGE);
			reDispatcher.forward(request, response);
			
			
		} catch (ServiceException e) {
			String message = Constant.NEWS_READ_ERROR;
			request.setAttribute(Constant.PUT_REQUEST_ATR_MESSAGE, message);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher(Constant.GOTO_ERROR_PAGE);
			reqDispatcher.forward(request, response);
		}
	}
}
