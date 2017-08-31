package cauc.edu.cn.model;

import java.util.ArrayList;

/**
 * 分页工具类
 * 用来保存分页的相关信息与查询的结果集
 * @author Launceviya_NoteBook
 *
 */
public class PaginationInfo 
{
	
	//总记录数
	private int totalCountNum;
	
	//总页数
	private int totalPageNum;
	
	//结果集
	private ArrayList<BaseInfo> BaseInfoList = new ArrayList<BaseInfo>();
	
	

	public int getTotalCountNum() {
		return totalCountNum;
	}

	public void setTotalCountNum(int totalCountNum) {
		this.totalCountNum = totalCountNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public ArrayList<BaseInfo> getBaseInfoList() {
		return BaseInfoList;
	}

	public void setBaseInfoList(ArrayList<BaseInfo> baseInfoList) {
		BaseInfoList = baseInfoList;
	}

}
