package cauc.edu.cn.model;

public class FuelSheetInfo implements BaseInfo
{
	private Integer fuelsheetid;
	private String fuelsheetnum;
	private String oilbrand;
	private String arrivespecificlocationtime;
	private String waitimageurl;
	private String startfueltime;
	private String earliestfueltime;
	private String latestfueltime;
	private double fuelduration;
	private String overfueltime;
	private String vehiclenum;
	private String workeruserid;

	private Integer flid;
	private Integer environmentid;
	private Integer dictionaryid;
	private double xposition;
	private double yposition;
	private double oiltotal;
	private double oiltemperature;
	private String imageurlover;
	
	
	public Integer getFuelsheetid() {
		return fuelsheetid;
	}
	public void setFuelsheetid(Integer fuelsheetid) {
		this.fuelsheetid = fuelsheetid;
	}
	public String getEarliestfueltime() {
		return earliestfueltime;
	}
	public void setEarliestfueltime(String earliestfueltime) {
		this.earliestfueltime = earliestfueltime;
	}
	public String getLatestfueltime() {
		return latestfueltime;
	}
	public void setLatestfueltime(String latestfueltime) {
		this.latestfueltime = latestfueltime;
	}
	public String getWorkeruserid() {
		return workeruserid;
	}
	public void setWorkeruserid(String workeruserid) {
		this.workeruserid = workeruserid;
	}
	public String getVehiclenum() {
		return vehiclenum;
	}
	public void setVehiclenum(String vehiclenum) {
		this.vehiclenum = vehiclenum;
	}
	
	public Integer getFlid() {
		return flid;
	}
	public void setFlid(Integer flid) {
		this.flid = flid;
	}
	public Integer getEnvironmentid() {
		return environmentid;
	}
	public void setEnvironmentid(Integer environmentid) {
		this.environmentid = environmentid;
	}
	public String getOilbrand() {
		return oilbrand;
	}
	public void setOilbrand(String oilbrand) {
		this.oilbrand = oilbrand;
	}
	public Integer getDictionaryid() {
		return dictionaryid;
	}
	public void setDictionaryid(Integer dictionaryid) {
		this.dictionaryid = dictionaryid;
	}
	public String getArrivespecificlocationtime() {
		return arrivespecificlocationtime;
	}
	public void setArrivespecificlocationtime(String arrivespecificlocationtime) {
		this.arrivespecificlocationtime = arrivespecificlocationtime;
	}
	public String getWaitimageurl() {
		return waitimageurl;
	}
	public void setWaitimageurl(String waitimageurl) {
		this.waitimageurl = waitimageurl;
	}
	public double getXposition() {
		return xposition;
	}
	public void setXposition(double xposition) {
		this.xposition = xposition;
	}
	public double getYposition() {
		return yposition;
	}
	public void setYposition(double yposition) {
		this.yposition = yposition;
	}
	public String getStartfueltime() {
		return startfueltime;
	}
	public void setStartfueltime(String startfueltime) {
		this.startfueltime = startfueltime;
	}
	public String getOverfueltime() {
		return overfueltime;
	}
	public void setOverfueltime(String overfueltime) {
		this.overfueltime = overfueltime;
	}
	public double getOiltotal() {
		return oiltotal;
	}
	public void setOiltotal(double oiltotal) {
		this.oiltotal = oiltotal;
	}
	public double getOiltemperature() {
		return oiltemperature;
	}
	public void setOiltemperature(double oiltemperature) {
		this.oiltemperature = oiltemperature;
	}
	public String getImageurlover() {
		return imageurlover;
	}
	public void setImageurlover(String imageurlover) {
		this.imageurlover = imageurlover;
	}
	public String getFuelsheetnum() {
		return fuelsheetnum;
	}
	public void setFuelsheetnum(String fuelsheetnum) {
		this.fuelsheetnum = fuelsheetnum;
	}
	public double getFuelduration() {
		return fuelduration;
	}
	public void setFuelduration(double fuelduration) {
		this.fuelduration = fuelduration;
	}
}
