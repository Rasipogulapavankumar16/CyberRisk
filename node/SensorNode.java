/****************************************************************/
/*                      SensorNode	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
/**
 * Summary description for SensorNode
 *
 */
public class SensorNode extends JFrame implements Runnable
{
	// Variables declaration
	private JTabbedPane jTabbedPane1;
	private JPanel contentPane;
	//-----
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel10; 
 	private JLabel jLabel12;
	private JLabel jLabel19_availenergy; 
 	private JLabel jLabel20_loss; 
 	private JProgressBar jProgressBar1; 
 	private JProgressBar jProgressBar2; 
	private JTextField jTextField1_path;
	private JTextField jTextField2_destination;
	private JComboBox jComboBox1;
	private JTextArea jTextArea1_displaymessage;
	private JTextField jTextField6_key; 
 	private JButton jButton12_keygenerate; 
 	private JButton jButton13_encrypt; 
	private JScrollPane jScrollPane1;
	//Table//private JTable jTable1;
	private JList jList1;
	private JScrollPane jScrollPane4; 
	private JButton jButton4_exit; 
	//private JScrollPane jScrollPane2;
	private JButton jButton1_browse;
	private JButton jButton2_send;
	private JButton jButton3_clear;
	private JButton jButton5_route; 
	 
	private JPanel jPanel1;
	//-----

	private JLabel jLabel6; 
 	private JLabel jLabel7; 
 	private JLabel jLabel8; 
	private JLabel jLabel13; 
	private JTextField jTextField7_decryptcode; 
 	private JButton jButton14_decrypt; 
 	private JTextField jTextField3_sourcenamepath; // 
 	private JTextField jTextField4_pathvia; 
 	private JTextArea jTextArea2_displaymessage1; 
 	private JScrollPane jScrollPane3; 
 	private JButton jButton6_clear1;
	private JButton jButton7_exit1; 
	private JPanel jPanel2;
	//-----
	
			private JLabel jLabel9; 
 	private JRadioButton jRadioButton1_carousel; 
 	private JRadioButton jRadioButton2_stretch; 
 	private JButton jButton8_attackernode; 
 	private JButton jButton9_honestnode; 
 	private JPanel jPanel3; 
		private JLabel jLabel15; 
	//-----
	private JLabel jLabel17; 
 	private JLabel jLabel18; 
 	private JTextField jTextField5_efficientpath; 
 	//private JTable jTable1; 
 	//private JScrollPane jScrollPane5;
		private JList jList2; 
 	private JScrollPane jScrollPane6; 
	private JPanel jPanel4;
		private JButton jButton10_displayTable; 
 	private JButton jButton11_getEffiecientpath; 
	private JLabel jLabel16; 
	DefaultTableModel dtm=new DefaultTableModel();
	String[] column={"Path","time and Energy"};
	//-----
	// End of variables declaration
String name;
static String destpath;
String effiPath="";
String path="";
String receivedFileName;
Vector v=new Vector();
Vector v1=new Vector();
Vector values=new Vector();
Vector  response=new Vector();
Vector readTable=new Vector();
Vector recCarousel=new Vector();
Socket soc;
ServerSocket serSoc;
ObjectInputStream ois;

ObjectOutputStream oos;
int portNum;
String ipaddr1;
int s=0;
static String jli;
String rvalue="";
String sourcePath="";
static  double len;


	public SensorNode(String name1,String ipadd,int portval)
	{
		super();
	
		name=name1;
		ipaddr1=ipadd;
		portNum=portval;
		v.add("-select-");
		v.addAll(getInfo());
		
		Thread t=new Thread(this);
		t.start();
Thread t1=new Thread(r1);
	t1.start();

		initializeComponent();
		display2();
		ButtonGroup bg=new ButtonGroup();
		bg.add(jRadioButton1_carousel);
		bg.add(jRadioButton2_stretch);

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
		jTabbedPane1 = new JTabbedPane();
		contentPane = (JPanel)this.getContentPane();
		//-----
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel10 = new JLabel(); 
 		jLabel12 = new JLabel();
		jLabel19_availenergy = new JLabel(); 
 		jLabel20_loss = new JLabel(); 
 		jProgressBar1 = new JProgressBar(); 
 		jProgressBar2 = new JProgressBar(); 
		jTextField1_path = new JTextField();
		jTextField2_destination = new JTextField();
		jComboBox1 = new JComboBox(v);
		jTextArea1_displaymessage = new JTextArea();
		jScrollPane1 = new JScrollPane();
	//Table//	jTable1 = new JTable(dtm);
		jList1 = new JList();
		jScrollPane4 = new JScrollPane(); 
//		jScrollPane2 = new JScrollPane();
//Table//		dtm.setColumnIdentifiers(column);
		jButton1_browse = new JButton();
		jButton2_send = new JButton();
		jButton3_clear = new JButton();
		jButton5_route = new JButton();
		jTextField6_key = new JTextField(); 
 		jButton12_keygenerate = new JButton(); 
 		jButton13_encrypt = new JButton(); 
		
		jPanel1 = new JPanel();
		//-----
		jLabel6 = new JLabel(); 
 		jLabel7 = new JLabel(); 
 		jLabel8 = new JLabel(); 
		jLabel13 = new JLabel(); 
 		jTextField3_sourcenamepath = new JTextField(); 
 		jTextField4_pathvia = new JTextField(); 
 		jTextArea2_displaymessage1 = new JTextArea(); 
		jTextField7_decryptcode = new JTextField(); 
 		jButton14_decrypt = new JButton(); 
 		jScrollPane3 = new JScrollPane(); 
 		jButton6_clear1 = new JButton(); 
		jButton7_exit1 = new JButton(); 
 		jPanel2 = new JPanel(); 

		jPanel2 = new JPanel();
		//-----
		jLabel9 = new JLabel(); 
 		jRadioButton1_carousel = new JRadioButton(); 
 		jRadioButton2_stretch = new JRadioButton(); 
 		jButton8_attackernode = new JButton(); 
 		jButton9_honestnode = new JButton(); 
		jLabel15 = new JLabel();
 		jPanel3 = new JPanel(); 
		//-----
		jLabel16 = new JLabel(); 
		jLabel17 = new JLabel(); 
 		jLabel18 = new JLabel(); 
 		jTextField5_efficientpath = new JTextField(); 
 		//jTable1 = new JTable(dtm); 
	//	dtm.setColumnIdentifiers(column);
	jList2 = new JList(); 
 		jScrollPane6 = new JScrollPane(); 
// 		jScrollPane5 = new JScrollPane(); 
		jButton10_displayTable = new JButton(); 
 		jButton11_getEffiecientpath = new JButton();
 		jPanel4 = new JPanel(); 
		//-----
jButton4_exit = new JButton(); 
		//
		// jTabbedPane1
		//
		jTabbedPane1.addTab("Sender", jPanel1);
		jTabbedPane1.addTab("Receiver", jPanel2);
		jTabbedPane1.addTab("AttackNode", jPanel3);
		jTabbedPane1.addTab("HonestNode", jPanel4);
		jTabbedPane1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				jTabbedPane1_stateChanged(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		addComponent(contentPane, jTabbedPane1, -1,-1,803,512);
		//
		// jLabel1

		Font font=new Font("verdana",Font.BOLD+Font.ITALIC,13);
		Font font1=new Font("verdana",Font.BOLD+Font.ITALIC,12);
		//
		jLabel1.setText("Path");
		jLabel1.setFont(font1);
		jLabel1.setForeground(new Color(95,5,115));

		//
		// jLabel2
		//
		jLabel2.setText("Message");
		jLabel2.setFont(font1);
		jLabel2.setForeground(new Color(95,5,115));
		//
			//
		jLabel19_availenergy.setText("Available Energy"); 
		jLabel19_availenergy.setFont(font1);
		jLabel19_availenergy.setForeground(new Color(95,5,115));
 		// 
 		// jLabel20_loss 
 		// 
 		jLabel20_loss.setText("Loss Energy"); 
		jLabel20_loss.setFont(font1);
		jLabel20_loss.setForeground(new Color(95,5,115));
 		// 
 		// 
 		// jProgressBar1 
 		// 
 		jProgressBar1.setOrientation(SwingConstants.VERTICAL); 
 		// 
 		// jProgressBar2 
 		// 
 		jProgressBar2.setOrientation(SwingConstants.VERTICAL); 
 		// 
		// jLabel3
		//
		jLabel3.setText("Destination");
		jLabel3.setFont(font1);
		jLabel3.setForeground(new Color(95,5,115));
		//
		// jLabel4
		//
		//jLabel4.setText("Route Path");
		//
		// jLabel5
		//
		jLabel5.setText("Destination");
		jLabel5.setFont(font1);
		jLabel5.setForeground(new Color(95,5,115));
		//
		jLabel10.setIcon(new ImageIcon("C:\\Program Files\\images\\rr.jpg")); 
 		// 
 		// jLabel12 
 		// 
 		jLabel12.setIcon(new ImageIcon("C:\\Program Files\\images\\cooltext1162468260.png")); 
 		// 
		// jTextField1_path
		//
		jTextField1_path.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_path_actionPerformed(e);
			}

		});
		//
		// jTextField2_destination
		//
		jTextField2_destination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField2_destination_actionPerformed(e);
			}

		});
		//
		// jComboBox1
		//
		jComboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jComboBox1_actionPerformed(e);
			}

		});
		//
		// jTextArea1_displaymessage
		//
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(jTextArea1_displaymessage);
jTextArea1_displaymessage.setEditable(false);

		// jTable1
		//
	//	jTable1.setModel(new DefaultTableModel(4, 4));
		//
		// jScrollPane2
		//
											//Table//jScrollPane2.setViewportView(jTable1);
											//
											//jTable1.addMouseListener(new MouseAdapter()   
											//		{  
		//Table//									//		public void mouseClicked(MouseEvent evt)  
											//		{  
											//		Integer col = jTable1.getSelectedColumn();  
											//		Integer row = jTable1.getSelectedRow();  
											//			
											//		String pat=(String)jTable1.getModel().getValueAt(row, col); 
											//
											//		jTextField2_destination.setText(pat);
											//		}
											//		});
		//
			// jList1 
 		// 
 		jList1.addListSelectionListener(new ListSelectionListener() { 
 			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				jList1_valueChanged(e); 
 			} 
  
 		}); 
 		// 
			// jScrollPane4 
 		// 
 		jScrollPane4.setViewportView(jList1); 
 		//
		// jButton1_browse
		//
		jButton1_browse.setText("Browse");
		jButton1_browse.setFont(font);
		jButton1_browse.setForeground(new Color(95,5,115));
		jButton1_browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_browse_actionPerformed(e);
			}

		});
		//
		// jButton2_send
		//
		jButton2_send.setText("Send");
		jButton2_send.setFont(font);
		jButton2_send.setForeground(new Color(95,5,115));
		jButton2_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_send_actionPerformed(e);
			}

		});
		//
		// jButton3
		//
		jButton3_clear.setText("Clear");
		jButton3_clear.setFont(font);
		jButton3_clear.setForeground(new Color(95,5,115));
		jButton3_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_clear_actionPerformed(e);
			}

		});
		//
		jButton4_exit.setText("Exit"); 
		jButton4_exit.setFont(font);
		jButton4_exit.setForeground(new Color(95,5,115));
 		jButton4_exit.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton4_exit_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
			// jButton5_route 
 		// 
	
 		jButton5_route.setText("Route  Construction"); 
		jButton5_route.setFont(font1);
		jButton5_route.setForeground(new Color(95,5,115));
 		jButton5_route.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton5_route_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
// jTextField6_key 
 		// 
 		jTextField6_key.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField6_key_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton12_keygenerate 
 		// 
 		jButton12_keygenerate.setText("KeyGenerate"); 
		jButton12_keygenerate.setFont(font);
		jButton12_keygenerate.setForeground(new Color(95,5,115));
 		jButton12_keygenerate.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton12_keygenerate_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton13_encrypt 
 		// 
 		jButton13_encrypt.setText("Encryption"); 
		jButton13_encrypt.setFont(font);
		jButton13_encrypt.setForeground(new Color(95,5,115));
 		jButton13_encrypt.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton13_encrypt_actionPerformed(e); 
 			} 
  
 		}); 

 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		addComponent(contentPane, jTabbedPane1, -1,-1,803,600); 
 	
		// jPanel1
		//
		jPanel1.setLayout(null);
		jPanel1.setOpaque(false);
		addComponent(jPanel1, jLabel1, 3,88,60,18);
		addComponent(jPanel1, jLabel2, 3,177,80,18);
		addComponent(jPanel1, jLabel3, 373,208,110,18);
		addComponent(jPanel1, jLabel4, 367,216,80,18);
		addComponent(jPanel1, jLabel5, 373,435,100,18);
		addComponent(jPanel1, jTextField1_path, 70,84,265,32);
		addComponent(jPanel1, jTextField2_destination,373,455,116,28);
		addComponent(jPanel1, jComboBox1, 373,231,139,22);
		addComponent(jPanel1, jScrollPane1, 70,145,267,340);
//		addComponent(jPanel1, jScrollPane2, 397,263,140,100);
		addComponent(jPanel1, jScrollPane4, 373,312,147,120); 
		addComponent(jPanel1, jButton1_browse, 373,83,123,28);
		addComponent(jPanel1, jButton2_send, 40,513,83,28);//105,453,83,28 
		addComponent(jPanel1, jButton3_clear, 140,513,83,28);//190,454,83,28
		addComponent(jPanel1, jButton4_exit, 245,513,83,28); //280,453,83,28
		addComponent(jPanel1, jButton5_route, 373,270,140,28); 
		addComponent(jPanel1, jLabel12, 129,12,350,61);
		addComponent(jPanel1, jLabel19_availenergy, 560,498,130,25); 
 		addComponent(jPanel1, jLabel20_loss, 697,498,100,25); 
 		addComponent(jPanel1, jProgressBar1, 579,95,37,388); 
 		addComponent(jPanel1, jProgressBar2, 700,95,37,388); 
		//addComponent(jPanel1, jTextField6_key, 373,183,123,28); 
 		//addComponent(jPanel1, jButton12_keygenerate, 373,146,123,28); // 5,453,94,28
 		addComponent(jPanel1, jButton13_encrypt,  373,153,120,28); 
		addComponent(jPanel1, jLabel10, 0,-1,800,600); 
 		 
		
		//
		// jPanel2
		//

			// 
 		// jLabel6 
 		// 
 		jLabel6.setText("Source Name"); 
		jLabel6.setFont(font);
		jLabel6.setForeground(new Color(255,255,255));
 		// 
 		// jLabel7 
 		// 
 		jLabel7.setText("Route Path"); 
		jLabel7.setFont(font);
		jLabel7.setForeground(new Color(255,255,255));
 		// 
 		// jLabel8 
 		// 
 		jLabel8.setText("Message");
		jLabel8.setFont(font);
		jLabel8.setForeground(new Color(255,255,255));
 		// 
 		// jTextField3_sourcenamepath 
 		// 
		jLabel13.setIcon(new ImageIcon("C:\\Program Files\\images\\sky.jpg"));
		//
 		jTextField3_sourcenamepath.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField3_sourcenamepath_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField4_pathvia 
 		// 
 		jTextField4_pathvia.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField4_pathvia_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextArea2_displaymessage1 
 		// 
 		// 
 		// jScrollPane3 
 		// 
 		jScrollPane3.setViewportView(jTextArea2_displaymessage1); 
 		// 
 		// jButton6_clear1 
 		// 
 		jButton6_clear1.setText("Clear"); 
		jButton6_clear1.setFont(font);
		jButton6_clear1.setForeground(new Color(95,5,115));
 		jButton6_clear1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton6_clear1_actionPerformed(e); 
 			} 
  
 		}); 
// jButton7_exit1 
 		// 
 		jButton7_exit1.setText("Exit"); 
		jButton7_exit1.setFont(font);
		jButton7_exit1.setForeground(new Color(95,5,115));
 		jButton7_exit1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton7_exit1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
			// jTextField7_decryptcode 
 		// 
 		jTextField7_decryptcode.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField7_decryptcode_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton14_decrypt 
 		// 
 		jButton14_decrypt.setText("Decryption"); 
		jButton14_decrypt.setFont(font);
		jButton14_decrypt.setForeground(new Color(95,5,115));
 		jButton14_decrypt.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton14_decrypt_actionPerformed(e); 
 			} 
  
 		}); 
 		// 

	jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//	jPanel2.setOpaque(false);
 //jPanel2.setLayout(null);
	jPanel2.setLayout(null); 
 		jPanel2.setOpaque(false); 
 		addComponent(jPanel2, jLabel6, 25,102,120,25); 
 		addComponent(jPanel2, jLabel7, 301,102,102,18); 
 		addComponent(jPanel2, jLabel8, 37,179,92,18); 
 		addComponent(jPanel2, jTextField3_sourcenamepath, 153,102,100,32); 
 		addComponent(jPanel2, jTextField4_pathvia, 420,97,100,32); 
		//addComponent(jPanel2, jTextField7_decryptcode, 581,273,115,22); 
 		addComponent(jPanel2, jButton14_decrypt, 581,315,113,28); 
 		addComponent(jPanel2, jScrollPane3, 150,179,400,251); 
 		addComponent(jPanel2, jButton6_clear1, 183,451,83,28);
		addComponent(jPanel2, jButton7_exit1, 356,451,83,28); 
		addComponent(jPanel2, jLabel13, -1,-1,815,489); 
		//

			// jLabel9 
 		// 
 		jLabel9.setText("Choose the attack type"); 
		jLabel9.setFont(font);
		jLabel9.setForeground(new Color(148,46,2));
 		// 
 		// jRadioButton1_carousel 
 		// 
 		jRadioButton1_carousel.setText("Carousel attack"); 
		jRadioButton1_carousel.setFont(font);
		jRadioButton1_carousel.setForeground(new Color(95,5,115));
 		jRadioButton1_carousel.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jRadioButton1_carousel_itemStateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jRadioButton2_stretch 
 		// 
 		jRadioButton2_stretch.setText("Stretch Attack"); 
		jRadioButton2_stretch.setFont(font);
		jRadioButton2_stretch.setForeground(new Color(95,5,115));
 		jRadioButton2_stretch.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jRadioButton2_stretch_itemStateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jButton8_attackernode 
 		// 
 		jButton8_attackernode.setText("Attacker Route"); 
		jButton8_attackernode.setFont(font1);
		jButton8_attackernode.setForeground(new Color(95,5,115));

 		jButton8_attackernode.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton8_attackernode_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
		jLabel15.setIcon(new ImageIcon("C:\\Program Files\\images\\backgro.jpg"));
 		// jButton9_honestnode 
 		// 
 		jButton9_honestnode.setText("Honest Route"); 
	jButton9_honestnode.setFont(font1);
		jButton9_honestnode.setForeground(new Color(95,5,115));
 		jButton9_honestnode.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton9_honestnode_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jPanel3 
 		// 
 		jPanel3.setLayout(null); 
 		jPanel3.setOpaque(false); 
 		addComponent(jPanel3, jLabel9, 198,100,222,34); 
 		addComponent(jPanel3, jRadioButton1_carousel, 244,156,155,33); 
 		addComponent(jPanel3, jRadioButton2_stretch, 243,222,165,32); 
 		addComponent(jPanel3, jButton8_attackernode, 156,315,140,38); 
 		addComponent(jPanel3, jButton9_honestnode, 350,315,140,35); 
		addComponent(jPanel3, jLabel15, -1,-1,804,489); 
		// jPanel4
			// jLabel16 
 		// 
		// jLabel17 
 		// 
 		jLabel17.setText("Honest Route Selection"); 
		jLabel17.setFont(font1);
		jLabel17.setForeground(new Color(95,5,115));
 		// 
 		// jLabel18 
 		// 
 		jLabel18.setText("Efficient Path");
		jLabel18.setFont(font1);
		jLabel18.setForeground(new Color(95,5,115));
 		// 
 		// jTextField5_efficientpath 
 		// 
 		jTextField5_efficientpath.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField5_efficientpath_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTable1 
 		// 
 		//jTable1.setModel(new DefaultTableModel(4, 4)); 
//		jTable1.setFont(font1);
	//	jTable1.setForeground(new Color(95,5,115));
 		// 
 		// jScrollPane5 
 		// 
// 		jScrollPane5.setViewportView(jTable1); 
 		// 
			// jButton10_displayTable 
 		// 
 		jButton10_displayTable.setText("AODV Routing Construction"); 
		jButton10_displayTable.setFont(font1);
		jButton10_displayTable.setForeground(new Color(95,5,115));
 		jButton10_displayTable.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton10_displayTable_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
			// jList2 
 		// 
 		jList2.addListSelectionListener(new ListSelectionListener() { 
 			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				jList2_valueChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jScrollPane6 
 		// 
 		jScrollPane6.setViewportView(jList2); 
 		// 
 		// jButton11_getEffiecientpath 
 		// 
 		jButton11_getEffiecientpath.setText("EfficientPath"); 
		jButton11_getEffiecientpath.setFont(font1);
		jButton11_getEffiecientpath.setForeground(new Color(95,5,115));
 		jButton11_getEffiecientpath.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton11_getEffiecientpath_actionPerformed(e); 
 			} 
  
 		}); 
 		// jPanel4 
 		jLabel16.setIcon(new ImageIcon("C:\\Program Files\\images\\images.jpg")); 
 		// 
		//
	jPanel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	jPanel4.setLayout(null); 
	addComponent(jPanel4, jLabel17, 132,23,352,49); 
 		addComponent(jPanel4, jLabel18, 71,290,124,30); 
 		addComponent(jPanel4, jTextField5_efficientpath, 207,295,100,22); 
 	//	addComponent(jPanel4, jScrollPane5, 95,95,294,120); 
	addComponent(jPanel4, jScrollPane6, 137,90,184,146); 
		addComponent(jPanel4, jButton10_displayTable, 441,95,186,28); 
 		addComponent(jPanel4, jButton11_getEffiecientpath, 354,290,123,28); 
 		addComponent(jPanel4, jLabel16, -1,-2,821,490); 
	     
		//
		// SensorNode
		//
		this.setTitle("SensorNode"+name);
	//	this.setTitle("SensorNode");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(807, 604));
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
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void jTabbedPane1_stateChanged(ChangeEvent e)
	{
		System.out.println("\njTabbedPane1_stateChanged(ChangeEvent e) called.");
		// TODO: Add any handling code here

	}
		
  

	private void jTextField1_path_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_path_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jTextField2_destination_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField2_destination_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jComboBox1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njComboBox1_actionPerformed(ActionEvent e) called.");
		
		Object o = jComboBox1.getSelectedItem();
		System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
		// TODO: Add any handling code here for the particular object being selected
		
	}

	private void jButton1_browse_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_browse_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
browse();
	}

	private void jButton2_send_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_send_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
send();
	}


	private void jButton5_route_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton5_route_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  route();

 	} 

	private void jButton3_clear_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton3_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
clear();
	}

	//
	private void jButton4_exit_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton4_exit_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  dispose();
 	} 
	
 	private void jTextField3_sourcenamepath_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njTextField3_sourcenamepath_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jTextField4_pathvia_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njTextField4_pathvia_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton6_clear1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton6_clear1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  clear();
 	} 
  
 	// 
		private void jButton7_exit1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton7_exit1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  dispose();
 	} 

	private void jRadioButton1_carousel_itemStateChanged(ItemEvent e) 
 	{ 
 		System.out.println("\njRadioButton1_carousel_itemStateChanged(ItemEvent e) called."); 
 		System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		// TODO: Add any handling code here 
		rvalue="carousel";
		System.out.println(rvalue);
 		 
 	} 
  
 	private void jRadioButton2_stretch_itemStateChanged(ItemEvent e) 
 	{ 
 		System.out.println("\njRadioButton2_stretch_itemStateChanged(ItemEvent e) called."); 
 		System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		// TODO: Add any handling code here 
		rvalue="stretch";
		System.out.println(rvalue);
 		 
 	} 
  
 	private void jButton8_attackernode_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton8_attackernode_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
		attacknode();
 	} 
  
 	private void jButton9_honestnode_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton9_honestnode_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
		if(rvalue.equals("stretch"))
		{
			JOptionPane.showMessageDialog(this,"AODV protocol activation");
		}
		else if(rvalue.equals("carousel"))
		{
			JOptionPane.showMessageDialog(this,"Looping path avoided choose raliable path");
		}
  String effiepath=jTextField5_efficientpath.getText();
  sourcePath=effiepath;

 	} 
  	private void jList1_valueChanged(ListSelectionEvent e) 
 	{ 
 		System.out.println("\njList1_valueChanged(ListSelectionEvent e) called."); 
 		if(!e.getValueIsAdjusting()) 
 		{ 
// 			Object o = jList1.getSelectedValue(); 
// 			System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
 			// TODO: Add any handling code here for the particular object being selected 
 			 jli=(String)jList1.getSelectedValue();
			System.out.println(jli);
			jTextField2_destination.setText(jli);
 		} 
 	} 
private void jTextField5_efficientpath_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njTextField5_efficientpath_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
		private void jButton10_displayTable_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton10_displayTable_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  display();
 	} 
  
  	private void jList2_valueChanged(ListSelectionEvent e) 
 	{ 
 		System.out.println("\njList2_valueChanged(ListSelectionEvent e) called."); 
 		if(!e.getValueIsAdjusting()) 
 		{ 
 			Object o = jList2.getSelectedValue(); 
 			System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
 			// TODO: Add any handling code here for the particular object being selected 
 			 
 		} 
 	} 
 	private void jButton11_getEffiecientpath_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton11_getEffiecientpath_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  effpath();
 	} 
	private void jTextField6_key_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njTextField6_key_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton12_keygenerate_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton12_keygenerate_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 		keygenerate();
 
	} 
  
 	private void jButton13_encrypt_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton13_encrypt_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  encryption();
 	} 
		private void jTextField7_decryptcode_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njTextField7_decryptcode_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton14_decrypt_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton14_decrypt_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  decryption();
 	} 
  
  
  
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
	// TODO: Add any method code to meet your needs in the following area
	//

//jTextField1_path  jTextField2_destination  jTextArea1_displaymessage











//*************************************BROWSE BUTTOn
public void browse()
	{
	
	JFileChooser jf=new JFileChooser();
	//JDialog dialog=createDialog(this);
	jf.showOpenDialog(this);
//	jf.showDialog(this,"SensorNode.java");
	File f=jf.getSelectedFile();
	String path=f.getAbsolutePath();
jTextField1_path.setText(path);

try
	{
		FileInputStream fin=new FileInputStream(f);
byte[] b=new byte[fin.available()];
fin.read(b);

String messagedisplay=new String(b);
jTextArea1_displaymessage.setText(messagedisplay);

 len=messagedisplay.length();



	}
	catch (Exception ex)
	{
	}

	}





//-----------------------------GETINFO--------------

public Vector getInfo()
	{
	try
	{
		soc=new Socket(GetAddress.getIp(),7777);
		oos=new ObjectOutputStream(soc.getOutputStream());
		oos.writeObject("getNodes");
		oos.writeObject(name);

		ois=new ObjectInputStream(soc.getInputStream());
		v1=(Vector)ois.readObject();
	}
	catch (Exception ex1)
	{
		ex1.printStackTrace();
	}
	return v1;
	}



public void route()
	{

	try
	{
		Vector v2=new Vector();
		 destpath=jComboBox1.getSelectedItem().toString();
		System.out.println("*************destpath***********"+destpath);
		System.out.println("*****************Source****************"+name);
		v2.add(name);
		v2.add(destpath);



		soc=new Socket(GetAddress.getIp(),7777);
		oos=new ObjectOutputStream(soc.getOutputStream());
		oos.writeObject("checkavailablep");
		oos.writeObject(v2);



		ois=new ObjectInputStream(soc.getInputStream());
		String res=ois.readObject().toString();
		System.out.println("********************res*********"+res);

		
		if(res.equals("AvailPath"))
		{
			
			response=(Vector)ois.readObject();
			System.out.println("*********"+response);
											//			while(dtm.getRowCount()>0)
											//			{
				//Table//							//				dtm.removeRow(0);
											//			}
											//			int i=0;
											//			if(response.size()>0)
											//			{
											//				
											//				for(int j=0;j<response.size();j=j+2)
											//				{
											//					Vector tableValue=new Vector();
											//					tableValue.add(response.get(j));
											//					tableValue.add(response.get(j+1));
											//					dtm.insertRow(i++,tableValue.toArray());
											//					tableValue.removeAllElements();
											//				}
											//			
											//			}
		
		}
		
		jList1.setListData(response);
	}
	catch (Exception ex2)
	{
	}


	}

	//-----------------------------------Select path--------------
	

//------------------------------------------------------------effpath-----------------------------

public Vector effpath()
	{
 try
 {
	soc=new Socket(GetAddress.getIp(),7777);
	
	oos=new ObjectOutputStream(soc.getOutputStream());
	
	oos.writeObject("getEfficientpath");

	ois=new ObjectInputStream(soc.getInputStream());

	effiPath=(String)ois.readObject();
	int i;
	if(effiPath.equals("setEfficientpath"))
	 {
		Vector getResult=new Vector();
		getResult=(Vector)ois.readObject();
		String attackernode=(String)ois.readObject();
		System.out.println("*********result******************"+getResult);
		for(i=0;i<getResult.size();i++)
			{
			if(i==0)
				{
				}
				else
				{
			System.out.println("*******************ReadTable*********************"+getResult.get(i));
				}
			}
			String conver[]=(String[])getResult.toArray(new String[v.size()]);
			String originalpath="";
			for(String xval:conver)
		 {	
				System.out.println("*******"+attackernode);
				if(!xval.contains(attackernode))
			 {
					if((xval.length())!=4)
				 {
					originalpath=xval;
					System.out.println("****sotr*****"+xval);
					System.out.println("************************sort***********"+originalpath);
						
				 }
			 }
			

			 
		 }
		 jTextField5_efficientpath.setText(originalpath);
						jTextField2_destination.setText(originalpath);
		  
	 }
//
//	//System.out.println("^^^^^^^^^^"+values);
//	jTextField5_efficientpath.setText(effiPath);
//	jTextField2_destination.setText(effiPath);
 }
 catch (Exception b)
{
	b.printStackTrace();
}
return values;
}

////////////////////////Send  the Data/////////////////////////////jTextField1_path  jTextField2_destination  jTextArea1_displaymessage
public void  send()
	{
		display1();
				//display2();
		 sourcePath=jTextField2_destination.getText();

		String fileCont=jTextArea1_displaymessage.getText();
		String destinode1=jComboBox1.getSelectedItem().toString();
		String nextHop="";
System.out.println("******************"+sourcePath);
System.out.println("******************"+destinode1);
	//System.out.println("******************"+fileCont);

		try
		{
			soc=new Socket(GetAddress.getIp(),7777);
			oos=new ObjectOutputStream(soc.getOutputStream());

			oos.writeObject("Desti");
			//oos.writeObject(effiPath);
			oos.writeObject(sourcePath);
			
			oos.writeObject(destinode1);
			oos.writeObject(rvalue);

			System.out.println(sourcePath+"\t"+destinode1+"\t"+rvalue);

		
			ois=new ObjectInputStream(soc.getInputStream());
			String msg=(String)ois.readObject();
			System.out.println(msg);
			
			if(msg.equals("switchOn1")||msg.equals("switchOn")){
					
			Vector details=(Vector)ois.readObject();
			// nextHop=(String)ois.readObject();

			 String ipAddr=details.get(0).toString();
			int port=(Integer)details.get(1);
			String ppath=details.get(2).toString();
			System.out.println(ipAddr+" "+port+" "+ppath);

			 soc=new Socket(ipAddr,port);
			 oos=new ObjectOutputStream(soc.getOutputStream());


//System.out.println("****************"+s);
			oos.writeObject(name);
			//oos.writeObject(s);
			oos.writeObject(fileCont);
			//oos.writeObject(effpath)
			oos.writeObject(ppath);
				}
			//else if(msg.equals("switchOff"))
			//{
			//		JOptionPane.showMessageDialog(this,"Intermediate Node "+nextHop+" is switched Off");
		//	}
			else if(msg.equals("carouse"))
			{
				
				Vector details1=(Vector)ois.readObject();
				Vector details2=(Vector)ois.readObject();
				String ipAddr1=details1.get(0).toString();
			int port1=(Integer)details1.get(1);
			String ppath1=details1.get(2).toString();
			System.out.println("******************************** "+ipAddr1+"  ************************ "+port1);

			 soc=new Socket(ipAddr1,port1);
			 oos=new ObjectOutputStream(soc.getOutputStream());


//System.out.println("****************"+s);
oos.writeObject("iscarousel");
			//oos.writeObject(name);
			//oos.writeObject(s);
			oos.writeObject(fileCont);
			//oos.writeObject(effpath)
			oos.writeObject(ppath1);
			oos.writeObject(details2);

				
			}
		}
	

		
		
	
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	
	}




public void run()
	{
		try
		{
			serSoc=new ServerSocket(portNum);
			System.out.println("**********portNum**************"+portNum);
			while(true)
			{
					soc=serSoc.accept();
					ois=new ObjectInputStream(soc.getInputStream());
					String node=(String)ois.readObject();
				//	int count=(Integer)ois.readObject();
				
						if(node.equals("iscarousel"))
							
				{
							System.out.println("(********************iscarousel*************"+node);
							String recfile=(String)ois.readObject();
						//System.out.println("(********************recfile*************"+recfile);
							String recpath=(String)ois.readObject();
System.out.println("(********************recpath*************"+recpath);
							recCarousel=(Vector)ois.readObject();
							String existingfile=recCarousel.get(0).toString();
							//System.out.println("(********************existingfile*************"+existingfile);
							String existingpath=recCarousel.get(recCarousel.size()-1).toString();
							System.out.println("(********************existingpath*************"+existingpath);
							


// jTextField3_sourcenamepath.setText(node);
//					 jTextArea2_displaymessage1.setText(recfile);
//					 jTextField4_pathvia.setText(recpath);
for(int loop=0;loop<=2;loop++)
					{
					JOptionPane.showMessageDialog(this,"File Receieved  "+name);
	//				 JOptionPane.showMessageDialog(this,"File Receieved Via "+recpath);

					 JOptionPane.showMessageDialog(this,"Looping Forward");
					}
							carouselattacked(recCarousel,recfile,existingpath);
							//jTextField3_sourcenamepath.setText(node);
//					 jTextArea2_displaymessage1.setText(recfile);
	//				 jTextField4_pathvia.setText(recpath);

							
			

							
				}
				else if(node.equals("sourcenodereceive"))
				{
				System.out.println("****************node*****************"+name);
					String file1=(String)ois.readObject();
					String paath1=(String)ois.readObject();
					System.out.println("****************node*****************"+paath1);
					 jTextField3_sourcenamepath.setText(name);
					 jTextArea2_displaymessage1.setText(file1);
					 jTextField4_pathvia.setText(jli);
					 System.out.println(jli);
					 JOptionPane.showMessageDialog(this,"File Receieved Via "+jli);
				}
				else
				{
					String file=(String)ois.readObject();
					
					String paath=(String)ois.readObject();
					System.out.println("****************node*****************"+node+" **"+paath);
					 jTextField3_sourcenamepath.setText(node);
					 jTextArea2_displaymessage1.setText(file);
					 jTextField4_pathvia.setText(paath);
					 JOptionPane.showMessageDialog(this,"File Receieved Via "+paath);
				}
		}
		}
		catch (Exception e2)
			{
	e2.printStackTrace();

			}
}

public void clear(){
jTextField1_path.setText("") ;
jTextField2_destination.setText("") ; 
jTextArea1_displaymessage.setText("") ;   
jTextField3_sourcenamepath.setText("") ;  
jTextField4_pathvia.setText("") ;   
jTextArea2_displaymessage1.setText("");
		

}
public void carouselattacked(Vector attackreceive,String carouselattackscfile,String carouselattackscpath)
	{
	System.out.println("*****************attackreceive*********"+attackreceive);
	//System.out.println("*****************attackreceive*********"+carouselattackscfile);
	//System.out.println("*****************attackreceive*********"+carouselattackscpath);

	String carouselattackscip=attackreceive.get(0).toString();
	String carouselattackscport=attackreceive.get(recCarousel.size()-1).toString();
	int carousecport=Integer.parseInt(carouselattackscport);

//
//oos.writeObject("sourcenodereceive");
//oos.writeObject(carouselattackscip);
//oos.writeObject(carouselattackscport);
try
{
Socket ssoc=new Socket(carouselattackscip,carousecport);
oos=new ObjectOutputStream(ssoc.getOutputStream());
oos.writeObject("sourcenodereceive");
oos.writeObject(carouselattackscfile);
oos.writeObject(carouselattackscpath);
	
}
catch (Exception cach)
{
	cach.printStackTrace();
}



	}

Runnable r1=new Runnable(){
	public void run()
	{
		try
		{
			Vector logininfo=new Vector();
		soc=new Socket(GetAddress.getIp(),7777);

		oos=new ObjectOutputStream(soc.getOutputStream());
		logininfo.add(name);
		logininfo.add(ipaddr1);
		logininfo.add(portNum);
		oos.writeObject("logininfo1");
		oos.writeObject(logininfo);
//serSoc=new ServerSocket(portNum);
		
//soc=serSoc.accept();

ois=new ObjectInputStream(soc.getInputStream());
String ssss=(String)ois.readObject();
if(ssss.equals("Nodealready"))
			{
	dispose();
	JOptionPane.showMessageDialog(null,"The node already login");
	
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Sensor Information Stored");
			}


		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		//name  ipaddr1  portNum
		
	}
	};

public void encryption()
	{
String originalValue=jTextArea1_displaymessage.getText();

System.out.println(originalValue);
if(originalValue.equals(""))
		{
	JOptionPane.showMessageDialog(this,"Please select the encrypted file");
		}
	else
		{
		try
		{
			String encData=TestProtector.encrypt(originalValue,"H1");
		jTextArea1_displaymessage.setText(encData);
		
		}
		catch (Exception aex)
		{
			aex.printStackTrace();
		}
		
		}
	}
public void 	decryption()
	{
	String decrpt=jTextArea2_displaymessage1.getText();
	if(decrpt.equals(""))
		{
		JOptionPane.showMessageDialog(this,"Empty Field selected");
		}
		else
		{
			try
			{
				String descrpt=TestProtector.decrypt(decrpt,"H1");
				jTextArea2_displaymessage1.setText(descrpt);
			}
			catch (Exception xye)
			{
				xye.printStackTrace();
			}
			

		}
	}

public void display()
	{
	try
	{
System.out.println("************************table selected**************");
soc=new Socket(GetAddress.getIp(),7777);
oos=new ObjectOutputStream(soc.getOutputStream());
oos.writeObject("displayTable");

	ois=new ObjectInputStream(soc.getInputStream());
		String res=ois.readObject().toString();
		System.out.println("********************res*********"+res);

		
		if(res.equals("tablevaleDisplay"))
		{
		readTable=(Vector)ois.readObject();
	System.out.println("*****************oos.writeObject(tablevla);********"+readTable);
		for(int i=0;i<readTable.size();i++)
			{
			if(i==0||i==1)
				{
				}
				else
				{
			System.out.println("*******************ReadTable*********************"+readTable.get(i));
			jList2.setListData(readTable);
		
		//	dtm.addRow(new Object[]{readTable.get(i)});

				}
				
			}

		
		}
	}
	
	catch (Exception exi)
	{
		exi.printStackTrace();
	}
					
			
		

	}


public void attacknode()
	{

	if(rvalue.equals("stretch"))
		{
			JOptionPane.showMessageDialog(this,"Stretch attack activated");
		}
		else if(rvalue.equals("carousel"))
		{
JOptionPane.showMessageDialog(this,"carousel attack activated");
		}
  try
  {
	soc=new Socket(GetAddress.getIp(),7777);
oos=new ObjectOutputStream(soc.getOutputStream());
oos.writeObject("carouselattacker");
oos.writeObject(rvalue);
oos.writeObject(name);

  }
  catch (Exception carousel)
  {
	  carousel.printStackTrace();
  }
	}


public void display1()
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
				Thread.sleep(2000);
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

public void display2()
	{
	Thread th=new Thread(new Runnable()
		{
		int i=100;
		public void run()
			{
		
jProgressBar2.setValue(i);
jProgressBar2.setString("100%");
		
			try
			{
				Thread.sleep(10);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			
			
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
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
//new SensorNode("A","B",11);
	}
//= End of Testing =


}
