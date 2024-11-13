<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% request.setCharacterEncoding("UTF-8");
    
 // 사용자가 선택한 계절과 과일을 요청에서 가져옴
    String season = request.getParameter("season");
    String fruit = request.getParameter("fruit");
    
 // 세션에서 "idKey" 속성을 가져와 id 변수에 저장 (로그인한 사용자 ID)
    String id = (String)session.getAttribute("idKey");
    
 // 세션 ID와 세션 유지 시간을 가져옴
    String sessionId = session.getId();
    int interValTime = session.getMaxInactiveInterval();
    
 // 세션이 존재하고 id가 null이 아닐 때만 사용자 정보를 출력
    if(id != null) {
  %>
        <h1>Session Example1</h1>
        <b><%=id%></b>님이 좋아하시는 계절과 과일은<p/>
        <b><%=season%></b>과 <b><%=fruit%></b>입니다. <p/>
        세션 ID : <%=sessionId%><p/>
        세션 유지 시간 : <%=interValTime%>초 <p/>
  <% 	
//세션을 무효화하여 로그아웃 상태로 만듦
  session.invalidate();
    }else{
    	out.println("세션의 시간이 경과를 하였거나 다른 이유로 연결을 할 수가 없습니다.");
    	out.println("session의 시간 경과 또는 다른 이유로 session 객체의 연결이 종료 되었습니다.");
    }
  %>
   

