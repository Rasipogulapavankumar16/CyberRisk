import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
class MainServer
{

	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
	Socket ss=null;
	ServerSocket sst=null;
	ObjectInputStream ois;
	String nodename;
	ObjectOutputStream oos;
	Vector vv=new Vector();
	Vector vvr=new Vector();
	String tabvalue1="";
	String attack="NO";
	String attackyes="YES";
	String attacktype="";
	String weightValue="";
	String distance="";
	String xpath="";

	int energy;
	
	static int diatanceupdate;
	
	int len;
	int i;
Vector paths = new Vector();
	public MainServer()
	{

	try
	{  
		new Progressbar();
		//new MainServer1();
		con=DatabaseConnection.getConnection();
		st=con.createStatement();
		sst=new ServerSocket(7777);
		
		System.out.println("*********Server Start******************");
		while (true)
		{
			ss=sst.accept();
			oos=new ObjectOutputStream(ss.getOutputStream());
			ois=new ObjectInputStream(ss.getInputStream());
			
			String getText=(String)ois.readObject();
			System.out.println(getText);
			if (getText.equals("Register"))
			{
				System.out.println("test");
				vvr=(Vector)ois.readObject();
				 System.out.println("----------"+vvr);
			     String name1=vvr.get(0).toString();
				 String ipaddr1=vvr.get(1).toString();
				 String port1=vvr.get(2).toString();
				System.out.println(vvr.get(0)+"\t"+vvr.get(1)+"\t"+vvr.get(2));
				rs=st.executeQuery("select * from logininfo where name='"+vvr.get(0)+"' and portnumber='"+vvr.get(2)+"' ");
				if(rs.next())
				{
					oos.writeObject("alreadyregister");
				}
				else
				{

					 i=st.executeUpdate("insert into logininfo(name,ipaddress,portnumber,attack,actualenergy,energy) values('"+vvr.get(0).toString()+"','"+vvr.get(1).toString()+"','"+vvr.get(2).toString()+"','"+attack+"','"+1000	+"','"+1000+"')  ");

					 if(i!=0)
					{
							oos.writeObject("ok");
					}	   
			   }
			   oos.writeObject("ok");
					
		}

			else if(getText.equals("login"))
			{
				vv=(Vector)ois.readObject();
				Vector v4=new Vector();
				System.out.println(vv.get(0)+"\t"+vv.get(1));
				rs=st.executeQuery("select * from logininfo where name='"+vv.get(0).toString()+"'and portnumber='"+vv.get(1).toString()+"' ");
				if(rs.next())
				{
					
					oos.writeObject("Log");
					oos.writeObject(rs.getString(2));
					oos.writeObject(rs.getString(3));
				}
				else{
					oos.writeObject("loginfail");
				}
			}

//-------------------------Route Construction-------------
			else if(getText.equals("Route"))
			{
			Vector allnodes=new Vector();
			rs=st.executeQuery("select * from logininfo");
			while(rs.next())
				{
				allnodes.add(rs.getString(1));
			}

oos.writeObject(allnodes);
			}

		
		//.--------------------------Insert the routing-----------
		else if(getText.equals("Link"))
			{
			Vector vv1=(Vector)ois.readObject();
			System.out.println(vv1.get(0)+"\t"+vv1.get(1)+"\t"+vv1.get(2));
				
				rs=st.executeQuery("select * from topology where source='"+vv1.get(0).toString()+"'and destination='"+vv1.get(1).toString()+"'   ");
			if(rs.next())
			{
				oos.writeObject("Available");
			}
			else 
			{
			
				int  len=st.executeUpdate("insert into topology values('"+vv1.get(0).toString()+"','"+vv1.get(1).toString()+"','"+vv1.get(2).toString()+"')  ");
			
				oos.writeObject("LinkOk");
			}
		}



//---------------------------getNodes---------------------------//

else if (getText.equals("getNodes"))
{

	String node=(String)ois.readObject();
	Vector sendnode=new Vector();
	rs=st.executeQuery("select * from logininfo where name!='"+node+"'");
	while(rs.next())
	{
	sendnode.add(rs.getString(1));

	}
	oos.writeObject(sendnode);
}



//-------------------------checkAvaillabel path--------------//
else if(getText.equals("checkavailablep"))
			{
System.out.println("********************************");
				Vector list=new Vector();
				 list =(Vector)ois.readObject(); 
				System.out.println("%%%%%%%%%%%%%%%%%%%%%");
				System.out.println(list);
				int weight=0;

				String source = list.get(0).toString();
				System.out.println("***************"+source);
				String desti = list.get(1).toString();
				System.out.println("*************"+desti);
				

				PathInfo path = new PathInfo();
			    paths =path.getPath(source,desti);
				
			st.execute("delete from pathinfo");
				for(int i=0;i<paths.size();i++) {
				String[] snodetemp=paths.get(i).toString().split("=>");
				
				for(int j=0;j<snodetemp.length-1;j++)
				{
				 rs=st.executeQuery("select * from topology where source='"+snodetemp[j]+"' and destination='"+snodetemp[j+1]+"'");
				if(rs.next()){
				weight=weight+rs.getInt(3);
				}
			
				}			
			st.executeUpdate("insert into pathinfo values('"+paths.get(i).toString()+"',"+weight+")");		
		
		}

				

					oos.writeObject("AvailPath");

					oos.writeObject(paths);
					oos.writeObject(weight);
					System.out.println("((((((((((((((((((((((paths)))))))))))))))))))))))))"+paths);
			}



						///////////////////////////Efficient path////////////////


						else if(getText.equals("Efficientpath"))
						{
				
				String effiPath="";
				int energy=0;
				rs=st.executeQuery("select * from pathinfo");
				Vector value=new Vector();
					Vector path=new Vector();
				while(rs.next())
							{
				 energy=rs.getInt(2);
				 value.add(energy);

				
							}
							Collections.sort(value);
							for(int i=0;i<value.size();i++){
								System.out.println(Integer.parseInt(value.get(i).toString()));
								rs=st.executeQuery("select * from pathinfo where time='"+Integer.parseInt(value.get(i).toString())+"'");
								if(rs.next()){
									effiPath=rs.getString(1);
								
								}
								if(effiPath.length()>4){
									System.out.println("======>"+effiPath);
									break;
								
								}
							
							}
							oos.writeObject(effiPath);

						
						}	



	///////////////////////////Destination///////////////////////////////////////////////////////////////////////////////

					else if(getText.equals("Desti"))
			{
					System.out.println("******************Destination**********************");

					String path=(String)ois.readObject();
					String destination=(String)ois.readObject();
					String attack=(String)ois.readObject();
					String apath="";
					String attak="";
					String attakTyp="";
					String atNode="";

					System.out.println(path+"\t"+destination+"\t"+attack);
					System.out.println("******"+path);
					System.out.println("******"+destination);

					Vector v3=new Vector();
					Vector vstretch=new Vector();
					String [] str=path.split("=>");

					for(int i=0;i<str.length;i++)
					{
						rs=st.executeQuery("select * from logininfo where name='"+str[i]+"'");
						if(rs.next())
						{
							attak=rs.getString(5);
							attakTyp=rs.getString(6);
							energy=rs.getInt(7);
							
								diatanceupdate=energy-20;
								System.out.println("&&&&&&&&&&&&&&&&********"+diatanceupdate);
								st.executeUpdate("update logininfo set energy='"+diatanceupdate+"' where name='"+str[i]+"'");
						
						}
			
						if(attak.equals("YES"))
						{
							if(attakTyp.equals("stretch"))
							{
								String epath="";
								int dis=0;
								rs=st.executeQuery("select * from pathinfo");
								Vector value=new Vector();
								Vector vpath=new Vector();
								while(rs.next())
								{
									dis=rs.getInt(2);
									value.add(dis);
								}
								Collections.sort(value);
								for(int a=0;a<value.size();a++)
								{
									rs=st.executeQuery("select * from pathinfo where time='"+Integer.parseInt(value.get(a).toString())+"'");						
									if(rs.next())
									{
										epath=rs.getString(1);
									}
								}
								System.out.println(epath);
								xpath=epath;
								System.out.println("***path change***"+xpath);
								System.out.println("******"+destination);

								rs=st.executeQuery("select * from logininfo where name='"+destination+"'");
								if (rs.next())
								{
									String ip=rs.getString(2);
									int port =rs.getInt(3);
										energy=rs.getInt(8);
							String [] str1=xpath.split("=>");
							System.out.println("*****************str1"+str1.length+"********"+xpath);
					for(int en=0;en<str1.length;en++){
						rs=st.executeQuery("select * from logininfo where name='"+str1[en]+"'");
						System.out.println("********str1[i]****************"+str1[en]);
					//	if(rs.next())
					if(rs.next())
						{
						//	System.out.println("********str1[i]****************"+str1[i]);
							energy=rs.getInt(8);
							
								diatanceupdate=energy-20;
								System.out.println("&&&&&&&&&&&&&&&&********"+diatanceupdate);
								st.executeUpdate("update logininfo set energy='"+diatanceupdate+"' where name='"+str1[en]+"'");
						}
					}
								
									vstretch.add(ip);
									vstretch.add(port);
									vstretch.add(xpath);
								}
								oos.writeObject("switchOn");
								oos.writeObject(vstretch);
								break;
							}
							else if(attakTyp.equals("carousel"))
							{
									Vector carousel=new Vector();
					Vector sourcecarousel=new Vector();
					String xip="";
					String xport="";
					String desti1="";
					
					String [] str1=path.split("=>");
					for(int x=0;x<=str1.length-1;x++)
					{
						rs=st.executeQuery("select * from logininfo where name='"+str1[x]+"' ");
						if(rs.next())
						{
							 xip=rs.getString(2).toString();
							xport=rs.getString(3).toString();
							

							sourcecarousel.add(xip);
							sourcecarousel.add(xport);
						
						int pathlength=str1.length-2;
						int pathlength1=str1.length-3;
						System.out.println("*************the value*********"+pathlength1+"*******"+pathlength);
						destination=str1[pathlength].toString();
						 desti1=str1[pathlength1].toString();
						System.out.println("*************the value*********"+desti1);
						}
						
						
					}
						System.out.println("**********&&&&&&&&&&&&&***********"+destination);
						
							rs=st.executeQuery("select * from logininfo where name='"+destination+"'");
							if(rs.next())
					{
														
								String ipcarousel=rs.getString(2);
								System.out.println("***************carouserlport*******"+ipcarousel);
								int portcarousel=rs.getInt(3);
								System.out.println("*********port*************"+portcarousel);
								energy=rs.getInt(8);
							
								diatanceupdate=energy-40;
								System.out.println("&&&&&&&&&&&&&&&&********"+diatanceupdate);
								st.executeUpdate("update logininfo set energy='"+diatanceupdate+"' where name='"+str[i]+"'");
								carousel.add(ipcarousel);
								carousel.add(portcarousel);
								carousel.add(path);
								}

								rs=st.executeQuery("select * from logininfo where name='"+desti1+"' ");
								if (rs.next())
								{
								int enecarousel=rs.getInt(8);
								diatanceupdate=energy-40;
								System.out.println("&&&&&&&&&&&&&&&&********"+diatanceupdate);
								st.executeUpdate("update logininfo set energy='"+diatanceupdate+"' where name='"+desti1+"'");
								}


								System.out.println("**********Destination********"+xip);
							System.out.println("*********Destination*********"+xport);
								oos.writeObject("carouse");
								oos.writeObject(carousel);
								oos.writeObject(sourcecarousel);
							
				
							}
						}
						else
						{
							rs=st.executeQuery("select * from logininfo where name='"+destination+"'");
							if (rs.next())
							{
								String ip=rs.getString(2);
								int port =rs.getInt(3);

								v3.add(ip);
								v3.add(port);
								v3.add(path);
							}
						}
					}
					oos.writeObject("switchOn1");
					oos.writeObject(v3);
				}





//					for(int i=0;i<str.length-1;i++)
//				{
//						rs=st.executeQuery("select * from logininfo where name='"+str[i]+"'");
//						if(rs.next())
//				    	{
//							String strattack=rs.getString(5);			
//							System.out.println("*****************attacktype"+strattack);
//							rs=st.executeQuery("select * from topology where source='"+str[i]+"'");
//								if(rs.next())
//						{ 
//								distance=rs.getString(3);
//								System.out.println("**&&&&**************"+distance);
//								 distanceint=Integer.parseInt(distance);
//								energyupdate=distanceint*4;
//								energy=rs.getInt(4);
//								System.out.println("&&&&&&&&&&&&&&&&********"+energy);
//								diatanceupdate=energy-energyupdate;
//								System.out.println("&&&&&&&&&&&&&&&&********"+diatanceupdate);
//								st.executeUpdate("update energylevel set energy='"+diatanceupdate+"' where node='"+str[i]+"'");
//						}
//							if(strattack.equals("YES"))
//						{
//								System.out.println("///////////////////attacketnode///////////////////////"+str[i]);
//								rs=st.executeQuery("select * from logininfo where name='"+str[i]+"'");
//								if(rs.next())
//							{
//								String attack1type=rs.getString(6);
//								System.out.println("********attacktype**********"+attack1type);
//								if(attack1type.equals("stretch"))
//							{
//								String epath="";
//								int dis=0;
//								rs=st.executeQuery("select * from pathinfo");
//								Vector value=new Vector();
//								Vector vpath=new Vector();
//								while(rs.next())
//								{
//									dis=rs.getInt(2);
//									value.add(dis);
//								}
//								Collections.sort(value);
//								for(int a=0;a<value.size();a++)
//								{
//									rs=st.executeQuery("select * from pathinfo where time='"+Integer.parseInt(value.get(a).toString())+"'");						
//									if(rs.next())
//									{
//										epath=rs.getString(1);
//									}
//								}
//								System.out.println(epath);
//								xpath=epath;
//								System.out.println("***path change***"+xpath);
//								System.out.println("******"+destination);
//					
////								String [] strx=xpath.split("=>");
////								for(int ix=0;ix<strx.length;ix++)
////								{
////									rs=st.executeQuery("select * from logininfo where name='"+strx[ix]+"'");
////									if(rs.next())
////									{
//											rs=st.executeQuery("select * from logininfo where name='"+destination+"'");
//											if (rs.next())
//											{
//													String ip=rs.getString(2);
//													System.out.println(ip);
//													int port =rs.getInt(3);
//													System.out.println(port);
//													vstretch.add(ip);
//													vstretch.add(port);
//													vstretch.add(xpath);
//											}
////							
////							//oos.writeObject(str[i]);
////					}
////					
////				}
//											oos.writeObject("switchOn");
//											System.out.println("************************SWITCH ON************************");
//											System.out.println(vstretch);
//											oos.writeObject(vstretch);
//									}
//									else if(attack1type.equals("carousel"))
//									{
//									}
//							}
//						}
////						else if(strattack.equals("NO"))
////						{
////								rs=st.executeQuery("select * from logininfo where name='"+destination+"'");
////								if (rs.next())
////								{
////									String ip=rs.getString(2);
////									System.out.println(ip);
////									int port =rs.getInt(3);
////									System.out.println(port);
////									v3.add(ip);
////									v3.add(port);
////									v3.add(xpath);
////								}
////								oos.writeObject("switchOn1");
////								System.out.println("************************SWITCH ON-1************************");
////								System.out.println(v3);
////								oos.writeObject(v3);
////						}
//						else
//						{
//						}
//							rs=st.executeQuery("select * from logininfo where name='"+destination+"'");
//							if (rs.next())
//							{
//								String ip=rs.getString(2);
//								System.out.println(ip);
//								int port =rs.getInt(3);
//								System.out.println(port);
//								v3.add(ip);
//								v3.add(port);
//								v3.add(path);
//							}
//							oos.writeObject("switchOn1");
//							oos.writeObject(v3);
////						}
//					}
//				}
//			}
			else if (getText.equals("logininfo1"))
			{
				Vector v4=(Vector)ois.readObject();
				System.out.println(v4);
				rs=st.executeQuery("select * from loginmaintain where name='"+v4.get(0)+"' and portnumber='"+v4.get(2)+"' ");
				{
					if (rs.next())
					{
						oos.writeObject("Nodealready");
					}
					else
					{
							int y=st.executeUpdate("insert into loginmaintain(name,ipaddress,portnumber) values('"+v4.get(0).toString()+"','"+v4.get(1).toString()+"','"+v4.get(2).toString()+"')");
							oos.writeObject("dataStored");
					}

				}

			}
			else if(getText.equals("displayTable"))	 
			{
				Vector tablevla=new Vector();
				Vector  tablevla1=new Vector();				
				rs=st.executeQuery("select * from pathinfo");
				while(rs.next())
				{	
					 tablevla.add(rs.getString(1));
					// tablevla.add(rs.getString(2).toString());					
				}
				oos.writeObject("tablevaleDisplay");
				System.out.println("***************************"+tablevla);
				oos.writeObject(tablevla);			
			}
			else if(getText.equals("carouselattacker"))
			{
				String carouselatt=ois.readObject().toString();
				nodename=ois.readObject().toString();
				System.out.println(carouselatt+" "+nodename);
				if(carouselatt.equals(""))
				{
				}
				else
				{
					st.executeUpdate("update logininfo set attack='"+attackyes+"',attacktype='"+carouselatt+"'where name='"+nodename+"' ");
				}
			}


			else if(getText.equals("getEfficientpath"))
			{
				Vector efficient=new Vector();
				rs=st.executeQuery("select * from pathinfo");
				while(rs.next())
				{
					efficient.add(rs.getString(1));
				}
				oos.writeObject("setEfficientpath");
				oos.writeObject(efficient);
				oos.writeObject(nodename);
				System.out.println("*******efii********"+efficient+"*************"+nodename);

			}










		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}

}

	public static void main(String[] args) 
	{
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		
	}
	new MainServer();
}
}
