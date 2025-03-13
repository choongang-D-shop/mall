package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_siteinfo")
public class admin_siteinfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET 요청 처리, 필요한 경우 페이지를 표시하는 로직 작성
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트로부터 폼 데이터 받아오기
        String homepage_title = request.getParameter("homepage_title");
        String admin_mail = request.getParameter("admin_mail");
        String point_use = request.getParameter("point_use");
        int join_monet = Integer.parseInt(request.getParameter("join_monet"));
        int join_level = Integer.parseInt(request.getParameter("join_level"));
        String corp_nm = request.getParameter("corp_nm");
        String corp_number = request.getParameter("corp_number");
        String corp_leader = request.getParameter("corp_leader");
        String corp_leader_number = request.getParameter("corp_leader_number");
        String mail_order_number = request.getParameter("mail_order_number");
        String add_corp_number = request.getParameter("add_corp_number");
        String corp_post = request.getParameter("corp_post");
        String corp_addr = request.getParameter("corp_addr");
        String info_manage_nm = request.getParameter("info_manage_nm");
        String info_manage_mail = request.getParameter("info_manage_mail");
        String bank = request.getParameter("bank");
        String bank_account_number = request.getParameter("bank_account_number");
        String credit_card_use = request.getParameter("credit_card_use");
        String phone_pay_use = request.getParameter("phone_pay_use");
        String book_gift_pay_use = request.getParameter("book_gift_pay_use");
        int pay_min_point = Integer.parseInt(request.getParameter("pay_min_point"));
        int pay_max_point = Integer.parseInt(request.getParameter("pay_max_point"));
        String cash_receipt = request.getParameter("cash_receipt");
        String delivery_corp = request.getParameter("delivery_corp");
        int delivery_money = Integer.parseInt(request.getParameter("delivery_money"));
        String wish_date = request.getParameter("wish_date");

        // 모델 클래스(m_admin_db) 인스턴스를 생성하여 DB에 저장
        m_admin_db adminDb = new m_admin_db();
        int result = adminDb.saveSettings(homepage_title, admin_mail, point_use, join_monet, join_level,
                                          corp_nm, corp_number, corp_leader, corp_leader_number, mail_order_number,
                                          add_corp_number, corp_post, corp_addr, info_manage_nm, info_manage_mail,
                                          bank, bank_account_number, credit_card_use, phone_pay_use, book_gift_pay_use,
                                          pay_min_point, pay_max_point, cash_receipt, delivery_corp, delivery_money, wish_date);
        
        // JavaScript를 이용해 alert을 띄우고 페이지를 새로 고침
        response.setContentType("text/html;charset=UTF-8");
        if (result > 0) {
            response.getWriter().write("<script type='text/javascript'>"
                                      + "alert('사이트 정보가 성공적으로 저장되었습니다.');"
                                      + "location.reload();</script>");
        } else {
            response.getWriter().write("<script type='text/javascript'>"
                                      + "alert('사이트 정보 저장에 실패했습니다.');"
                                      + "location.reload();</script>");
        }
    }
}

