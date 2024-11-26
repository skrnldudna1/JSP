package fileupload;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/fileupload/UploadProcess")
@MultipartConfig (
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024 * 1024 * 10
		)
public class UploadProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String saveDirectory = "D:/Uploads";
			
			 // 업로드 폴더 존재 여부 확인 및 생성
		    File uploadDir = new File(saveDirectory);
		    if (!uploadDir.exists()) {
		        uploadDir.mkdirs(); // 폴더가 없으면 생성
		    }
		    
		    
			
			 String originalFileName = FileUtil.uploadFile(req, saveDirectory); String
			 savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			 insertMyFile(req, originalFileName, savedFileName);
			 resp.sendRedirect("FileList.jsp");
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "파일 업로드 오류");
			req.getRequestDispatcher("FileUpload.jsp").forward(req,resp);
		}
	}
	
	private void insertMyFile(HttpServletRequest req, String oFileName, String sFileName) {
	    // 메소드 내용은 없음
		
		String title = req.getParameter("title");
		String[] cateArray = req.getParameterValues("cate");
		StringBuffer cateBuf = new StringBuffer();
		if (cateArray == null) {
			cateBuf.append("선택한 항목 없음");
		}
		else {
			for (String s : cateArray) {
				cateBuf.append(s + ",");
			}
		}
		MyFileDTO dto = new MyFileDTO();
		dto.setTitle(title);
		dto.setCate(cateBuf.toString());
		dto.setOfile(oFileName);
		dto.setSfile(sFileName);
		
		MyFileDAO dao = new MyFileDAO();
		dao.insertFile(dto);
		dao.close();
	}
	
	



}
