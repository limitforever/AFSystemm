package cauc.edu.cn.model;

public class OilWorkerInfo implements BaseInfo
{
    
    private String workeruserid;
    private byte[] workerenpassword;
	private String workerusername;
	private Integer age;
	private String sex;
	private String phonenum;
	private Integer workerid;
    
	public Integer getWorkerid() 
	{
		return workerid;
	}
	public void setWorkerid(Integer workerid) {
		this.workerid = workerid;
	}
	public String getWorkeruserid() {
		return workeruserid;
	}
	public void setWorkeruserid(String workeruserid) {
		this.workeruserid = workeruserid;
	}
	public byte[] getWorkerenpassword() {
		return workerenpassword;
	}
	public void setWorkerenpassword(byte[] workerenpassword) {
		this.workerenpassword = workerenpassword;
	}
	public String getWorkerusername() {
		return workerusername;
	}
	public void setWorkerusername(String workerusername) {
		this.workerusername = workerusername;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	
}

