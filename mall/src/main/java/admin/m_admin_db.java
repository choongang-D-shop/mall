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

   public int db_in(dto_admin ad) {
	   try {
		   this.con = this.db.db_connection();
		   this.sql = "insert into shop_preferences (homepage_title,admin_mail,point_use,join_point,join_level,"
		   		+ "corp_nm,corp_number,corp_leader,corp_leader_number,mail_order_number,add_corp_number,corp_post,"
		   		+ "corp_addr,info_manage_nm,info_manage_mail,bank,bank_account_number,credit_card_use,"
		   		+ "phone_pay_use,book_gift_pay_use,pay_min_point,pay_max_point,cash_receipt,delivery_corp,"
		   		+ "delivery_money,wish_date) "
		   		+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		   this.ps = this.con.prepareStatement(this.sql);
		   this.ps.setString(1, ad.getHomepage_title());
		    this.ps.setString(2, ad.getAdmin_mail());
		    this.ps.setString(3, ad.getPoint_use().equals("on") ? "Y" : "N");  // (1) CHAR(1)인 경우
		    this.ps.setInt(4, ad.getJoin_point());
		    this.ps.setInt(5, ad.getJoin_level());
		    this.ps.setString(6, ad.getCorp_nm());
		    this.ps.setString(7, ad.getCorp_number());
		    this.ps.setString(8, ad.getCorp_leader());
		    this.ps.setString(9, ad.getCorp_leader_number());
		    this.ps.setString(10, ad.getMail_order_number());
		    this.ps.setString(11, ad.getAdd_corp_number());
		    this.ps.setString(12, ad.getCorp_post());
		    this.ps.setString(13, ad.getCorp_addr());
		    this.ps.setString(14, ad.getInfo_manage_nm());
		    this.ps.setString(15, ad.getInfo_manage_mail());
		    this.ps.setString(16, ad.getBank());
		    this.ps.setInt(17, ad.getBank_account_number());
		    this.ps.setString(18, ad.getCredit_card_use().equals("on") ? "Y" : "N");
		    this.ps.setString(19, ad.getPhone_pay_use().equals("on") ? "Y" : "N");
		    this.ps.setString(20, ad.getBook_gift_pay_use().equals("on") ? "Y" : "N");
		    this.ps.setInt(21, ad.getPay_min_point());
		    this.ps.setInt(22, ad.getPay_max_point());
		    this.ps.setString(23, ad.getCash_receipt().equals("on") ? "Y" : "N");
		    this.ps.setString(24, ad.getDelivery_corp());
		    this.ps.setInt(25, ad.getDelivery_money());
		    this.ps.setString(26, ad.getWish_date().equals("on") ? "Y" : "N");
		    
		   this.result = this.ps.executeUpdate();
	   } catch (Exception e) {
		   e.printStackTrace();
		    System.out.println("DB 저장 중 오류 발생!");
	   } finally {
		   try {
			   this.ps.close();
			   this.con.close();
		} catch (Exception e) {

		}
	   }
	   
	   return result;
   }
        
        
    
}
