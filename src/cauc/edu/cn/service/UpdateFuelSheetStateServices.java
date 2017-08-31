package cauc.edu.cn.service;

import cauc.edu.cn.model.FuelSheetInfo;

public class UpdateFuelSheetStateServices extends BaseServices
{
	/**
	 * 更新加油单状态
	 * @param
	 */
	
	public boolean UpdateworkersheetState_2(FuelSheetInfo fuelSheetInfo){
		
		String sql = "UPDATE fuelSheet set dictionaryid = '2' where fuelsheetid = ?";
		
		Object[] objects = new Object[] 				
		{
			fuelSheetInfo.getFuelsheetid()	
		};
		System.out.print(fuelSheetInfo.getFuelsheetid());
		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}
		else
        {
			return false;
		}
		
	}//end UpdateUser()

	public boolean UpdateworkersheetState_3(FuelSheetInfo fuelSheetInfo){
		
		String sql = "UPDATE fuelSheet set dictionaryid = '3' where fuelsheetnum = ?";
		
		Object[] objects = new Object[] 				
		{
			fuelSheetInfo.getFuelsheetnum()	
		};
		System.out.print(fuelSheetInfo.getFuelsheetid());
		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}
		else
        {
			return false;
		}
		
	}//end UpdateUser()
	
	public boolean UpdateworkersheetState_4(FuelSheetInfo fuelSheetInfo){
		
		String sql = "UPDATE fuelSheet set dictionaryid = '4' where fuelsheetnum = ?";
		
		Object[] objects = new Object[] 				
		{
			fuelSheetInfo.getFuelsheetnum()	
		};
		System.out.print(fuelSheetInfo.getFuelsheetid());
		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}
		else
        {
			return false;
		}
		
	}//end UpdateUser()
	
	public boolean UpdateworkersheetState_5(FuelSheetInfo fuelSheetInfo){
		
		String sql = "UPDATE fuelSheet set dictionaryid = '5' where fuelsheetnum = ?";
		
		Object[] objects = new Object[] 				
		{
			fuelSheetInfo.getFuelsheetnum()	
		};
		System.out.print(fuelSheetInfo.getFuelsheetid());
		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}
		else
        {
			return false;
		}
		
	}//end UpdateUser()
	
	public boolean UpdateFuelsheetState_android_4(FuelSheetInfo fuelSheetInfo){
		
		String sql = "UPDATE fuelSheet set dictionaryid = '4',xposition = ?, yposition = ?, arrivespecificlocationtime = ?, waitimageurl = ?where fuelsheetnum = ?";
		
		Object[] objects = new Object[] 				
		{
			fuelSheetInfo.getXposition(),
			fuelSheetInfo.getYposition(),
			fuelSheetInfo.getArrivespecificlocationtime(),
			fuelSheetInfo.getWaitimageurl(),
			fuelSheetInfo.getFuelsheetnum()
			
		};
		
		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}
		else
        {
			return false;
		}
		
	}//end UpdateUser()
	
	
	public boolean UpdateFuelsheetState_android_5(FuelSheetInfo fuelSheetInfo){
		
		String sql = "UPDATE fuelSheet set dictionaryid = '5',oiltotal = ?,startfueltime = ?,overfueltime = ?,oiltemperature = ?,imageurlover = ? where fuelsheetnum = ?";
		
		Object[] objects = new Object[] 				
		{
			fuelSheetInfo.getOiltotal(),
			fuelSheetInfo.getStartfueltime(),
			fuelSheetInfo.getOverfueltime(),
			fuelSheetInfo.getOiltemperature(),
			fuelSheetInfo.getImageurlover(),
			fuelSheetInfo.getFuelsheetnum()		
		};
		
		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}
		else
        {
			return false;
		}
		
	}//end UpdateUser()
	
	public boolean UpdateOilWorkeruserid(FuelSheetInfo fuelSheetInfo){
		
		String sql = "UPDATE fuelSheet set workeruserid = ? where fuelsheetid = ?";
		
		Object[] objects = new Object[] 				
		{
				
				fuelSheetInfo.getWorkeruserid(),	
				fuelSheetInfo.getFuelsheetid()
		};
		
		if((DBHelper.executeNonQuery(sql, objects)) >= 1)
		{
			return true;
		}
		else
        {
			return false;
		}
		
	}//end UpdateUser()
}
