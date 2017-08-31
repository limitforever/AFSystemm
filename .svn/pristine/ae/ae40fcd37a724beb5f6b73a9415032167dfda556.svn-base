package cauc.edu.cn.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import cauc.edu.cn.model.AFUserInfo;
import cauc.edu.cn.model.LoginUserInfo;

/**
 * 
 * @author Administrator
 * 用户加密算法的辅助类
 */
public class MD5Encrypted {

	/**
	 * 加密密码字符串
	 * 
	 * @param password
	 * @return 加密后的字符数组
	 */
	public static byte[] DoEncrypt(String password){
		
		byte[] encryptPassword = null;
		
		try {
			//生成随机函数
			SecureRandom random = new SecureRandom();
			byte[] salt = new byte[12];
			
			random.nextBytes(salt);
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(salt); 	//追加
			
			messageDigest.update(password.getBytes());
			byte[] digest = messageDigest.digest();
			
			encryptPassword = new byte[digest.length + 12];
			System.arraycopy(salt, 0, encryptPassword, 0, 12);
			System.arraycopy(digest, 0, encryptPassword, 12, digest.length);
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("加密算法没有找到");
			e.printStackTrace();
		}
		return encryptPassword;
	}//end DoEncrypt()
	
	
	public static byte[] DoDigest(String password) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(password.getBytes());
		byte[] digest = messageDigest.digest();
		return digest;
	}//end DoDigest()
	
	
	
	//验证用户的密码是否正确
	public static LoginUserInfo VallidateUserPassword(AFUserInfo userInfo, byte[] encryptPassword) throws NoSuchAlgorithmException{
		Boolean isLogin = false;
		
		LoginUserInfo user = new LoginUserInfo();
		
		byte[] salt = new byte[12];
		System.arraycopy(encryptPassword, 0, salt, 0, 12);
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(salt);
		messageDigest.update(userInfo.getNonenpassword().getBytes());
		byte[] digest = messageDigest.digest();
		byte[] digestInDb = new byte[encryptPassword.length-12];
		System.arraycopy(encryptPassword, 12, digestInDb, 0, encryptPassword.length-12);
		if(Arrays.equals(digest, digestInDb)){
			isLogin = true;
		}
		
		user.setLogin(isLogin);
		user.setUserInfo(userInfo);
		
		return user;
	}//end VallidatePassword
	
	//验证安卓端加油人员的密码是否正确
	public static boolean VallidateWorkerPassword (String androidencryptPassword, byte[] encryptPassword) throws NoSuchAlgorithmException
	{	
		byte[] salt = new byte[12];
		System.arraycopy(encryptPassword, 0, salt, 0, 12);
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(salt);
		messageDigest.update(androidencryptPassword.getBytes());
		byte[] digest = messageDigest.digest();
		byte[] digestInDb = new byte[encryptPassword.length-12];
		System.arraycopy(encryptPassword, 12, digestInDb, 0, encryptPassword.length-12);
		if(Arrays.equals(digest, digestInDb))
		{
			return true;
		}
		return false;
		
	}
	
	
}//end class
