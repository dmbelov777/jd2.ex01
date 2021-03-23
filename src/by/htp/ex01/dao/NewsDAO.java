package by.htp.ex01.dao;

import java.util.List;

import by.htp.ex01.bean.News;

public interface NewsDAO {

	List<News> all() throws DAOException;
	
	void changeNews(String title, String brief, String content, int idnews) throws DAOException;
	
	void deleteNews(int idnews) throws DAOException;
}

