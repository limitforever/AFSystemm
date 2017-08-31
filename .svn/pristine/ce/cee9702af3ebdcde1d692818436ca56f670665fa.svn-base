package cauc.edu.cn.servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cauc.edu.cn.model.OilWorkerInfo;
import cauc.edu.cn.service.OilWorkerServices;



/**
 * 1.首先继承 httpServlet（就已经将该类声明成了一个servlet组件）
 * 2.重写父类的方法  ，doGet，doPost
 * 3.doGet，doPost 方法就是用来接收http的请求（网页的请求）
 * 4.方法的里面，我们需要获取网页中的数据
 * 5.request是servlet组件中的请求对象，网页中请求的数据，全部被包含在request中
 * 
 * 
 * ****** 网页中，如何将表单的提交指向该类     ******
 * @author Launceviya_NoteBook
 *
 */

//web 3.0的新写法
@WebServlet("/AndroidWorkerLoginServlet")
public class AndroidWorkerLoginServlet extends HttpServlet
{
	
	/**
	 * 移动端登陆验证
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		String message = request.getParameter("message");
		
		Gson gson = new Gson();
		Map map = gson.fromJson(message, Map.class);
		
		String workeruserid = (String) map.get("workeruserid");
		String workerenpassword = (String) map.get("workerenpassword");
//		String clientcid = (String) map.get("clientcid");
		
		OilWorkerInfo oilworker = new OilWorkerInfo();
		oilworker.setWorkeruserid(workeruserid);	
		OilWorkerServices workerService  = new OilWorkerServices();
			
	    response.setCharacterEncoding("GBK");		
	    response.setContentType("text/html;charset=GBK");
	    
		PrintWriter writer = response.getWriter();
		
		if (workeruserid==null||workerenpassword==null)
		{
			System.out.print("安卓端以实现判断");	
		}
		
		try {
			if (workerService.VerifyWorker(oilworker,workerenpassword).isLogin())
			{

				
			    String workerusername = oilworker.getWorkerusername();				
				Map<String, String> map1 = new HashMap<String, String>();
			    map1.put("loginresult", "0");
			    map1.put("workerusername",workerusername);				
			    String json = gson.toJson(map1);
			 	writer.println(json);
			}
			else 
			{
				System.out.print("安卓端出错");
				writer.println("0");	
			}
		} catch (NoSuchAlgorithmException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
}

