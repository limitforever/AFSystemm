package cauc.edu.cn.common;

import java.text.SimpleDateFormat;
import java.util.Date;


import cauc.edu.cn.model.AFUserInfo;

public class RecordAssist {

	public String getDate() {
		return date;
	}
	public AFUserInfo getUserInfo() {
		return userInfo;
	}
	public String getDescr() {
		return descr;
	}
	private String date;
	private AFUserInfo userInfo;
	private String descr;
	
	public RecordAssist(String descr, AFUserInfo userInfo){
		
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.date = sdf.format(date);
		
		this.descr = descr;
		this.userInfo = userInfo;
	}
	
}
