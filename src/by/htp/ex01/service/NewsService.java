package by.htp.ex01.service;

import java.util.List;
import by.htp.ex01.bean.News;

public interface NewsService {

	List<News> takeAll() throws ServiceException;
	
	void changeNews(String title, String brief, String content, int idnews) throws ServiceException;
	
	void deleteNews(int idnews) throws ServiceException;
	
}
