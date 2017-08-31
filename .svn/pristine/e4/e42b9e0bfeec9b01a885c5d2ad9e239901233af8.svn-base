package cauc.edu.cn.service;

import java.util.Map;

import cauc.edu.cn.model.FuelSheetInfo;
import cauc.edu.cn.model.PaginationInfo;

public class MonitoringWorkingServices extends BaseServices
{
	/**
	 * 支持分页的全部查询
	 * @return
	 * @throws NoSuchFieldException 
	 */
	public PaginationInfo queryWaitingForWorkSheetByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{
		String sql = "select fuel.fuelsheetid,fuel.fuelsheetnum, flight.flno as oilbrand,oilworker.workerusername as arrivespecificlocationtime,vehicle.vehiclelicence as waitimageurl , flight.stnd as startfueltime,dictionary.dictionaryname as earliestfueltime FROM fuelsheet fuel INNER JOIN oilworker on oilworker.workeruserid = fuel.workeruserid INNER JOIN vehicle on vehicle.vehiclenum = fuel.vehiclenum INNER JOIN dictionary on dictionary.dictionaryid = fuel.dictionaryid INNER JOIN flightinformation flight on flight.flid = fuel.flid where fuel.dictionaryid = '2' or fuel.dictionaryid = '3'or fuel.dictionaryid = '4'or fuel.dictionaryid = '5'";
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, FuelSheetInfo.class);
	}
	

	
	
	
}
