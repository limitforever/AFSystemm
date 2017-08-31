package cauc.edu.cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cauc.edu.cn.common.MessageBox;
import cauc.edu.cn.model.FuelSheetInfo;
import cauc.edu.cn.service.UpdateFuelSheetStateServices;
import cauc.edu.cn.xml.ParsingXMLFile;

/**
 * Servlet implementation class ParsingScheduleFlightServlet
 */
@WebServlet("/ParsingScheduleFlightServlet")
public class ParsingScheduleFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParsingScheduleFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Come In ParsingScheduleFlightServlet");
		
		request.setCharacterEncoding("UTF-8");
		String filePath = request.getParameter("filePath");
		System.out.println(filePath);
		
		boolean isSuccess = true;
		boolean findfile = true;
		
		try {			
			isSuccess = ParsingXMLFile.ImportFile(filePath);
		} catch (Exception e) {
			isSuccess = false;
			findfile = false;
		}
		
		
		if (isSuccess) {
			MessageBox.ShowMessageBoxJMP("导入次日航班计划成功", request.getContextPath() + "/FlightInfo.jsp", response);
		}else{
			if (findfile) {
				//如果不成功，则应进行数据库的数据回滚，待实现
				MessageBox.ShowMessageBoxJMP("导入次日航班计划失败, XML文件出现问题", request.getContextPath() + "/FlightInfo.jsp", response);
			}else{
				MessageBox.ShowMessageBoxJMP("导入次日航班计划失败, 找不到指定文件", request.getContextPath() + "/FlightInfo.jsp", response);
				
			}
			//实现数据库的回滚
		}
		
	}//doPost()

}//class
