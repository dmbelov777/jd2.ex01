package by.htp.ex01.service.impl;

import java.util.List;

import by.htp.ex01.bean.News;
import by.htp.ex01.dao.DAOException;
import by.htp.ex01.dao.DAOProvider;
import by.htp.ex01.dao.NewsDAO;
import by.htp.ex01.service.NewsService;
import by.htp.ex01.service.ServiceException;

public class NewsServiceImpl implements NewsService {

 	@Override
	public List<News> takeAll() throws ServiceException {

 		DAOProvider provider = DAOProvider.getInstance();
 		NewsDAO newsDAO = provider.getNewsDAO();
 		
 		List<News> news;
 		try {
 			news = newsDAO.all();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
 		
 		return news;
	}

	@Override
	public void changeNews(String title, String brief, String content, int idnews) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO dao = provider.getNewsDAO();
		
		try {
			dao.changeNews(title, brief, content, idnews);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteNews(int idnews) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO dao = provider.getNewsDAO();
		
		try {
			dao.deleteNews(idnews);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}
}
