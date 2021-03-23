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

public class GoToContentPage implements Command {

	private static final String GOTO_CONTENT_PAGE = "/WEB-INF/jsp/contentpage.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider provider 	= ServiceProvider.getInstance();
		NewsService		newsService	= provider.getNewsService();
		
		List<News> news = null;
		
		String id = (String) request.getParameter(Constant.NEWS_ID);
		int idnews = Integer.parseInt(id);
		
		try {
			news = newsService.takeAll();
			
			for (News n : news) {
				if (n.getIdnews() != idnews) {
					continue;
				}
				
				request.setAttribute(Constant.NEWS_TITLE, n.getTitle());
				request.setAttribute(Constant.NEWS_BRIEF, n.getBrief());
				request.setAttribute(Constant.NEWS_CONTENT, n.getContent());
				request.setAttribute(Constant.NEWS_ID, n.getIdnews());
				request.setAttribute(Constant.NEWS_DATE, n.getDate().toString());
				request.setAttribute(Constant.NEWS_STATUS, n.getStatus());
			}
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher(GOTO_CONTENT_PAGE);
			reqDispatcher.forward(request, response);
			
		} catch (ServiceException e) {
			
			String message = Constant.NEWS_READ_ERROR;
			request.setAttribute(Constant.PUT_REQUEST_ATR_MESSAGE, message);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher(Constant.GOTO_ERROR_PAGE);
			reqDispatcher.forward(request, response);
		}
	}
}
