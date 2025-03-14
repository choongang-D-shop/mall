package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class m_admin_db {
    Connection con = null;
    PreparedStatement ps = null;
    m_dbinfo db = new m_dbinfo(); // db 접속
    String sql = ""; // SQL 쿼리문
    int result = 0; // DB 저장 결과값
    
    dto_admin ad = new dto_admin(); //DTO

   
        
        
    
}
