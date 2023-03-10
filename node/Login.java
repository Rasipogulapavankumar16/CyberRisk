/****************************************************************/
/*                      Login	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
/**
 * Summary description for Login
 *
 */
public class Login extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JTextField jTextField1_uname;
	private JPasswordField jPasswordField1_pass;
	private JButton jButton1;
	private JButton jButton2;
	private JPanel contentPane;
	// End of variables declaration


	public Login()
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
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		jTextField1_uname = new JTextField();
		jPasswordField1_pass = new JPasswordField();
		jButton1 = new JButton();
		jButton2 = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		Font font=new Font("verdana",Font.BOLD+Font.ITALIC,20);

		//
		jLabel1.setText("UserName");
		jLabel1.setFont(font);
		jLabel1.setForeground(Color.white);
		//
		// jLabel2
		//
		jLabel2.setText("Password");
		jLabel2.setFont(font);
		jLabel2.setForeground(Color.white);
		//
		// jLabel7
		//
		jLabel7.setIcon(new ImageIcon("C:\\Program Files\\images\\Advanced_User_Accounts.png"));
		//
		// jLabel8
		//
		jLabel8.setIcon(new ImageIcon("C:\\Program Files\\images\\login.JPG"));
		//
		// jTextField1_uname
		//
		jTextField1_uname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_uname_actionPerformed(e);
			}

		});
		//
		// jPasswordField1_pass
		//
		jPasswordField1_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jPasswordField1_pass_actionPerformed(e);
			}

		});
		//
		// jButton1
		//
		jButton1.setBackground(new Color(68, 0, 30));
		jButton1.setIcon(new ImageIcon("C:\\Program Files\\images\\400_F_21088086_yEmmmsyv0T6PmfEkkbvIFhO7z1dmugrj_PXP.jpg"));
		jButton1.setText("Login");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		//
		// jButton2
		//
		jButton2.setBackground(new Color(68, 0, 30));
		jButton2.setIcon(new ImageIcon("C:\\Program Files\\images\\sssss.jpg"));
		jButton2.setText("New User");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		addComponent(contentPane, jLabel1, 223,72,129,30);
		addComponent(contentPane, jLabel2, 223,124,119,30);
		
		
		addComponent(contentPane, jTextField1_uname, 365,70,143,29);
		addComponent(contentPane, jPasswordField1_pass, 366,121,144,30);
		addComponent(contentPane, jButton1, 330,181,95,36);
		addComponent(contentPane, jButton2, 330,236,90,36);
		addComponent(contentPane, jLabel7, -3,-13,272,288);
		addComponent(contentPane, jLabel8, -5,-3,532,320);
		//
		// Login
		//
		this.setFont(font);
		this.setTitle("Login Form");
		this.setLocation(new Point(115, -2));
		this.setSize(new Dimension(535, 347));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setBackground(Color.lightGray);
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

	private void jPasswordField1_pass_actionPerformed(ActionEvent e)
	{
		System.out.println("\njPasswordField1_pass_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

		login();

	}

	private void jButton2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		new Register();
		this.hide();
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//


public void login()
	{
	
	//jTextField1_uname jPasswordField1_pass
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Socket st;
	ServerSocket sst;
	Vector v=new Vector();
	try
	{
	String name=jTextField1_uname.getText();
	String pass=jPasswordField1_pass.getText();
	v.add(name);
	v.add(pass);
	if(name.equals("")||pass.equals(""))
		{
		JOptionPane.showMessageDialog(this,"invalid username and password");

		}
		else
		{
	st=new Socket("localhost",7777);
	oos=new ObjectOutputStream(st.getOutputStream());
	oos.writeObject("login");
	oos.writeObject(v);
	

	ois=new ObjectInputStream(st.getInputStream());
	String str=(String)ois.readObject();
	Vector v5=new Vector();
	
	if(str.equals("Log"))
		{
		String ipaddr=(String)ois.readObject();
	String port =(String)ois.readObject();

	int portnum=Integer.parseInt(port);
		JOptionPane.showMessageDialog(this,"Login Success");
		new SensorNode(name,ipaddr,portnum);
	//this.hide();
		}
		else if(str.equals("loginfail"))
		{
			JOptionPane.showMessageDialog(this,"Login Failed");
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
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
			//		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new Login();
	}
//= End of Testing =


}
