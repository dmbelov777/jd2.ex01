package by.htp.ex01.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import by.htp.ex01.bean.News;
import by.htp.ex01.controller.command.impl.Constant;
import by.htp.ex01.dao.DAOException;
import by.htp.ex01.dao.NewsDAO;

public class SQLNewsDAO implements NewsDAO {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss");

	static {
		MYSQLDriverLoader.getInstance();
	}

	@Override
	public List<News> all() throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		List<News> news = null;
		
		try {
			con = MYSQLBaseConnector.connectDB();
			st = con.createStatement();
			rs = st.executeQuery(DBRequest.SELECT_ALL_NEWS);
			 
			news = new ArrayList<News>();
			
			while(rs.next()) {

				int id = rs.getInt(Constant.NEWS_ID);
				String title = rs.getString(Constant.NEWS_TITLE);
				String brief = rs.getString(Constant.NEWS_BRIEF);
				String content = rs.getString(Constant.NEWS_CONTENT);
				LocalDate date = LocalDate.parse(rs.getString(Constant.NEWS_DATE), formatter);
				String status = rs.getString(Constant.NEWS_STATUS);
				
				News n = new News(id, title, brief, content, status, date);
				news.add(n);
			}
			
		}catch(SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return news;
	}

	@Override
	public void changeNews(String title, String brief, String content, int idnews) throws DAOException {
			
		Connection con = null;
		Statement st = null;
		
		try {
			con = MYSQLBaseConnector.connectDB();
			st = con.createStatement();
			String query = DBRequest.SET_TITLE + title + "', brief='" + brief + "', content='" + content + "' WHERE idnews=" + idnews;
			st.executeUpdate(query);
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
	}

	@Override
	public void deleteNews(int idnews) throws DAOException {
		
		Connection con = null;
		Statement st = null;
		
		try {
			con = MYSQLBaseConnector.connectDB();
			st = con.createStatement();
			String query = DBRequest.SET_STATUS_DEL + idnews;
			st.executeUpdate(query);
			
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
	}
}

