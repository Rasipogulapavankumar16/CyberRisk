/****************************************************************/
/*                      Register	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Summary description for Register
 *
 */
public class Register extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JTextField jTextField1_uname;
	private JTextField jTextField2_ip;
	private JTextField jTextField3_port;
	private JButton jButton1_submit;
	private JButton jButton2_clear;
	private JButton jButton3_back;
	private JPanel contentPane;
	// End of variables declaration


	public Register()
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
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel7 = new JLabel(); 
		jLabel8 = new JLabel(); 
		jTextField1_uname = new JTextField();
		jTextField2_ip = new JTextField();
		jTextField3_port = new JTextField();
		jButton1_submit = new JButton();
		jButton2_clear = new JButton();
		jButton3_back = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		Font font=new Font("verdana",Font.BOLD+Font.ITALIC,19);
		Font font1=new Font("verdana",Font.BOLD+Font.ITALIC,14);

		jLabel1.setIcon(new ImageIcon("C:\\Program Files\\images\\cooltext1159944479.png"));
		
		//
		// jLabel2
		//
		jLabel2.setText("UserName");
		jLabel2.setFont(font);
		//
		// jLabel3
		//
		jLabel3.setText("IP Address");
		jLabel3.setFont(font);
		//
		// jLabel4
		//
		jLabel4.setText("Port number");
		jLabel4.setFont(font);
		//
		// jTextField1_uname
		//
				// jLabel7 
 		// 
 		jLabel7.setIcon(new ImageIcon("C:\\Program Files\\images\\hello.png")); 
 		// 
 		// 
		jLabel8.setIcon(new ImageIcon("C:\\Program Files\\images\\backgro.jpg")); 
		//
		//
		jTextField1_uname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_uname_actionPerformed(e);
			}

		});
		//
		// jTextField2_ip
		//
		jTextField2_ip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField2_ip_actionPerformed(e);
			}

		});
		//
		// jTextField3_port
		//
		jTextField3_port.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField3_port_actionPerformed(e);
			}

		});
		//
		// jButton1_submit
		//
		jButton1_submit.setText("Submit");
		jButton1_submit.setFont(font1);
		jButton1_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_submit_actionPerformed(e);
			}

		});
		//
		// jButton2_clear
		//
		jButton2_clear.setText("Clear");
		jButton2_clear.setFont(font1);
		jButton2_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_clear_actionPerformed(e);
			}

		});
		//
		// jButton3_back
		//
		jButton3_back.setText("Back");
		jButton3_back.setFont(font1);
		jButton3_back.setBackground(new Color(33, 235, 213));
		jButton3_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_back_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(33, 235, 213));
		addComponent(contentPane, jLabel1, 72,6,547,87);
		addComponent(contentPane, jLabel2, 11,145,142,29);
		addComponent(contentPane, jLabel3, 11,206,157,29);
		addComponent(contentPane, jLabel4, 11,267,141,27);
		addComponent(contentPane, jTextField1_uname, 163,145,153,29);
		addComponent(contentPane, jTextField2_ip, 163,204,155,29);
		addComponent(contentPane, jTextField3_port, 163,264,155,29);
		addComponent(contentPane, jButton1_submit, 14,361,93,28);
		addComponent(contentPane, jButton2_clear, 124,362,93,28);
		addComponent(contentPane, jButton3_back, 234,363,93,28);
		addComponent(contentPane, jLabel7,300,124,612,403); 
		addComponent(contentPane, jLabel8,0,0,612,557); 
		//
		// Register
		//
		this.setTitle("Register");
		this.setLocation(new Point(82, 2));
		this.setSize(new Dimension(604, 557));
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
	private void jTextField1_uname_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_uname_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jTextField2_ip_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField2_ip_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jTextField3_port_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField3_port_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jButton1_submit_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_submit_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		//jTextField1_uname jTextField1_ip jTextField1_port

		submit();


	}

	private void jButton2_clear_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_clear_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

		jTextField1_uname.setText("");
		jTextField2_ip.setText("");
		jTextField3_port.setText("");

	}

	private void jButton3_back_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton3_back_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
new Login();
this.hide();
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//




public void submit()
	{
	Socket st;
	ServerSocket sst;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Vector v=new Vector();
	try
	{
		
		String name=jTextField1_uname.getText().trim();
		String ipaddress=jTextField2_ip.getText().trim();
		String port=jTextField3_port.getText().trim();

		if(name.equals("")||ipaddress.equals("")||port.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Enter all the Field");
		}

		else
		{
			st=new Socket("localhost",7777);
			oos=new ObjectOutputStream(st.getOutputStream());
			
			v.add(name);
			v.add(ipaddress);
			v.add(port);
           oos.writeObject("Register");
			//oos.writeObject("test");
			oos.writeObject(v);
			System.out.println(v);
			ois=new ObjectInputStream(st.getInputStream());
			String get=(String)ois.readObject();
			if(get.equals("ok"))
			{
				JOptionPane.showMessageDialog(this,"success");
			}
			else if(get.equals("alreadyregister"))
			{
				JOptionPane.showMessageDialog(this,"Registration failed check the Field details");
			}
		}





	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	

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
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new Register();
	}
//= End of Testing =


}
