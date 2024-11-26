//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package fileupload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/fileupload/MultipleProcess"})
@MultipartConfig(
    maxFileSize = 1048576L,
    maxRequestSize = 10485760L
)
public class MultipleProcess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MultipleProcess() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String saveDirectory = "D:/Uploads";
            ArrayList<String> listFileName = FileUtil.multipleFile(req, saveDirectory);
            Iterator var6 = listFileName.iterator();

            while(var6.hasNext()) {
                String originalFileName = (String)var6.next();
                String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
                this.insertMyFile(req, originalFileName, savedFileName);
            }

            resp.sendRedirect("FileList.jsp");
        } catch (Exception var8) {
            Exception e = var8;
            e.printStackTrace();
            req.setAttribute("errorMessage", "파일 업로드 오류");
            req.getRequestDispatcher("MultiUploadMain.jsp").forward(req, resp);
        }

    }

    private void insertMyFile(HttpServletRequest req, String oFileName, String sFileName) {
        String title = req.getParameter("title");
        String[] cateArray = req.getParameterValues("cate");
        StringBuffer cateBuf = new StringBuffer();
        if (cateArray == null) {
            cateBuf.append("선택한 항목 없음");
        } else {
            String[] var10 = cateArray;
            int var9 = cateArray.length;

            for(int var8 = 0; var8 < var9; ++var8) {
                String s = var10[var8];
                cateBuf.append(s + ", ");
            }
        }

        System.out.println("파일외폼값:" + title + "\n" + cateBuf);
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
