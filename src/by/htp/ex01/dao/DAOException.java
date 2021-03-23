package by.htp.ex01.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = 7499729690485050102L;
	
	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}

}
