/****************************************************************/
/*                      Progressbar	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import javax.swing.*;
/**
 * Summary description for Progressbar
 *
 */
public class Progressbar extends JFrame
{
	// Variables declaration
	private JProgressBar jProgressBar1;
	private JLabel jLabel1; 
	private JPanel contentPane;
	// End of variables declaration


	public Progressbar()
	{
		super();
		initializeComponent();
		display();
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
		jProgressBar1 = new JProgressBar();
		jLabel1 = new JLabel(); 
		contentPane = (JPanel)this.getContentPane();

		//
		// jProgressBar1
		Font font=new Font("verdana",Font.BOLD+Font.ITALIC,24);
		jLabel1.setForeground(new Color(97, 4, 140)); 
		jLabel1.setText("Main Server Started");	
		jLabel1.setFont(font);
		//
		jProgressBar1.setStringPainted(true);
		//
		// contentPane
		//
		contentPane.setLayout(null);
		addComponent(contentPane, jLabel1, 46,4,400,27); 
		addComponent(contentPane, jProgressBar1, 4,29,415,55);
		//
		// Progressbar
		//
		this.setTitle("Progressbar - extends JFrame");
		this.setLocation(new Point(104, 15));
		this.setSize(new Dimension(438, 131));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

public void display()
	{
	Thread th=new Thread(new Runnable()
		{
		int i=0;
		public void run()
			{
		while(i<=101)
			{
jProgressBar1.setValue(i);
			i++;
			try
			{
				Thread.sleep(20);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			}
			dispose();
			}
		});	
		th.start();
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
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new Progressbar();
	}
//= End of Testing =


}
