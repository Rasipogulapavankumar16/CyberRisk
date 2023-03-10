/****************************************************************/
/*                      MainServer	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Summary description for MainServer
 *
 */
public class MainServer1 extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
		private JLabel jLabel2; 
 	private JLabel jLabel4; 
 	private JButton jButton1_LoginInfo; 
 	private JButton jButton2_registerinfo; 
 	private JButton jButton3_topologyinfo; 
 	private JButton jButton4_availableinfo;
	private JButton jButton5_exit; 
	private JPanel contentPane;
	// End of variables declaration


	public MainServer1()
	{
		super();
		initializeComponent();
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
 		jLabel4 = new JLabel(); 
 		jButton1_LoginInfo = new JButton(); 
 		jButton2_registerinfo = new JButton(); 
 		jButton3_topologyinfo = new JButton(); 
 		jButton4_availableinfo = new JButton(); 
		jButton5_exit = new JButton(); 
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setIcon(new ImageIcon("C:\\Program Files\\images\\serverback.jpg"));
		//
		// jButton1
		//
		
		jLabel2.setIcon(new ImageIcon("C:\\Program Files\\images\\cooltext1219767914.png")); 
 		// 
 		// jLabel4 
 		// 
 		jLabel4.setIcon(new ImageIcon("C:\\Program Files\\images\\server-Vista-icon.png")); 
 		jLabel4.setText("jLabel4"); 
 		// 
 		// jButton1_LoginInfo 
 		// 
 		jButton1_LoginInfo.setText("Login Information"); 
 		jButton1_LoginInfo.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_LoginInfo_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton2_registerinfo 
 		// 
 		jButton2_registerinfo.setText("RegisterInformation"); 
 		jButton2_registerinfo.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton2_registerinfo_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton3_topologyinfo 
 		// 
 		jButton3_topologyinfo.setText("Topology Information"); 
 		jButton3_topologyinfo.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton3_topologyinfo_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton4_availableinfo 
 		// 
 		jButton4_availableinfo.setText("Available Path Information"); 
 		jButton4_availableinfo.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton4_availableinfo_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
			// jButton5_exit 
 		// 
 		jButton5_exit.setText("Exit"); 
 		jButton5_exit.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton5_exit_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
		// contentPane
		//
		contentPane.setLayout(null);
	
		addComponent(contentPane, jLabel2, 54,16,478,53); 
 		
 		addComponent(contentPane, jButton1_LoginInfo, 275,155,232,47); 
 		addComponent(contentPane, jButton2_registerinfo, 275,102,230,48); 
 		addComponent(contentPane, jButton3_topologyinfo, 272,205,233,46); 
 		addComponent(contentPane, jButton4_availableinfo, 273,254,232,46); 
		addComponent(contentPane, jButton5_exit, 328,372,83,28);	
 	addComponent(contentPane, jLabel4, 20,41,325,399); 
		addComponent(contentPane, jLabel1, -3,-1,594,471);
		
		//
		// MainServer
		//
		this.setTitle("MainServer");
		this.setLocation(new Point(95, 2));
		this.setSize(new Dimension(600, 503));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

		private void jButton1_LoginInfo_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton1_LoginInfo_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton2_registerinfo_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton2_registerinfo_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton3_topologyinfo_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton3_topologyinfo_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton4_availableinfo_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton4_availableinfo_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	// 
		private void jButton5_exit_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton5_exit_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  dispose();
 	}
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  




























 

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
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new MainServer1();
	}
//= End of Testing =


}
