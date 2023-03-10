import java.io.*;
class  GetAddress
{
	static String address="";
	public static String getIp()
	
	{
	
	try
	{
		FileInputStream fin=new FileInputStream("ip.txt");
		byte b[]=new byte[fin.available()];
		fin.read(b);
		address=new String(b);
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
		return address;
		}
}
