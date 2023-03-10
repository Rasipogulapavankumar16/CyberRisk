/****************************************************************/
/*                      Pathinfo	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 * Summary description for Pathinfo
 *
 */
public class Pathinformat extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JPanel contentPane;
	DefaultTableModel dtm=new DefaultTableModel();
	String column[]={"PathInfo","Time"};
	// End of variables declaration


	public Pathinformat()
	{
		super();
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//

		this.setVisible(true);
	}


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
		jLabel1.setText("Available path Information");
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
		addComponent(contentPane, jLabel1, 100,24,385,63);
		addComponent(contentPane, jScrollPane1, 94,172,426,133);
		//
		// Pathinfo
		//
		this.setTitle("Pathinfo - extends JFrame");
		this.setLocation(new Point(103, 2));
		this.setSize(new Dimension(601, 413));
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
		new Pathinformat();
	}
//= End of Testing =


}
