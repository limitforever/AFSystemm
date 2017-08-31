package cauc.edu.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import cauc.edu.cn.common.PropertiesUtils;
import cauc.edu.cn.model.FuelSheetInfo;
import cauc.edu.cn.service.UpdateFuelSheetStateServices;


/**
 * Servlet implementation class AndroidWorkerArrviedServlet
 */
@WebServlet(    
        urlPatterns = { "/AndroidWorkerArrviedServlet" }  
        )  
@MultipartConfig(  
        maxFileSize = 1024 * 1024 * 10
        //最大上传文件大小,经测试应该是k为单位  10MB
) 
public class AndroidWorkerArrviedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fileNameExtractorRegex = "filename=\".+\"";  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String message = request.getParameter("message");
		
		Gson gson = new Gson();
		Map map = gson.fromJson(message, Map.class);
	
		String fuelsheetnum = (String) map.get("fuelsheetnum");
		String xposition  = (String) map.get("xposition");
		String yposition  = (String) map.get("yposition");
		String arrivespecificlocationtime = (String) map.get("arrivespecificlocationtime");
		
		
		FuelSheetInfo fuelSheetInfo = new FuelSheetInfo();
		fuelSheetInfo.setFuelsheetnum(fuelsheetnum);
//		fuelSheetInfo.setFuelsheetid(Integer.parseInt(fuelsheetid));
		fuelSheetInfo.setXposition(Double.parseDouble(xposition));
		fuelSheetInfo.setYposition(Double.parseDouble(yposition));
		fuelSheetInfo.setArrivespecificlocationtime(arrivespecificlocationtime);
		//获取文件
		Part part = request.getPart("waitimageurl");
		//获取文件名
		String fileName = getFileName(part);
		String absolutePath =PropertiesUtils.getImageProperties("imageServerAbsolutePath");
		//absolutePath 保存文件
		//获取tomcat的磁盘路径
		String absoluteFilePath = absolutePath+"/"+fileName;
		System.out.println("文件的磁盘绝对路径（tomcat下）："+absoluteFilePath);
		//url 存入数据库
		part.write(absoluteFilePath);
		System.err.println(request.getLocalAddr());
		String urlPath = "http://"+PropertiesUtils.getImageProperties("imageServerIP")+":"+PropertiesUtils.getImageProperties("imageServerPort")+"/"+PropertiesUtils.getImageProperties("imageServerFolderName")+"/"+fileName;
		System.out.println("文件的URL路径:"+urlPath);
		
		fuelSheetInfo.setWaitimageurl(urlPath);
		
		//加油员到达指定位置后更新加油单记录
		UpdateFuelSheetStateServices updatedateworkersheetStateService = new UpdateFuelSheetStateServices();
		updatedateworkersheetStateService.UpdateFuelsheetState_android_4(fuelSheetInfo);
				
		PrintWriter writer = response.getWriter();
		writer.println("0");	
		/**
		 * 更新 
		 */
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter writer = response.getWriter();
//		writer.print("<script>$('#dg2').datagrid('reload');</script>");		
		
	}
	
	public String getFileName(Part part){
		 //获取header信息中的content-disposition，如果为文件，则可以从其中提取出文件名  
        String cotentDesc = part.getHeader("content-disposition");  
        String fileName = null;  
        Pattern pattern = Pattern.compile(fileNameExtractorRegex);  
        Matcher matcher = pattern.matcher(cotentDesc);  
        if(matcher.find()){  
            fileName = matcher.group();  
            fileName = fileName.substring(10, fileName.length()-1);  
        }  
        return fileName;  
	}
}
