package fileupload;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class FileUtil {
	//파일 업로드
	
	
	  public static String uploadFile(HttpServletRequest req, String sDirectory)
	  throws ServletException, IOException { Part part = req.getPart("ofile");
	  String partHeader = part.getHeader("content-disposition"); String[] phArr =
	  partHeader.split("filename="); String originalFileName =
	  phArr[1].trim().replace("\"", ""); if (!originalFileName.isEmpty()) {
	  part.write(sDirectory + File.separator + originalFileName); }
	  
	  return originalFileName; }
	

		// 파일명 변경 (다른이름으로 저장)
		public static String renameFile(String sDirectory, String fileName) {
		    String ext = fileName.substring(fileName.lastIndexOf("."));
		    String now = new SimpleDateFormat("yyyyMMdd_HHmmSS").format(new Date());
		    String newFileName = now + ext;
		    File oldFile = new File(sDirectory + File.separator + fileName);
		    File newFile = new File(sDirectory + File.separator + newFileName);
		    oldFile.renameTo(newFile);

		    return newFileName;
		}
		
	    public static ArrayList<String> multipleFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException {
	        ArrayList<String> listFileName = new ArrayList();
	        Collection<Part> parts = req.getParts();
	        Iterator var5 = parts.iterator();

	        while(var5.hasNext()) {
	            Part part = (Part)var5.next();
	            if (part.getName().equals("ofile")) {
	                String partHeader = part.getHeader("content-disposition");
	                System.out.println("partHeader=" + partHeader);
	                String[] phArr = partHeader.split("filename=");
	                String originalFileName = phArr[1].trim().replace("\"", "");
	                if (!originalFileName.isEmpty()) {
	                    part.write(sDirectory + File.separator + originalFileName);
	                }

	                listFileName.add(originalFileName);
	            }
	        }

	        return listFileName;
	    }
	}



