package com.company;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.el.parser.AstEqual;

@WebServlet("/login5")
public class loginServlet5 extends HttpServlet {
	public void init() 
	{
		System.out.println("Init 메서드 호출");
	}
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		
		String data = "<html>";
		 data += "<body>";
		 data += "아이디 : "+id;
		 data += "<br/>";
		 data += "패스워드 : "+pw+ "<br/>";
		 data += "주소 : " + address+"<br/>";
		 data += "</body>";
		 data += "</html>";
		 out.print(data);
		

	}

}