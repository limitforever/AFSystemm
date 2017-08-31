package cauc.edu.cn.model;


/**
 * 
 * @author Administrator
 * 此实体的存在性有待争议
 */
public class OilWorkFuelInfo{
	private String oilWorkername;
	private Double oilTotal;			//对应加油员工的所有数据	
	
	public String getOilWorkername() {
		return oilWorkername;
	}
	public void setOilWorkername(String oilWorkername) {
		this.oilWorkername = oilWorkername;
	}
	public Double getOilTotal() {
		return oilTotal;
	}
	public void setOilTotal(Double oilTotal) {
		this.oilTotal = oilTotal;
	}
}//class
