package dbUtils;

import java.sql.*;
import java.util.Vector;

public class Connect {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306homepharmacydb?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
	private static String user = "root";
	private static String password = "030803";
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	

	public static Connection connectMySQL() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}



	public static void closeMySQL() {
		try {
			if (rs != null)
				rs.close();
			rs = null;
			if (stmt != null)
				stmt.close();
			stmt = null;
			if (conn != null)
				conn.close();
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
