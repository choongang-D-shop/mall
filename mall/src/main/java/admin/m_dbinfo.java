package admin;

import java.sql.Connection;
import java.sql.DriverManager;

public class m_dbinfo {
	
	
	public static Connection db_connection() throws Exception{
		String db_driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://kbsn.or.kr:3306/chang_d";
		String db_user = "chang_d";
		String db_password = "2025chang";
		
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_password);
		
		return con;
	}
}
