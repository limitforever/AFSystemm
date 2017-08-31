package cauc.edu.cn.service;

import java.util.Map;

import cauc.edu.cn.model.FuelSheetInfo;
import cauc.edu.cn.model.PaginationInfo;

public class WaitingForWorkSheetServices extends BaseServices
{
	/**
	 * 支持分页的全部查询
	 * @return 待派工信息集
	 * @throws NoSuchFieldException 
	 */
	public PaginationInfo queryWaitingForWorkSheetByPagination(int currentPageNum,int pageSize,Map<String, String> queryCondition) throws NoSuchFieldException
	{
		String sql = "select fuel.fuelsheetid, fuel.fuelsheetnum, flight.flno as oilbrand,flight.alcd as arrivespecificlocationtime,flight.scat as waitimageurl ,flight.scdt as startfueltime, fuel.earliestfueltime, fuel.latestfueltime,  fuel.fuelduration, flight.stnd as overfueltime,oilworker.workerusername as  workeruserid, fuel.vehiclenum from fuelsheet fuel inner join flightinformation flight on fuel.flid = flight.flid INNER JOIN oilworker on oilworker.workeruserid = fuel.workeruserid INNER JOIN vehicle on vehicle.vehiclenum = fuel.vehiclenum where fuel.dictionaryid = '1'";
		return QueryBaseInfoByPagination(sql, currentPageNum, pageSize, FuelSheetInfo.class);
	}
}
