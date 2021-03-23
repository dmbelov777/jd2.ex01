package by.htp.ex01.dao.impl;

public class DBRequest {

	// News
	protected static final String SELECT_ALL_NEWS ="SELECT * FROM news"; 
	protected static final String SET_TITLE ="UPDATE news_management.news SET title='"; 
	protected static final String SET_STATUS_DEL ="UPDATE news_management.news SET status='deleted' WHERE idnews="; 
	
	// Users
	protected static final String FIND_LOGIN ="SELECT * FROM users WHERE login='"; 
	protected static final String FIND_PASSWORD ="' AND password='"; 
}
