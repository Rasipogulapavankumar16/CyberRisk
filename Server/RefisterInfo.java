/****************************************************************/
/*                      Registerinfo	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 * Summary description for Registerinfo
 *
 */
public class RefisterInfo extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JPanel contentPane;
	DefaultTableModel dtm=new DefaultTableModel();
	String column[]={"Name","IPAddress","PortNumber","Time"};
	// End of variables declaration


	public RefisterInfo()
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
		jTable1 = new JTable(dtm);
		dtm.setColumnIdentifiers(column);
		jScrollPane1 = new JScrollPane();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setText("Register Information");
		Font font=new Font("Verdana",Font.BOLD+Font.ITALIC,30);
		jLabel1.setFont(font);
		jLabel1.setForeground(new Color(95,5,115));
		//
		// jTable1
		//
	//	jTable1.setModel(new DefaultTableModel(4, 4));
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(jTable1);
		//
		// contentPane
		//
		contentPane.setLayout(null);
		addComponent(contentPane, jLabel1, 120,14,357,44);
		addComponent(contentPane, jScrollPane1, 138,136,329,184);
		//
		// Registerinfo
		//
		this.setTitle("Registerinfo - extends JFrame");
		this.setLocation(new Point(93, 1));
		this.setSize(new Dimension(629, 400));
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
		new RefisterInfo();
	}
//= End of Testing =


}
