package com.company.ex03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;



@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		   memberDAO dao = new memberDAO(); // 클래스 이름 수정
		   List<MemberVO> list = dao.listMember();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		

        for (int i = 0; i < list.size(); i++) {
            MemberVO memberVo = list.get(i); // 변수 이름 수정
            String id = memberVo.getId(); // 변수명 일치
            String pwd = memberVo.getPwd();
            String name = memberVo.getName();
            String email = memberVo.getEmail();
            Date joinDate = memberVo.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>"+ pwd + "</td><td>"+ name + "</td><td>"+ email + "</td><td>"+ joinDate + "</td></tr>");
		}
		out.print("</table></body></html>");
	
	}

}
