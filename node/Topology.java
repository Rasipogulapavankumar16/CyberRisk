/****************************************************************/
/*                      Topology	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;
/**
 * Summary description for Topology
 *
 */
public class Topology extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel5; 
	private JTextField jTextField2_time;
	private JComboBox jComboBox1_Source;
	private JComboBox jComboBox2_destination;
	private JButton jButton1_save;
	private JButton jButton2_clear;
	private JButton jButton3_exit;
	private JPanel contentPane;
	Socket socket=null;
	ObjectInputStream ois=null;
	ObjectOutputStream oos=null;
	Vector nodes=new Vector();
	Vector nodeall=new Vector();
	Vector nodeafter=new Vector();
	String sin="SINK";
	
	// End of variables declaration


	public Topology()
	{
		super();
		initializeComponent();
		nodeall.add("-select-");
		nodeall.addAll(getNodeInfo());
//		nodeafter.add(sin);
//		if(nodeall.contains(sin))
//		{
//			nodeall.removeElement(sin);
//			nodeafter=nodeall;
//		}
		//
		// TODO: Add any constructor code after initializeComponent call
		//

		this.setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always regenerated
	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly.
	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder
	 * to retrieve your design properly in future, before revising this method.
	 */
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel5 = new JLabel(); 
		jTextField2_time = new JTextField();
		jComboBox1_Source = new JComboBox(nodeall);
		jComboBox2_destination = new JComboBox(nodeall);
		jButton1_save = new JButton();
		jButton2_clear = new JButton();
		jButton3_exit= new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		Font font=new Font("verdana",Font.BOLD+Font.ITALIC,14);

		jLabel1.setText("Source");
		jLabel1.setFont(font);
		//
		// jLabel2
		//
		jLabel2.setText("Destination");
		jLabel2.setFont(font);
		//
		// jLabel3
		//
		jLabel3.setText("Processing Time");
		jLabel3.setFont(font);
		//
		jLabel5.setIcon(new ImageIcon("C:\\Program Files\\images\\login.JPG")); 
		// jTextField2_time
		//
		jTextField2_time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField2_time_actionPerformed(e);
			}

		});
		//
		// jComboBox1_Source
		//
		jComboBox1_Source.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jComboBox1_Source_actionPerformed(e);
			}

		});
		//
		// jComboBox2_destination
		//
		jComboBox2_destination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jComboBox2_destination_actionPerformed(e);
			}

		});
		//
		// jButton1
		//
		jButton1_save.setText("Save");
		jButton1_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_save_actionPerformed(e);
			}

		});
		//
		// jButton2
		//
		jButton2_clear.setText("Clear");
		jButton2_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_clear_actionPerformed(e);
			}

		});
		//
		// jButton3
		//
		jButton3_exit.setText("Exit");
		jButton3_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_exit_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(10, 161, 240));
		addComponent(contentPane, jLabel1, 37,62,88,27);
		addComponent(contentPane, jLabel2, 37,107,94,26);
		addComponent(contentPane, jLabel3, 37,168,135,25);
		addComponent(contentPane, jTextField2_time, 179,171,100,30);
		addComponent(contentPane, jComboBox1_Source, 181,61,100,30);
		addComponent(contentPane, jComboBox2_destination, 179,110,100,30);
		addComponent(contentPane, jButton1_save, 51,245,83,28);
		addComponent(contentPane, jButton2_clear, 175,245,83,28);
		addComponent(contentPane, jButton3_exit, 290,246,83,28);
		addComponent(contentPane, jLabel5, -4,-14,440,361);
		//
		// Topology
		//
		this.setTitle("Topology Construction");
		this.setLocation(new Point(119, -1));
		this.setSize(new Dimension(437, 350));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void jTextField2_time_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField2_time_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jComboBox1_Source_actionPerformed(ActionEvent e)
	{
		System.out.println("\njComboBox1_Source_actionPerformed(ActionEvent e) called.");
		
		Object o = jComboBox1_Source.getSelectedItem();
		System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
		// TODO: Add any handling code here for the particular object being selected
		
	}

	private void jComboBox2_destination_actionPerformed(ActionEvent e)
	{
		System.out.println("\njComboBox2_destination_actionPerformed(ActionEvent e) called.");
		
		Object o = jComboBox2_destination.getSelectedItem();
		System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
		// TODO: Add any handling code here for the particular object being selected
		
	}

	private void jButton1_save_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
save();
	}

	private void jButton2_clear_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		clear();

	}

	private void jButton3_exit_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton3_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		this.dispose();

	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//



public Vector getNodeInfo()
	{
	 try
	 {
		socket=new Socket(GetAddress.getIp(),7777);
		oos=new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject("Route");
		ois=new ObjectInputStream(socket.getInputStream());
		nodes=(Vector)ois.readObject();
 
  System.out.println("*******Nodes*****"+nodes);
	 }
	 catch (Exception ex)
	 {
		 ex.printStackTrace();
	 }
	 return nodes;
	}




public void save()
	{
//jComboBox1_Source jComboBox2_destination jTextField2_time
String source=jComboBox1_Source.getSelectedItem().toString();
String time=jTextField2_time.getText();

String destination=jComboBox2_destination.getSelectedItem().toString();
if(source.equals("")||destination.equals("")||time.equals(""))
		{
	JOptionPane.showMessageDialog(this,"Enter all the field");
		}
		else if(source.equals(destination))
		{
		JOptionPane.showMessageDialog(this,"Source and destination are same");
		}
		else if(source.equals("-select-")||destination.equals("-select-"))
		{
			JOptionPane.showMessageDialog(this,"Select proper source and destionation");
		}
		else
		{
			try
			{
				socket=new Socket(GetAddress.getIp(),7777);
			oos=new ObjectOutputStream(socket.getOutputStream());
			Vector nodes1=new Vector();
			nodes1.add(source);
			nodes1.add(destination);
			nodes1.add(time);
			oos.writeObject("Link");
			
			oos.writeObject(nodes1);

			ois=new ObjectInputStream(socket.getInputStream());
				String getText=ois.readObject().toString();
					if(getText.equals("LinkOk"))
				{
						JOptionPane.showMessageDialog(this,"Links Are created");
						clear();
				}
				else if(getText.equals("Available"))
				{
					JOptionPane.showMessageDialog(this,"Already Available");
					clear();
				}
			
			}
			catch (Exception exe)
			{
				exe.printStackTrace();
			}
			
		}



	}







//--------->Clear Button----------------
public void clear()
	{
	jTextField2_time.setText("");
				jComboBox1_Source.setSelectedIndex(0);
				jComboBox2_destination.setSelectedIndex(0);

	}























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new Topology();
	}
//= End of Testing =
	

}
