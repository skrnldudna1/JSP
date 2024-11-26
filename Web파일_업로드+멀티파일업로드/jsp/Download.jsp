<%@ page import="java.io.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   /*  String saveDirectory = application.getRealPath("/Uploads"); */ // 파일 저장 경로 설정
    String saveDirectory = "D:/Uploads";
    String saveFilename = request.getParameter("sName"); // 저장된 파일 이름 가져오기
    String originalFilename = request.getParameter("oName"); // 원본 파일 이름 가져오기

    try {
        // 파일을 찾아 입력 스트림 생성
        File file = new File(saveDirectory, saveFilename);
        InputStream inStream = new FileInputStream(file);

        // 한글 파일명 깨짐 방지
        String client = request.getHeader("User-Agent");
        if (client.indexOf("WOW64") == -1) {
            originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
        } else {
            originalFilename = new String(originalFilename.getBytes("KSC5601"), "ISO-8859-1");
        }

        // 추가적인 파일 처리 로직이 필요할 수 있음

    } catch (Exception e) {
        e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
    }
%>
