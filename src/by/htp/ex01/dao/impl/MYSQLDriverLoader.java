package by.htp.ex01.dao.impl;

public class MYSQLDriverLoader {
	
	private static final MYSQLDriverLoader instance = new MYSQLDriverLoader();
	private static final String JDBC_DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	
	static {
		try {
			Class.forName(JDBC_DRIVER_PATH);
		} catch (ClassNotFoundException e) {
			throw new DBDriverLoadingException(e);
		}
	}
	
	private MYSQLDriverLoader() {}
	
	public static MYSQLDriverLoader getInstance() {
		return instance;
	}
}
