package cauc.edu.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cauc.edu.cn.common.GeneVerifyPicture;
import cauc.edu.cn.common.MessageBox;
import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.service.UserServices;


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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String checkstring = null;

	

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {    		  
			  
	   GeneVerifyPicture mp=new GeneVerifyPicture() ;
	   checkstring = mp.drawPicture(70, 30,response.getOutputStream());
	   
   }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/**
		 * 1.获取网页表单中的用户名和密码
		 * 2.得到用户名和密码，分别赋予变量
		 * 3.判断用户名和密码是否正确，决定页面的跳转方向
		 */
		String usernum = request.getParameter("usernum");
		String nonenpassword = request.getParameter("nonenpassword");
		String check = request.getParameter("check");
		 
		AFUserInfo afUserInfo = new AFUserInfo();
		afUserInfo.setUsernum(usernum);
		afUserInfo.setNonenpassword(nonenpassword);		

		System.out.println(checkstring);
		System.out.println(usernum);
		System.out.println(nonenpassword);
		
		AFUserInfo afuser = UserServices.VerifyUser(afUserInfo).userInfo;
		
		System.out.println(afuser.getUsername());
		System.out.println(afuser.getSex());
		System.out.println(afuser.getEnpassword());
		
		
		if(UserServices.VerifyUser(afUserInfo).isLogin() && check.equals(checkstring))
		{		
			HttpSession session = request.getSession();			   			 
			session.setAttribute("CURRENTLOGINUSER", afUserInfo);
			request.getRequestDispatcher("/Index.jsp").forward(request, response);
		}		
		else 
		{	
			if (UserServices.VerifyUser(afUserInfo).isLogin())
			{			
				MessageBox.ShowMessageBoxJMP("验证码错误", "Login.jsp", response);				
			}
			else 
			{		
				MessageBox.ShowMessageBoxJMP("用户名或密码不正确!", "Login.jsp", response);
			}
		}	
	}
}
