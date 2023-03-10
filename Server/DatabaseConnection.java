import java.sql.*;
public class DatabaseConnection
{
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/vampire";
	static Connection con=null;
	
	public DatabaseConnection()
	{
	}

	public static Connection getConnection()
	{
	try
	{
		con=DriverManager.getConnection(url,"root","root123");

	}
	catch (SQLException sqle)
	{
		sqle.printStackTrace();
	}
	return con;
	}
	static
	{
		try
		{
			Class.forName(driver);
		}
		catch (ClassNotFoundException cf)
		{
			cf.printStackTrace();
		}
	}
}
