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

    // 데이터베이스에 값을 저장하는 메소드
    public int saveSettings(String homepage_title, String admin_mail, String point_use, 
                            int join_monet, int join_level, String corp_nm, String corp_number, 
                            String corp_leader, String corp_leader_number, String mail_order_number, 
                            String add_corp_number, String corp_post, String corp_addr, 
                            String info_manage_nm, String info_manage_mail, String bank, 
                            String bank_account_number, String credit_card_use, String phone_pay_use, 
                            String book_gift_pay_use, int pay_min_point, int pay_max_point, 
                            String cash_receipt, String delivery_corp, int delivery_money, 
                            String wish_date) {
        try {
            try {
				this.con = this.db.db_connection();
			} catch (Exception e) {
			
				e.printStackTrace();
			}

            // SQL 쿼리문
            this.sql = "INSERT INTO shop_preferences (homepage_title, admin_mail, point_use, join_monet, join_level, "
                + "corp_nm, corp_number, corp_leader, corp_leader_number, mail_order_number, add_corp_number, "
                + "corp_post, corp_addr, info_manage_nm, info_manage_mail, bank, bank_account_number, "
                + "credit_card_use, phone_pay_use, book_gift_pay_use, pay_min_point, pay_max_point, cash_receipt, "
                + "delivery_corp, delivery_money, wish_date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            this.ps = this.con.prepareStatement(this.sql);
            
            // PreparedStatement에 값 설정
            this.ps.setString(1, homepage_title);
            this.ps.setString(2, admin_mail);
            this.ps.setString(3, point_use);
            this.ps.setInt(4, join_monet);
            this.ps.setInt(5, join_level);
            this.ps.setString(6, corp_nm);
            this.ps.setString(7, corp_number);
            this.ps.setString(8, corp_leader);
            this.ps.setString(9, corp_leader_number);
            this.ps.setString(10, mail_order_number);
            this.ps.setString(11, add_corp_number);
            this.ps.setString(12, corp_post);
            this.ps.setString(13, corp_addr);
            this.ps.setString(14, info_manage_nm);
            this.ps.setString(15, info_manage_mail);
            this.ps.setString(16, bank);
            this.ps.setString(17, bank_account_number);
            this.ps.setString(18, credit_card_use);
            this.ps.setString(19, phone_pay_use);
            this.ps.setString(20, book_gift_pay_use);
            this.ps.setInt(21, pay_min_point);
            this.ps.setInt(22, pay_max_point);
            this.ps.setString(23, cash_receipt);
            this.ps.setString(24, delivery_corp);
            this.ps.setInt(25, delivery_money);
            this.ps.setString(26, wish_date);

            // 쿼리 실행
            this.result = this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.ps != null) this.ps.close();
                if (this.con != null) this.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return this.result;
    }
}
