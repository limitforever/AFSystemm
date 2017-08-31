package cauc.edu.cn.model;


public class VehicleInfo implements BaseInfo
{
	private Integer vehicleid;
	private String vehiclenum;
	private String vehiclelicence;
	private String vehiclemodel;
	private String clientnum;
	private String dictionaryid;
	
	public Integer getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(Integer vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getVehiclenum() {
		return vehiclenum;
	}
	public void setVehiclenum(String vehiclenum) {
		this.vehiclenum = vehiclenum;
	}
	public String getVehiclemodel() {
		return vehiclemodel;
	}
	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}

	public String getDictionaryid() {
		return dictionaryid;
	}
	public void setDictionaryid(String dictionaryid) {
		this.dictionaryid = dictionaryid;
	}
	public String getVehiclelicence() {
		return vehiclelicence;
	}
	public void setVehiclelicence(String vehiclelicence) {
		this.vehiclelicence = vehiclelicence;
	}
	public String getClientnum() {
		return clientnum;
	}
	public void setClientnum(String clientnum) {
		this.clientnum = clientnum;
	}
	
}
