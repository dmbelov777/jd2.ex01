package by.htp.ex01.dao.impl;

public class DBDriverLoadingException extends RuntimeException {

	private static final long serialVersionUID = -4953617922042035885L;

	public DBDriverLoadingException(Exception e) {
		super(e);
	}
}
