package cauc.edu.cn.model;

public class OperatorRecordInfo implements BaseInfo
{
	private Integer operatorrecordid;
	private Integer usernum;
	private String operatortime;
	private String operatordescr;
	
	public Integer getOperatorrecordid()
	{
		return operatorrecordid;
	}
	public void setOperatorrecordid(Integer operatorrecordid) {
		this.operatorrecordid = operatorrecordid;
	}
	public String getOperatortime() {
		return operatortime;
	}
	public void setOperatortime(String operatortime) {
		this.operatortime = operatortime;
	}
	public String getOperatordescr() {
		return operatordescr;
	}
	public void setOperatordescr(String operatordescr) {
		this.operatordescr = operatordescr;
	}
	public Integer getUsernum() {
		return usernum;
	}
	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}
	
}
