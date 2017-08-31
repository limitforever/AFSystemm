package os_sdk_java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;


public class pushtoSingle {

/*进哥平板一
	static String appId = "sKoLIVvJrO7zkfeNuys1W8";
	static String appkey = "GolNUQbtlm9WGawoEKJ8y3";
	static String master = "e8HkEIv7Ha5SSVKajdtFj9";
	static String host = "http://sdk.open.api.igexin.com/apiex.htm";
	static String CID = "a95b9f6656de0d273201344d61d71277";*/
//	static String CID = "1d1805ae1b40adf9c868081905f8e17e";

	static String host = "http://sdk.open.api.igexin.com/apiex.htm";


	public static void pushmessage(String androidmessage,String appId,String appkey,String master,String CID) throws Exception {

//		System.setProperty("gexin.rp.sdk.http.proxyHost","192.168.1.227");
//		System.setProperty("gexin.rp.sdk.http.proxyPort", "8080");
		IGtPush push = new IGtPush(host,appkey, master);
//		TransmissionTemplate template = TransmissionTemplateDemo();
//		LinkTemplate template = linkTemplateDemo();
		NotificationTemplate template = NotificationTemplateDemo(androidmessage,appId,appkey,master,CID);
		// NotyPopLoadTemplate template =NotyPopLoadTemplateDemo();

		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		message.setOfflineExpireTime(2 * 1000 * 3600);
		message.setData(template);
		// message.setPushNetWorkType(1); //鏍规嵁WIFI鎺ㄩ�璁剧疆

		List<Target> targets = new ArrayList<Target>();
		Target target1 = new Target();
		Target target2 = new Target();
		target1.setAppId(appId);
		target1.setClientId(CID);
//		 target1.setAlias(Alias);
		try {
			IPushResult ret = push.pushMessageToSingle(message, target1);
			System.out.println("正常：" + ret.getResponse().toString());
			
		} catch (RequestException e) {
			String requstId = e.getRequestId();
			IPushResult ret = push.pushMessageToSingle(message, target1,
					requstId);

			System.out.println("异常：" + ret.getResponse().toString());
		}

		Thread.sleep(3);

	}

	public static void sf(long time) {
		Date date = new Date(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sf.format(date));

	}

/*	public static PopupTransmissionTemplate PopupTransmissionTemplateDemo() {
		PopupTransmissionTemplate template = new PopupTransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setText("");
		template.setTitle("");
		template.setImg("");
		template.setConfirmButtonText("");
		template.setCancelButtonText("");
		template.setTransmissionContent("111");
		template.setTransmissionType(1);

		return template;
	}*/

/*	public static TransmissionTemplate TransmissionTemplateDemo()
			throws Exception {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setTransmissionType(1);
		template.setTransmissionContent("OS-TOSingle");
		// template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
//		template.setPushInfo("", 1, "", "", "", "", "", "");
		
		APNPayload apnpayload = new APNPayload();
//		com.gexin.rp.sdk.base.payload.APNPayload.SimpleAlertMsg alertMsg = new com.gexin.rp.sdk.base.payload.APNPayload.SimpleAlertMsg(
//				"hahahaha");
//		apnpayload.setAlertMsg(alertMsg);
		apnpayload.setBadge(5);
//		apnpayload.setContentAvailable(1);
//		apnpayload.setCategory("ACTIONABLE");
		template.setAPNInfo(apnpayload);
		
//			APNPayload apnpayload = new APNPayload();
//			apnpayload.setBadge(4);
//			apnpayload.setSound("test2.wav");
//			apnpayload.setContentAvailable(1);
//			apnpayload.setCategory("ACTIONABLE");
//			APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
//			alertMsg.setBody("body");
//			alertMsg.setActionLocKey("ActionLockey");
//			alertMsg.setLocKey("LocKey");
//			alertMsg.addLocArg("loc-args");
//			alertMsg.setLaunchImage("launch-image");
//			// IOS8.2以上版本支持
//			alertMsg.setTitle("Title");
//			alertMsg.setTitleLocKey("TitleLocKey");
//			alertMsg.addTitleLocArg("TitleLocArg");
//
//			apnpayload.setAlertMsg(alertMsg);
//			template.setAPNInfo(apnpayload);
		
		
		return template;
	}*/

/*	public static LinkTemplate linkTemplateDemo() throws Exception {
		LinkTemplate template = new LinkTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setTitle("唤醒");
		template.setText("唤醒");
		template.setLogo("text.png");
		// template.setLogoUrl("");
		// template.setIsRing(true);
		// template.setIsVibrate(true);
		// template.setIsClearable(true);
		template.setUrl("http://www.baidu.com");
		// template.setPushInfo("actionLocKey", 1, "message", "sound","payload",
		// "locKey", "locArgs", "launchImage");
		
		// APNPayload apnpayload = new APNPayload();
		// com.gexin.rp.sdk.base.payload.APNPayload.SimpleAlertMsg alertMsg =
		// new
		// com.gexin.rp.sdk.base.payload.APNPayload.SimpleAlertMsg("hahahaha");
		// apnpayload.setAlertMsg(alertMsg);
		// apnpayload.setBadge(5);
		// apnpayload.setContentAvailable(1);
		// apnpayload.setCategory("ACTIONABLE");
		// template.setAPNInfo(apnpayload);
		
//			
			APNPayload apnpayload = new APNPayload();
			apnpayload.setBadge(4);
			apnpayload.setSound("test2.wav");
			apnpayload.setContentAvailable(1);
			apnpayload.setCategory("ACTIONABLE");
			APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
			alertMsg.setBody("body");
			alertMsg.setActionLocKey("ActionLockey");
			alertMsg.setLocKey("LocKey");
			alertMsg.addLocArg("loc-args");
			alertMsg.setLaunchImage("launch-image");
			// IOS8.2以上版本支持
			alertMsg.setTitle("Title");
			alertMsg.setTitleLocKey("TitleLocKey");
			alertMsg.addTitleLocArg("TitleLocArg");

			apnpayload.setAlertMsg(alertMsg);
			template.setAPNInfo(apnpayload);
		 
		return template;
	}*/

	public static NotificationTemplate NotificationTemplateDemo(String androidmessage,String appId,String appkey,String master,String CID)
			throws Exception {
		NotificationTemplate template = new NotificationTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setTitle("");
		template.setText("");
		template.setLogo("icon.png");
		// template.setLogoUrl("");
		// template.setIsRing(true);
		// template.setIsVibrate(true);
		// template.setIsClearable(true);
		template.setTransmissionType(1);
		template.setTransmissionContent(androidmessage);
		//"{\"messageType\":\"7\",\"fuelsheetid\":\"120341B\",\"workeruserid\":\"120341228\",\"FlightNO\":\"1234\",\"ParkingPLace\":\"101\",\"VehicleNum\":11011,\"EarliestFuelTime\":\"2015-07-10-20-20-20\",\"LatestFuelTime\":\"59\"}"
		// template.setPushInfo("actionLocKey", 2, "message", "sound",
		// "payload", "locKey", "locArgs", "launchImage");
		return template;
	}

/*	public static NotyPopLoadTemplate NotyPopLoadTemplateDemo() {
		NotyPopLoadTemplate template = new NotyPopLoadTemplate();
		// 濉啓appid涓巃ppkey
		template.setAppId(appId);
		template.setAppkey(appkey);
		// 濉啓閫氱煡鏍囬鍜屽唴瀹�
		template.setNotyTitle("");
		template.setNotyContent("");
		// template.setLogoUrl("");
		// 濉啓鍥炬爣鏂囦欢鍚嶇�?
		template.setNotyIcon("text.png");
		// 璁剧疆鍝嶉搩锛岄渿鍔紝涓庡彲娓呴櫎
		// template.setBelled(false);
		// template.setVibrationed(false);
		// template.setCleared(true);

		// 璁剧疆寮规鏍囬涓庡唴瀹�
		template.setPopTitle("");
		template.setPopContent("");
		// 璁剧疆寮规鍥剧�?
		template.setPopImage("http://www-igexin.qiniudn.com/wp-content/uploads/2013/08/logo_getui1.png");
		template.setPopButton1("");
		template.setPopButton2("");

		// 璁剧疆涓嬭浇鏍囬锛屽浘鐗囦笌涓嬭浇鍦板�?
		template.setLoadTitle("涓嬭浇鏍囬");
		template.setLoadIcon("file://icon.png");
		template.setLoadUrl("http://gdown.baidu.com/data/wisegame/c95836e06c224f51/weixinxinqing_5.apk");
		template.setActived(true);
		template.setAutoInstall(true);
		template.setAndroidMark("");
		return template;
	}*/
}