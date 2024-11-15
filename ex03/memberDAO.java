package com.company.ex03;


//커넥션풀로 바꾸기
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.swing.ListCellRenderer;

import javax.naming.Context;

public class memberDAO {
	
	/*
	 * private static final String driver = "oracle.jdbc.OracleDriver"; private
	 * static final String url = "jdbc:oracle:thin:@localhost:1521:XE"; private
	 * static final String user = "yjm"; private static final String pwd = "yjm";
	 */
private Connection con;
private PreparedStatement pstmt;
private DataSource dataFactory;

public memberDAO() {
    try {
        Context ctx = new InitialContext();
        Context envContext = (Context) ctx.lookup("java:/comp/env"); // JNDI 환경 설정
        dataFactory = (DataSource) envContext.lookup("jdbc/oracle"); // DataSource 초기화
    } catch (Exception e) {
        e.printStackTrace();
    }
}

	
	public List <MemberVO> listMember() {
		
		List <MemberVO> list = new ArrayList<>();
		
		try {
           // connDB();
			con = dataFactory.getConnection();
			String query = "select * from t_member";
            //System.out.println(query);
            System.out.println("PreparedStatement :" +query);
            pstmt = con.prepareStatement(query);  //추가
            ResultSet rs = pstmt.executeQuery(query);
            
            while(rs.next()) {
                // 레코드에 있는 값을 변수로 대입
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate"); // 수정된 부분
                
                // MemberVO 객체 생성 및 값 설정
                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                
                // 리스트에 추가
                list.add(vo);
            }
            
            rs.close();
            pstmt.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
	/*
	 * private void connDB() { try { Class.forName(driver); // driver 오타 수정
	 * System.out.println("Oracle 드라이버 로딩 성공"); con =
	 * DriverManager.getConnection(url, user, pwd);
	 * System.out.println("Connection 성공"); //stmt = con.createStatement(); // 세미콜론
	 * 추가 //프리페오룰 하기 때문에 필요없는 코드 } catch (Exception e) { e.printStackTrace(); } }
	 */
	

}
