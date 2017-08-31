package cauc.edu.cn.model;

public class LoginUserInfo 
{
	
	private boolean isLogin;
	public AFUserInfo userInfo;
	private OilWorkerInfo oilWorkerInfo;
	
	public OilWorkerInfo getOilWorkerInfo() {
		return oilWorkerInfo;
	}
	public void setOilWorkerInfo(OilWorkerInfo oilWorkerInfo) {
		this.oilWorkerInfo = oilWorkerInfo;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public AFUserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(AFUserInfo userInfo) {
		this.userInfo = userInfo;
	}


}
