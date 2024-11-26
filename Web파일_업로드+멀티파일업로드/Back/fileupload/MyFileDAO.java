package fileupload;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class MyFileDAO extends DBConnPool {
	public int insertFile(MyFileDTO dto) {
		int applyResult = 0;
		
		//MYSQL 사용시 시퀀스 생성 xxxx
		try {
			String query = "INSERT INTO myfile (title, cate, ofile, sfile) VALUES (?, ?, ?, ?)";
			
			
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getCate());
		pstmt.setString(3, dto.getOfile());
		pstmt.setString(4, dto.getSfile());
		
		applyResult = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
			
		}
		return applyResult;
		
	}
	
	public List<MyFileDTO> myFileList() {
		List<MyFileDTO> fileList = new Vector<MyFileDTO>();
		
		//쿼리문 작성
		
		String query = "SELECT * FROM myfile ORDER BY idx DESC";
		try {
		    stmt = con.createStatement(); // statement 객체 생성
		    rs = stmt.executeQuery(query); // 쿼리 실행

		    while (rs.next()) { // 목록 안의 파일 수만큼 반복
		        MyFileDTO dto = new MyFileDTO();
		        dto.setIdx(rs.getString(1));
		        dto.setTitle(rs.getString(2));
		        dto.setCate(rs.getString(3));
		        dto.setOfile(rs.getString(4));
		        dto.setSfile(rs.getString(5));
		        dto.setPostdate(rs.getString(6));

		        fileList.add(dto); // 목록에 추가
		    }
		} catch (Exception e) {
		    System.out.println("SELECT 시 예외 발생");
		    e.printStackTrace();
		}

		return fileList; // 목록 반환
		
	}

}
