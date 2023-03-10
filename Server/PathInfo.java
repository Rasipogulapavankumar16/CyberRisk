
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Collections;
import java.util.List;

public class PathInfo {
	
	static Vector tempList=new Vector();
	static List temp=new ArrayList();
	static Statement st=null;
	String sourceNode;
	String desNode;	
	String weight;

	Connection con=null;	

	public PathInfo(){
		try
		{
           
		   DatabaseConnection dbc=new DatabaseConnection();
			
			con=dbc.getConnection();
			
			st=con.createStatement();
			
			int i=st.executeUpdate("delete from pathinfo");
			
			if(tempList.size()>0)
			{
				tempList.clear();
			}
		}
		catch(Exception e)
			{
			e.printStackTrace();
		}
	}
	
	
	
	public Vector getPath(String sourceNode,String end){
		
		List endList=new ArrayList();	

		String[] snodetemp=sourceNode.split("=>");
		String snode1=snodetemp[snodetemp.length-1];	
	
		try{			
			ResultSet rs=st.executeQuery("select * from topology where source='"+snode1+"' ");

			while(rs.next())
				{
			endList.add(rs.getString(2));	
			
			}
					
			for (int i=0;i<endList.size();i++)
			{
				String path=endList.get(i).toString();
				if(end.equals(path)){
				tempList.add(sourceNode+"=>"+path);		
			}
			else
			{					
				List checkpre=new ArrayList();
				Collections.addAll(checkpre, snodetemp);
				if(!checkpre.contains(path))
				{					
					temp.add(sourceNode+"=>"+path);
				}

			}
		}
			
		if(temp.size()!=0)
		{
			String snode=temp.get(0).toString();
			temp.remove(0);
			getPath(snode,end);
		}
			
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	return tempList;
}





	public void setPathValue(Vector tempList)
		{
		try
		{
			st.execute("delete from PathInfo");
		  for(int i=0;i<tempList.size();i++) {
			String[] snodetemp=tempList.get(i).toString().split("=>");
			int weight=0;
			for(int j=0;j<snodetemp.length-1;j++){
			ResultSet resultSet=st.executeQuery("select * from topology where source='"+snodetemp[j]+"' and destination='"+snodetemp[j+1]+"'");
			if(resultSet.next()){
				
			}
			
			}			
			st.executeUpdate("insert into pathinfo values('"+tempList.get(i).toString()+"','0')");	
			
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
}
