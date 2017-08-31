package cauc.edu.cn.xml;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cauc.edu.cn.model.FlightInfo;
import cauc.edu.cn.service.FlightInfoServices;

import org.w3c.dom.Node;
/**
 * 解析次日航班计划信息，存入数据库中
 * @author Administrator
 *
 */
public class ParsingXMLFile {

	public ParsingXMLFile() {
	}// ParsingXMLFile()

	/**
	 * 根据XML文档的名字获取文档的对象
	 * @return
	 * @throws IOException 
	 */
	public static Node GetXMLDocument(String fileName) throws IOException {
		// Get Document Object To
		DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;

		try {
			dBuilder = dBuilderFactory.newDocumentBuilder();
			doc = dBuilder.parse(fileName);
		} catch (ParserConfigurationException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return doc.getDocumentElement();
	}// GetXMLDocument()

	/**
	 * 解析航班中计划航班信息的节点
	 * @param node
	 */
	public void ParsingSchdNode(Node node) {
		Node nodes = node.getFirstChild();

		if (nodes.getNodeName() == "schd") {
			ParsingFltrNode(nodes);
		} else {
			ParsingSchdNode(nodes);
		}

	}// ParsingSchdNode()

	/**
	 * 获得次日航班计划中的所有航班信息
	 */
	public ArrayList<FlightInfo> ParsingFltrNode(Node root) {

		System.out.println(root.getNodeName());
		ArrayList<FlightInfo> flightInfos = new ArrayList<FlightInfo>();
		NodeList nodes = root.getChildNodes();
		
		for (int i = 0; i < nodes.getLength(); i++) {
			
			Node node = nodes.item(i);
			
			//如果根节点的子节点中的名字为sched则为循环节点
			if (node.getNodeName() == "schd") {
				
				NodeList fltrNode = node.getChildNodes();
				for(int j = 0; j < fltrNode.getLength(); j++){
					
					Node flightNode = fltrNode.item(j);
					if (flightNode.getNodeName() == "fltr") {
						System.out.println("flightnode" + flightNode.getNodeName());
						flightInfos.add(InitFlightInfoList(flightNode.getChildNodes()));
					}//if
				}//for
				
			}//if
			
		}//for

		return flightInfos;
	}// ParsingFltrNode()

	/**
	 * 获取一条XML记录中一个航班信息
	 * 
	 * @return FLight
	 */
	public FlightInfo InitFlightInfoList(NodeList nodeList) {

		FlightInfo flightInfo = new FlightInfo();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);

			System.out.println("fltr: " + node.getNodeName());
			switch (node.getNodeName()) {
			case "flid": // AODB鍞竴鐨勮埅鐝璉D
				flightInfo.setFlid(node.getTextContent());
				break;
			case "flno": // 鑸彮鍙�
				flightInfo.setFlno(node.getTextContent());
				break;
			case "reno": // 椋炴満鏈哄瀷
				flightInfo.setReno(node.getTextContent());
				break;
			case "alcd": // 鑸┖鍏徃浠ｇ爜
				flightInfo.setAlcd(node.getTextContent());
				break;
			case "stnd": // 鍋滄満浣�
				flightInfo.setStnd(node.getTextContent());
				break;
			case "mvin": // 鑸彮鏄繘鍑烘腐鏍囧織 A(鍒拌揪)D(绂诲紑)
				flightInfo.setMvin(node.getTextContent());
				break;
			case "psdt":
				Map<String, String> map = ParsingRoutNode(node.getChildNodes());
					flightInfo.setScdt(TransStringToDate(map.get("stet")));
					flightInfo.setScat(TransStringToDate(map.get("stst")));
				//flightInfo.setSodt(TransStringToDate(node.getTextContent()));
				break;
			default:
				break;
			}
		}

		return flightInfo;
	}// InitFlightInfoList()

	/**
	 * 解析预计到达时间和预计离开时间
	 * @param nodes
	 * @return map
	 */
	public Map<String, String> ParsingRoutNode(NodeList nodes){
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (((node.getNodeName() == "stst") || (node.getNodeName() == "stet"))) {
				map.put(node.getNodeName(), node.getTextContent());
			}
		}//for
		
		//每一次返回的表单数据键值对为scdt或者是scat
		return map;
	}//ParsingRoutNode()	
	
	/**
	 * 格式化字符串
	 * @param dateString
	 * @return 时间字符串
	 */
	public String TransStringToDate(String dateString) {
		
		dateString = dateString.substring(0, 2) + TransMonth(dateString.substring(2, 5)) + dateString.substring(5, dateString.length());
		
		SimpleDateFormat sDateFormat = new SimpleDateFormat("ddMMyyHHmm");

		SimpleDateFormat returnDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		java.util.Date date = null;

		try {
			date = sDateFormat.parse(dateString);
		} catch (ParseException e) {
			System.err.println("Parsing Error!");
			e.printStackTrace();
		}
//		return date;
		return  returnDateFormat.format(date);

	}// TransStringToDate()

	
	/**
	 * 
	 * @param monthString
	 * @return 月份时间
	 */
	public String TransMonth(String monthString){
		String tempString = null;
		switch (monthString) {
		case "JAN":
			tempString = "01";
			break;
		case "FEB":
			tempString = "02";
			break;
		case "MAR":
			tempString = "03";
			break;
		case "APR":
			tempString = "04";
			break;
		case "MAY":
			tempString = "05";
			break;
		case "JUN":
			tempString = "06";
			break;
		case "JUL":
			tempString = "07";
			break;
		case "AUG":
			tempString = "08";
			break;
		case "SEP":
			tempString = "09";
			break;
		case "OCT":
			tempString = "10";
			break;
		case "NOV":
			tempString = "11";
			break;
		case "DEC":
			tempString = "12";
			break;
		default:
			break;
		}
		return tempString;
	}//TransMonth()
	
	public static boolean ImportFile(String filename) throws IOException{
		
		ArrayList<FlightInfo> flightInfos = new ParsingXMLFile().ParsingFltrNode(ParsingXMLFile.GetXMLDocument(filename));
		boolean isSuccess = true;
		
//		for (FlightInfo flightInfo : flightInfos) {
//			if(!(FlightInfoServices.AddFlight(flightInfo))){
//				isSuccess = false;
//			}//if
//		}//for
		
		return isSuccess;
	}//ImportFile()
	
//	//main
//	public static void main(String[] args) {
//
//		String fileName = "F:\\schd_none20140619010950980.xml";
//		
//		ParsingXMLFile.ImportFile(fileName);
//	}// main
	
}// Class
