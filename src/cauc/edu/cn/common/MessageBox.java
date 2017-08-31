package cauc.edu.cn.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Administrator 弹出各种对话框的界面
 */

public class MessageBox extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12L;


	public static void ShowMessageBox(String showMessage, HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print("<script>alert('" + showMessage + "');</script>");
		} catch (IOException e) {
			System.out.println("弹出对话框失败");
			e.printStackTrace();
		}
	}//end ShowMessageBox()
	
	
	// 弹出对话框，并跳转到相应的界面
	public static void ShowMessageBoxJMP(String showMessage, String locationPath, HttpServletResponse response) {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print("<script>alert('" + showMessage + "');window.location.href='" + locationPath + "';</script>");
		} catch (IOException e) {
			System.out.println("弹出对话款失败");
			e.printStackTrace();
		}
	}// end ShowMessageBox()
	
	//获取用户
}// end Class
