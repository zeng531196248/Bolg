package Test;


import org.apache.commons.codec.digest.Md5Crypt;

public class Md5 {

	public static void main(String[] args) throws Exception {
	String apr1Crypt = Md5Crypt.apr1Crypt("123456", "tbnb1.cn");
	System.out.println(apr1Crypt);
		
	}
	
	
}
