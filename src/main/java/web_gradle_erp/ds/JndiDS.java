package web_gradle_erp.ds;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JndiDS {
	private static DataSource ds;

	private JndiDS() {
	}

	// static 생성자 호출전 먼저 실행
	static {
		try {
			InitialContext ic = new InitialContext(); // 1. JNDI 서버 객체 생성
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/web_gradle_erp"); // 2. lookup()
			System.out.println("ds : " + ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
