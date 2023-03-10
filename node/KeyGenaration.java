
import java.util.zip.*;
import java.util.zip.Checksum;
class  KeyGenaration
{
	static long secretKey=0;
	public static long groupKey(String data)
		{
			
			try
			{
				Checksum ch=new CRC32();

				byte[] b=data.getBytes();

				ch.update(b,0,b.length);

				 secretKey=ch.getValue();
				 
				 }
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return secretKey;
		}
	}
