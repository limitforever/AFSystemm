package cauc.edu.cn.common;
/**
 * 
 * @author Administrator
 * 用于对应加油车对应的工作状态的枚举类
 * 总共有四种状态
 */
public enum FuelSheetStatus 
{
	WaitingForWork("等待派发工作", 1), Waiting("等待确认工作",2),WaitingToAffirm("等待执行工作", 3), 
	Working("正在执行工作", 4), Worked("加油完成", 5);
		
	private String name;
	private int index;
	private FuelSheetStatus(String name, int index){
		this.name = name;
		this.index = index;
	}//FuelSheetStatus;
	
	public static String getName(int index){
		for (FuelSheetStatus fuelSheetStatus : FuelSheetStatus.values()) {
			if (fuelSheetStatus.index == index) {
				return fuelSheetStatus.name;
			}
		}
		return null;
	}//getName()
	
	public String toString(){			//覆写toString()方法
		return this.index + ":" + this.name;
	}//
	
	public String getInfo(){
		return this.name;
	}//getInfo
	
//	//员工工作状态
//	WaitingForWork(1),			//等待派发工作 
//	WaitingToAffirm(2),			//等待执行工作
//	Working(3),					//正在进行工作
//	Worked(4);					//工作完成
//	
//	private final int value;
//	
//	public int getValue(){
//		return value;
//	}
//	
//	private FuelSheetStatus(int value) {
//		this.value = value;
//	}//end WorkerStatus()
	
}//Enum
