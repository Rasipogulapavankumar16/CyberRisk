
import java.security.*;
public class MAC {

	public MAC() {
		
	}

	static String s="";
	public static String getMAC(String s1){
		try{
			
			s=s1;
	 
	    byte[] plainText = s.getBytes("UTF8");
	  
	    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	  
	    messageDigest.update( plainText);
	    
	    s=new String( messageDigest.digest(), "UTF8");
	  }
	  catch(Exception e)
		  {
		  e.printStackTrace();
	  }
	  return s;
	}
	}
