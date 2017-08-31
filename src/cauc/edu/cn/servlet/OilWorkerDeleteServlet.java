package cauc.edu.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cauc.edu.cn.common.RecordAssist;
import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.model.OilWorkerInfo;
import cauc.edu.cn.service.OilWorkerServices;
import cauc.edu.cn.service.OperatorRecordServices;

@WebServlet("/OilWorkerDeleteServlet")
public class OilWorkerDeleteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer Workerid = Integer.parseInt(request.getParameter("id"));
		String workeruserid = request.getParameter("workeruserid");
		OilWorkerInfo oilworker = new OilWorkerInfo();
		oilworker.setWorkerid(Workerid);
		OilWorkerServices WorkerService = new OilWorkerServices();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		boolean VerifyaddWorker = WorkerService.DelWorker(oilworker);
		Map<String,String> map = new HashMap<String, String>();
		

		/*
		 * 记录用户的操作记录
		 */
		HttpSession session = request.getSession();
		AFUserInfo userInfo = (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		
		RecordAssist recordAssist = new RecordAssist("删除加油人员"+ workeruserid, userInfo);
		
		
		if(VerifyaddWorker)
		{
			OperatorRecordServices.AddOperatorRecord(recordAssist);
			map.put("resultMsg", "ok");
			writer.print(gson.toJson(map));
		}
		else
		{
			map.put("resultMsg", "fail");
			writer.print(gson.toJson(map));
		}	
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
