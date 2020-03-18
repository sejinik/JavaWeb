package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload.do")
public class FIleUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		File currentDirPath = new File("C:\\file_repo");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for(int i=0;i<items.size();i++) {
				FileItem fileitem = (FileItem) items.get(i);
				
				if(fileitem.isFormField()) {
					System.out.println(fileitem.getFieldName()+"="+fileitem.getString(encoding));
				} else {
					System.out.println("파마미터명 : " +fileitem.getFieldName());
					System.out.println("파일명 : "+fileitem.getName());
					System.out.println("파일크기 : "+fileitem.getSize()+"bytes");
					
					if(fileitem.getSize()>0) {
						int idx = fileitem.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx = fileitem.getName().lastIndexOf("/");
						}
						String fileName = fileitem.getName().substring(idx+1);
						File uploadFile = new File(currentDirPath+"\\"+fileName);
						fileitem.write(uploadFile);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
