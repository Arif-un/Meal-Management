package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.SoftBevelBorder;

import Controller.Meal_con;
import Controller.Mem_info_con;
import Model.Allow_log;
import Model.Balance;
import Model.Cost;
import Model.Meal;
import Model.Mem_info;
import Model.Reports;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import javax.swing.event.CaretEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
public class Main_view
{
  Point point = new Point();
  boolean resizing = false;
  private JButton meal;
  private JPanel mem_panel;
  private JPanel cost_pan;
  private JPanel fund_panel;
  private JPanel meal_panel;
  private JPanel main;
  private JButton cost;
  private JButton fund;
  private JButton member;
  private JButton setting;
  private JButton report;
  private JPanel setting_panel;
  private JPanel report_panel;
  private JLabel title;
  private JButton button;
  private JLabel lblActiveMember;
  private JLabel lblInactiveMember;
  private JLabel lblTotalMember;
  private JPanel reg_mem;

	String file_path;
	private JLabel photo_label;
	private JTextField path_t;
	private JLabel lblRegNo;
	private JLabel lblAdress;
	private JLabel lblPhoneNo;
	private JLabel lblIdNo;
	private JTextField name_t;
	private JSeparator separator_1;
	private JTextField roll_t;
	private JSeparator separator_2;
	private JTextField id_t;
	private JSeparator separator_3;
	private JTextField reg_t;
	private JSeparator separator_4;
	private JTextField phone_t;
	private JSeparator separator_6;
	private JTextArea adress_t;
	public static JTable active_tab;
	public static JTable inactive_tab;
	private JLabel lblActiveMembers;
	private JLabel lblIanctiveMembers;
	public static JTable bal_tab;
	public static  JLabel total_bal;
	private JLabel label;
	private JSeparator separator_7;
	private JTextField c_name;
	private JLabel label_1;
	private JTextField quan;
	private JSeparator separator_8;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField price;
	private JTextField total;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JLabel label_4;
	public static JTable cost_tab;
	private JDateChooser dateChooser;
	private JButton dlt_s;
	private JButton dlt_lst;
	private JLabel now_bal;
	private JRadioButton lun;
	private JRadioButton dnr;
	private JTextField id_m;
	private JDateChooser dateChooser_meal;
	public static JTable meal_tab;
	private JTextField bt;
	private JTextField lt;
	private JTextField dt;
	private JRadioButton bf;
	private JLabel invalid;
	private JButton save_meal;
	private JTextField id_fund;
	private JTextField amnt;
	private JDateChooser dateChooser_fund;
	private JButton btnAddBalance;
	private JLabel invalid_fund;
	private JButton mem_sav;
	private JLabel exist;
	private JLabel active;
	private JLabel inactive;
	private JLabel tot;
	private JTextField per_meal;
	private JTextField tot_meal;
	private JDateChooser dateChooser_rep;
	private JLabel tot_cos;
	public static JTable rep_tab;
	private JButton btnResetAndDelete;
	private JCheckBox alw_log;
  public void buildGUI()
  {
    final JFrame f = new JFrame();
    f.setIconImage(Toolkit.getDefaultToolkit().getImage(Main_view.class.getResource("/img/Meal-labcc.png")));
    f.setTitle("Meal Lab");
    f.getContentPane().setBackground(new Color(33,35,44));
    f.setUndecorated(true);
    f.setSize(1019,526);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(null);
    
    JButton close = new JButton("");
    close.setBorderPainted(false);
    close.setContentAreaFilled(false);
    close.setDefaultCapable(false);
    close.setFocusPainted(false);
    close.setFocusable(false);
    close.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/Cancel_24px_1.png")));
    close.setIcon(new ImageIcon(Main_view.class.getResource("/img/Cancel_24px_2.png")));
    close.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		System.exit(0);
    	}
    });
    close.setBounds(976, 11, 33, 32);
    f.getContentPane().add(close);
    
    JButton min = new JButton("");
    min.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		f.setState(JFrame.ICONIFIED);
    	}
    });
    min.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/Down-Button_24px.png")));
    min.setIcon(new ImageIcon(Main_view.class.getResource("/img/Down Button_24px_1.png")));
    min.setFocusable(false);
    min.setFocusPainted(false);
    min.setDefaultCapable(false);
    min.setContentAreaFilled(false);
    min.setBorderPainted(false);
    min.setBounds(940, 11, 33, 32);
    f.getContentPane().add(min);
    
    JPanel sidebar = new JPanel();
    sidebar.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		//panel.setBounds(10, 11, 150, 504);
    	}
    	@Override
    	public void mouseEntered(MouseEvent arg0) {
    		sidebar.setBounds(0, 62, 173, 464);

    	}
    	@Override
    	public void mouseExited(MouseEvent e) {
    		sidebar.setBounds(0, 62, 64, 464);
    	}
    });
    sidebar.setBackground(new Color(172,174,248));
    sidebar.setBounds(0, 62, 64, 464);
    f.getContentPane().add(sidebar);
    sidebar.setLayout(null);
    
    meal = new JButton("");
    meal.setSelectedIcon(new ImageIcon(Main_view.class.getResource("/img/ROLLmeal.png")));
    meal.setSelected(true);
    meal.setRolloverEnabled(false);
    meal.setRequestFocusEnabled(false);
    meal.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/tygr.png")));
    meal.setBorderPainted(false);
    meal.setBackground(new Color(172,174,248));
    meal.setFocusPainted(false);
    
    				if(meal.isSelected()){
    					meal.setBackground(new Color(229,233,240));
    					/*button_1.setSelected(false);
    					button_2.setSelected(false);
    					button_3.setSelected(false);*/
    					}
    meal.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
    meal.setIcon(new ImageIcon(Main_view.class.getResource("/img/Meal_52psx.png")));
    meal.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseEntered(MouseEvent e) {
    		sidebar.setBounds(0, 62, 173, 464);

    	}
    	@Override
    	public void mouseExited(MouseEvent e) {
    		sidebar.setBounds(0, 62, 64, 464);

    	}
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		meal.setSelected(true);
				meal.setBackground(new Color(229,233,240));
				cost.setSelected(false);
				member.setSelected(false);
				fund.setSelected(false);
				report.setSelected(false);
				setting.setSelected(false);
				
				setting.setBackground(new Color(172,174,248));
				report.setBackground(new Color(172,174,248));
				cost.setBackground(new Color(172,174,248));
				fund.setBackground(new Color(172,174,248));
				member.setBackground(new Color(172,174,248));
				
    		
    	}
    });
    meal.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		main.removeAll();
    		main.repaint();
    		main.revalidate();
    		
    		main.add(meal_panel);
    		main.repaint();
    		main.revalidate();
    	}
    });
    meal.setBounds(0, 48, 173, 72);
    sidebar.add(meal);
    
    cost = new JButton("");
    cost.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/aefaef.png")));
    cost.setSelectedIcon(new ImageIcon(Main_view.class.getResource("/img/cost-selected.png")));
    cost.setBorderPainted(false);
    cost.setFocusPainted(false);
    cost.setBackground(new Color(172,174,248));
    cost.setIcon(new ImageIcon(Main_view.class.getResource("/img/Cost.png")));
    cost.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseEntered(MouseEvent e) {
    		sidebar.setBounds(0, 62, 173, 464);
 

    	}
    	@Override
    	public void mouseExited(MouseEvent e) {


    		sidebar.setBounds(0, 62, 64, 464);
    	}
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		cost.setSelected(true);
    		
    		cost.setBackground(new Color(229,233,240));
				meal.setSelected(false);
				member.setSelected(false);
				fund.setSelected(false);
				report.setSelected(false);
				setting.setSelected(false);
				
				setting.setBackground(new Color(172,174,248));
				report.setBackground(new Color(172,174,248));
				meal.setBackground(new Color(172,174,248));
				fund.setBackground(new Color(172,174,248));
				member.setBackground(new Color(172,174,248));
    	}
    });
    cost.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		main.removeAll();
    		main.repaint();
    		main.revalidate();
    		
    		main.add(cost_pan);
    		main.repaint();
    		main.revalidate();
    		
    		DateFormat dafm=new SimpleDateFormat("YYYY/MM");
    	    Date d=dateChooser.getDate();
    	    String q=dafm.format(d);
    	    now_bal.setText(Cost.now_balance(q).toString());
    	}
    });
    cost.setBounds(0, 120, 173, 72);
    sidebar.add(cost);
    
    member = new JButton("");
    member.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/afdas.png")));
    member.setSelectedIcon(new ImageIcon(Main_view.class.getResource("/img/Meal_zxc52psx.png")));
    member.setFocusPainted(false);
    member.setBorderPainted(false);
    member.setForeground(new Color(0, 128, 0));
    member.setBackground(new Color(172,174,248));
    member.setIcon(new ImageIcon(Main_view.class.getResource("/img/member.png")));
    member.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseEntered(MouseEvent e) {
    		sidebar.setBounds(0, 62, 173, 464);

    	}
    	@Override
    	public void mouseExited(MouseEvent e) {


    		sidebar.setBounds(0, 62, 64, 464);
    	}
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		member.setSelected(true);
    	
    		member.setBackground(new Color(229,233,240));
				cost.setSelected(false);
				meal.setSelected(false);
				fund.setSelected(false);
				report.setSelected(false);
				setting.setSelected(false);
				
				setting.setBackground(new Color(172,174,248));
				report.setBackground(new Color(172,174,248));
				meal.setBackground(new Color(172,174,248));
				cost.setBackground(new Color(172,174,248));
				fund.setBackground(new Color(172,174,248));
    	}
    });
    member.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		main.removeAll();
    		main.repaint();
    		main.revalidate();
    		
    		main.add(mem_panel);
    		main.repaint();
    		main.revalidate();
    	}
    });
    member.setBounds(0, 263, 173, 72);
    sidebar.add(member);
    
    fund = new JButton("");
    fund.setSelectedIcon(new ImageIcon(Main_view.class.getResource("/img/Meal_52pasdsx.png")));
    fund.setBorderPainted(false);
    fund.setBackground(new Color(172,174,248));
    fund.setFocusPainted(false);
    fund.setIcon(new ImageIcon(Main_view.class.getResource("/img/fund.png")));
    fund.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseEntered(MouseEvent e) {
    		sidebar.setBounds(0, 62, 173, 464);

    	}
    	@Override
    	public void mouseExited(MouseEvent e) {


    		sidebar.setBounds(0, 62, 64, 464);
    	}
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		fund.setSelected(true);
    		

    		fund.setBackground(new Color(229,233,240));
				cost.setSelected(false);
				member.setSelected(false);
				meal.setSelected(false);
				report.setSelected(false);
				setting.setSelected(false);
				
				setting.setBackground(new Color(172,174,248));
				report.setBackground(new Color(172,174,248));
				
				meal.setBackground(new Color(172,174,248));
				cost.setBackground(new Color(172,174,248));
				member.setBackground(new Color(172,174,248));
				
    	}
    });
    fund.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		main.removeAll();
    		main.repaint();
    		main.revalidate();
    		
    		main.add(fund_panel);
    		main.repaint();
    		main.revalidate();
    		
    		DateFormat dfm=new SimpleDateFormat("YYYY/MM");
    		Date d=dateChooser_fund.getDate();
    		String datemysql=dfm.format(d);
    		
    		Balance.load_balance(datemysql);
    		
    		Double t= Balance.total_balance(datemysql);
    	    total_bal.setText(t.toString());
    	}
    });
    fund.setBounds(0, 191, 173, 72);
    sidebar.add(fund);
    
    setting = new JButton("");
    setting.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/adaavxcv.png")));
    setting.setSelectedIcon(new ImageIcon(Main_view.class.getResource("/img/awqq.png")));
    setting.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		main.removeAll();
    		main.repaint();
    		main.revalidate();
    		
    		main.add(setting_panel);
    		main.repaint();
    		main.revalidate();
    	}
    });
    setting.setIcon(new ImageIcon(Main_view.class.getResource("/img/asc.png")));
    setting.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseEntered(MouseEvent e) {
    		sidebar.setBounds(0, 62, 173, 464);
    	}
    	@Override
    	public void mouseExited(MouseEvent e) {
    		sidebar.setBounds(0, 62, 64, 464);
    	}
    	
    	@Override
    	public void mouseClicked(MouseEvent e) {
setting.setSelected(true);
        	
    		setting.setBackground(new Color(229,233,240));
				cost.setSelected(false);
				meal.setSelected(false);
				fund.setSelected(false);
				report.setSelected(false);
				member.setSelected(false);
				
				meal.setBackground(new Color(172,174,248));
				cost.setBackground(new Color(172,174,248));
				fund.setBackground(new Color(172,174,248));
				report.setBackground(new Color(172,174,248));
				member.setBackground(new Color(172,174,248));
    	}
    });
    setting.setBounds(0, 429, 173, 35);
    sidebar.add(setting);
    setting.setForeground(new Color(0, 128, 0));
    setting.setFocusPainted(false);
    setting.setBorderPainted(false);
    setting.setBackground(new Color(172,174,248));
    
    report = new JButton("");
    report.setSelectedIcon(new ImageIcon(Main_view.class.getResource("/img/asw.png")));
    report.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/awdad.png")));
    report.setIcon(new ImageIcon(Main_view.class.getResource("/img/sadre.png")));
    report.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseEntered(MouseEvent e) {
    		sidebar.setBounds(0, 62, 173, 464);
    	}
    	@Override
    	public void mouseExited(MouseEvent e) {
    		sidebar.setBounds(0, 62, 64, 464);
    	}
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		report.setSelected(true);
        	
    		report.setBackground(new Color(229,233,240));
				cost.setSelected(false);
				meal.setSelected(false);
				fund.setSelected(false);
				setting.setSelected(false);
				member.setSelected(false);
				
				meal.setBackground(new Color(172,174,248));
				cost.setBackground(new Color(172,174,248));
				fund.setBackground(new Color(172,174,248));
				setting.setBackground(new Color(172,174,248));
				member.setBackground(new Color(172,174,248));
    		
    	}
    });
    report.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		main.removeAll();
    		main.repaint();
    		main.revalidate();
    		
    		main.add(report_panel);
    		main.repaint();
    		main.revalidate();
    	}
    });
    report.setBounds(0, 390, 173, 41);
    sidebar.add(report);
    report.setForeground(new Color(0, 128, 0));
    report.setFocusPainted(false);
    report.setBorderPainted(false);
    report.setBackground(new Color(172,174,248));
    
    main = new JPanel();
    main.setFocusable(false);
    
    main.setBackground(new Color(64, 70, 84));
    main.setBounds(64, 62, 955, 464);
    f.getContentPane().add(main);
    main.setLayout(new CardLayout(0, 0));
    
    meal_panel = new JPanel();
    main.add(meal_panel, "name_44061690417187");
    meal_panel.setFocusable(false);
    meal_panel.setBackground(new Color(229,233,240));
    meal_panel.setLayout(null);
    
    dateChooser_meal = new JDateChooser();
    dateChooser_meal.setFont(new Font("Tahoma", Font.PLAIN, 15));
    //dateChooser_meal.getBackground().setBackground(new Color(51, 102, 204));
    dateChooser_meal.getCalendarButton().setBackground(new Color(211,219,232));
    dateChooser_meal.setBackground(new Color(51, 102, 204));
    
   
    
    
    Date a=new Date();
    dateChooser_meal.setDate(a);
    dateChooser_meal.addPropertyChangeListener(new PropertyChangeListener() {
    	public void propertyChange(PropertyChangeEvent arg0) {
    	    DateFormat dfm=new SimpleDateFormat("YYYY/MM/dd");
    		Date d=dateChooser_meal.getDate();
    		String datemysql=dfm.format(d);
    	    Meal.load_by_date(datemysql);
    	}
    });
    dateChooser_meal.setBounds(29, 18, 118, 49);
    meal_panel.add(dateChooser_meal);
    
    bf = new JRadioButton("");
    bf.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		if(bf.isSelected()){
    			bt.setText("1");
    			bt.setEditable(true);
    		}
    		else{
    			bt.setText("0");
    			bt.setEditable(false);
    			
    		}
    	}
    });
   // bf.setSelected(true);
   
    bf.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    bf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    bf.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/as.png")));
    bf.setBackground(new Color(229,233,240));
    bf.setSelectedIcon(new ImageIcon(Main_view.class.getResource("/img/bff.png")));
    bf.setIcon(new ImageIcon(Main_view.class.getResource("/img/bf.png")));
    bf.setBounds(176, 18, 187, 49);
    
    meal_panel.add(bf);
    
    lun = new JRadioButton("");
    lun.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(lun.isSelected()){
    			lt.setText("1");
    			lt.setEditable(true);
    		}
    		else{
    			lt.setText("0");
    			lt.setEditable(false);
    		}
    	}
    });
   
    lun.setSelectedIcon(new ImageIcon(Main_view.class.getResource("/img/lun-s.png")));
    lun.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/lun-r.png")));
    lun.setIcon(new ImageIcon(Main_view.class.getResource("/img/lun.png")));
    lun.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    lun.setBackground(new Color(229,233,240));
    lun.setBounds(410, 18, 153, 49);
    meal_panel.add(lun);
    
    dnr = new JRadioButton("");
    dnr.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(dnr.isSelected()){
    			dt.setText("1");
    			dt.setEditable(true);
    		}
    		else{
    			dt.setText("0");
    			dt.setEditable(false);
    		}
    	}
    });
   
    dnr.setIcon(new ImageIcon(Main_view.class.getResource("/img/din.png")));
    dnr.setRolloverIcon(new ImageIcon(Main_view.class.getResource("/img/din-r.png")));
    dnr.setSelectedIcon(new ImageIcon(Main_view.class.getResource("/img/din-s.png")));
    dnr.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    dnr.setBackground(new Color(229,233,240));
    dnr.setBounds(637, 18, 162, 49);
    meal_panel.add(dnr);
    
    id_m = new JTextField();
    id_m.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String id=id_m.getText();
    		String a=Meal.giv_id_get_nam(id);
    		if(a.equals("")){
    		 invalid.setVisible(true);
    		 save_meal.setEnabled(false);
    		}
    		else{
    			invalid.setVisible(false);
       		 save_meal.setEnabled(true);
    		}
    		
    	}
    });
    id_m.setForeground(new Color(102, 204, 255));
    id_m.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    id_m.setColumns(10);
    id_m.setCaretColor(new Color(153, 204, 255));
    id_m.setBorder(null);
    id_m.setBackground(new Color(229,233,240));
    id_m.setBounds(232, 72, 180, 35);
    meal_panel.add(id_m);
    
    JSeparator separator_11 = new JSeparator();
    separator_11.setForeground(new Color(54,54,54));
    separator_11.setBackground(new Color(54,54,54));
    separator_11.setBounds(232, 108, 180, 17);
    meal_panel.add(separator_11);
    
    JLabel lblId = new JLabel("ID :");
    lblId.setForeground(new Color(54,54,54));
    lblId.setFont(new Font("Tahoma", Font.BOLD, 25));
    lblId.setBounds(175, 64, 49, 43);
    meal_panel.add(lblId);
    
    JScrollPane scrollPane_4 = new JScrollPane();
    scrollPane_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
    scrollPane_4.getViewport().setBackground(new Color(229,233,240));
    scrollPane_4.setBounds(34, 122, 885, 331);
    meal_panel.add(scrollPane_4);
    
    meal_tab = new JTable();
    meal_tab.setGridColor(new Color(229,233,240));
    meal_tab.setBorder(new LineBorder(new Color(0, 0, 0)));
    meal_tab.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    meal_tab.setSelectionForeground(new Color(221,222,236));
    meal_tab.setBackground(Color.LIGHT_GRAY);
    meal_tab.setEnabled(false);
    scrollPane_4.setViewportView(meal_tab);
    /*
    DateFormat dfm=new SimpleDateFormat("YYYY/MM/dd");
	Date d=dateChooser_meal.getDate();
	String datemysql=dfm.format(d);
    Meal.load_by_date(datemysql);*/
    
    
    save_meal = new JButton("SAVE");
    save_meal.setForeground(Color.DARK_GRAY);
    save_meal.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		if(id_m.getText().equals("")){
    			JOptionPane.showMessageDialog(null, "Enter ID");
    		}
    		else{
    			DateFormat dfm=new SimpleDateFormat("YYYY/MM/dd");
        		Date d=dateChooser_meal.getDate();
    			
    			String datemysql=dfm.format(d);
    			
    			String brrk=bt.getText();
    			String luncch=lt.getText();
    			String dinnr=dt.getText();
    			
    			try{
    			 Integer brk = Integer.parseInt(brrk);
    			 Integer lunch = Integer.parseInt(luncch);
    			 Integer dinr = Integer.parseInt(dinnr);
    			 
    			 String id_meal=id_m.getText();
    				
    				Meal_con.meal_add(datemysql,id_meal,brk,lunch,dinr);
    			}
    			 catch(Exception a){
    				 a.printStackTrace();
    JOptionPane.showMessageDialog(null, "Invalid Input");
    
   
    			}
    			
    			
    			 id_m.setText("");

    		    Meal.load_by_date(datemysql);
    		}
			
			
			
			
    	}
    });
    save_meal.setFont(new Font("Tahoma", Font.BOLD, 20));
    save_meal.setFocusPainted(false);
    save_meal.setBorderPainted(false);
    save_meal.setBackground(new Color(215,215,236));
    save_meal.setBounds(669, 78, 99, 35);
    meal_panel.add(save_meal);
    
    bt = new JTextField();
    bt.setText("0");
    bt.setEditable(false);
    bt.setForeground(Color.DARK_GRAY);
    bt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
    bt.setColumns(10);
    bt.setCaretColor(Color.DARK_GRAY);
    bt.setBorder(null);
    bt.setBackground(new Color(229,233,240));
    bt.setBounds(365, 18, 35, 35);
    meal_panel.add(bt);
    if(bf.isSelected()){
    	bt.setText("1");
    	   bt.setEditable(true);
    }
    else{
    	bt.setText("0");
 	   bt.setEditable(false);
    }
    JSeparator separator_12 = new JSeparator();
    separator_12.setForeground(new Color(54,54,54));
    separator_12.setBackground(new Color(54,54,54));
    separator_12.setBounds(365, 54, 35, 17);
    meal_panel.add(separator_12);
    
    lt = new JTextField();
    lt.setEditable(false);
    lt.setText("0");
    lt.setForeground(Color.DARK_GRAY);
    lt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
    lt.setColumns(10);
    lt.setCaretColor(Color.DARK_GRAY);
    lt.setBorder(null);
    lt.setBackground(new Color(229,233,240));
    lt.setBounds(563, 14, 35, 35);
    meal_panel.add(lt);
    
    JSeparator separator_13 = new JSeparator();
    separator_13.setForeground(new Color(54,54,54));
    separator_13.setBackground(new Color(54,54,54));
    separator_13.setBounds(563, 50, 35, 17);
    meal_panel.add(separator_13);
    
    dt = new JTextField();
    dt.setEditable(false);
    dt.setText("0");
    dt.setForeground(Color.DARK_GRAY);
    dt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
    dt.setColumns(10);
    dt.setCaretColor(Color.DARK_GRAY);
    dt.setBorder(null);
    dt.setBackground(new Color(229,233,240));
    dt.setBounds(799, 18, 27, 35);
    meal_panel.add(dt);
    
    JSeparator separator_14 = new JSeparator();
    separator_14.setForeground(new Color(54,54,54));
    separator_14.setBackground(new Color(54,54,54));
    separator_14.setBounds(791, 54, 35, 17);
    meal_panel.add(separator_14);
    
    JButton btnDeleteLastEntry = new JButton("Delete last Entry");
    btnDeleteLastEntry.setForeground(Color.DARK_GRAY);
    btnDeleteLastEntry.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		
    		DateFormat dfm=new SimpleDateFormat("YYYY/MM/dd");
    		Date d=dateChooser_meal.getDate();
			
			String datemysql=dfm.format(d);
    		Meal.load_by_date(datemysql);
    		
    		Meal.delete_lst_entry_meal(datemysql);
    	}
    });
    btnDeleteLastEntry.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnDeleteLastEntry.setFocusPainted(false);
    btnDeleteLastEntry.setBorderPainted(false);
    btnDeleteLastEntry.setBackground(new Color(215,215,236));
    btnDeleteLastEntry.setBounds(788, 78, 146, 35);
    meal_panel.add(btnDeleteLastEntry);
    
    invalid = new JLabel("\u25A0 Invalid ID No");
    invalid.setVisible(false);
    invalid.setForeground(new Color(255, 0, 0));
    invalid.setFont(new Font("Tahoma", Font.PLAIN, 14));
    invalid.setBounds(420, 84, 118, 14);
    meal_panel.add(invalid);
    
    fund_panel = new JPanel();
    fund_panel.setForeground(new Color(255, 0, 255));
    main.add(fund_panel, "name_44077097067412");
    fund_panel.setFocusable(false);
    fund_panel.setBackground(new Color(229,233,240));
    fund_panel.setLayout(null);
    
    JScrollPane scrollPane_2 = new JScrollPane();
    scrollPane_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
    scrollPane_2.getViewport().setBackground(new Color(229,233,240));
    scrollPane_2.setBounds(65, 111, 874, 342);
    fund_panel.add(scrollPane_2);
    
    bal_tab = new JTable();
    
    bal_tab.setGridColor(new Color(0, 51, 102));
    bal_tab.setFont(new Font("Arial", Font.PLAIN, 14));
    bal_tab.setForeground(new Color(0, 0, 0));
    bal_tab.setBackground(new Color(61,56,56));
    bal_tab.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		/*		int row=bal_tab.getSelectedRow();
			
			String get_name=bal_tab.getModel().getValueAt(row, 0).toString();
			String get_id_no=bal_tab.getModel().getValueAt(row, 1).toString();
			
			
			Balance_in 			Balance_in=new 			Balance_in(get_name,get_id_no);
			Balance_in.setVisible(true);*/
    	}
    });
    scrollPane_2.setViewportView(bal_tab);
    
   
    
    Balance.load_search_balance(null);
    
    JLabel lblActiveMember_1 = new JLabel("Total Balance :: ");
    lblActiveMember_1.setForeground(new Color(54,54,54));
    lblActiveMember_1.setFont(new Font("Core Slab M", Font.PLAIN, 20));
    lblActiveMember_1.setBounds(414, 62, 180, 37);
    fund_panel.add(lblActiveMember_1);
    
    total_bal = new JLabel("");
    
    
    
    total_bal.setForeground(new Color(54,54,54));
    total_bal.setFont(new Font("Core Slab M", Font.PLAIN, 20));
    total_bal.setBounds(601, 63, 180, 37);
    fund_panel.add(total_bal);
    
    dateChooser_fund = new JDateChooser();
    
    Date x=new Date();
    dateChooser_fund.setDate(x);
    dateChooser_fund.setBounds(140, 11, 129, 54);
    dateChooser_fund.addPropertyChangeListener(new PropertyChangeListener() {
    	public void propertyChange(PropertyChangeEvent arg0) {
    		DateFormat dfm=new SimpleDateFormat("YYYY/MM");
    		Date d=dateChooser_fund.getDate();
    		String datemysql=dfm.format(d);
    		
    		Balance.load_balance(datemysql);
    		
    		Double t= Balance.total_balance(datemysql);
    	    total_bal.setText(t.toString());
    		
    	}
    });
    fund_panel.add(dateChooser_fund);
    
    
    
    JLabel lblIdNo_1 = new JLabel("ID No ::");
    lblIdNo_1.setForeground(new Color(54,54,54));
    lblIdNo_1.setFont(new Font("Tahoma", Font.BOLD, 19));
    lblIdNo_1.setBounds(288, 11, 81, 35);
    fund_panel.add(lblIdNo_1);
    
    id_fund = new JTextField();
    id_fund.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String idd=id_fund.getText();
    		String a=Meal.giv_id_get_nam(idd);
    		if(a.equals("")){
    			invalid_fund.setVisible(true);
    		 btnAddBalance.setEnabled(false);
    		}
    		else{
    		invalid_fund.setVisible(false);
    			btnAddBalance.setEnabled(true);
    		}
    	}
    });
    id_fund.setForeground(new Color(102, 204, 255));
    id_fund.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    id_fund.setColumns(10);
    id_fund.setCaretColor(new Color(153, 204, 255));
    id_fund.setBorder(null);
    id_fund.setBackground(new Color(229,233,240));
    id_fund.setBounds(369, 12, 180, 35);
    fund_panel.add(id_fund);
    
    JSeparator separator_15 = new JSeparator();
    separator_15.setForeground(new Color(54,54,54));
    separator_15.setBackground(new Color(54,54,54));
    separator_15.setBounds(369, 48, 180, 17);
    fund_panel.add(separator_15);
    
    amnt = new JTextField();
    amnt.setForeground(new Color(102, 204, 255));
    amnt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    amnt.setColumns(10);
    amnt.setCaretColor(new Color(153, 204, 255));
    amnt.setBorder(null);
    amnt.setBackground(new Color(229,233,240));
    amnt.setBounds(674, 12, 180, 35);
    fund_panel.add(amnt);
    
    JSeparator separator_16 = new JSeparator();
    separator_16.setForeground(new Color(54,54,54));
    separator_16.setBackground(new Color(54,54,54));
    separator_16.setBounds(684, 48, 170, 17);
    fund_panel.add(separator_16);
    
    JLabel lblAmount = new JLabel("Amount ::");
    lblAmount.setForeground(new Color(54,54,54));
    lblAmount.setFont(new Font("Tahoma", Font.BOLD, 19));
    lblAmount.setBounds(575, 12, 111, 35);
    fund_panel.add(lblAmount);
    
    JLabel lblDate = new JLabel("Date ::");
    lblDate.setForeground(new Color(54,54,54));
    lblDate.setFont(new Font("Tahoma", Font.BOLD, 19));
    lblDate.setBounds(70, 23, 70, 35);
    fund_panel.add(lblDate);
    
    btnAddBalance = new JButton("Add Balance");
    btnAddBalance.setForeground(Color.DARK_GRAY);
    btnAddBalance.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		String id_f=id_fund.getText();
    		String naame=Meal.giv_id_get_nam(id_f);
    		
    		Date d=dateChooser_fund.getDate();	
    		DateFormat dafm=new SimpleDateFormat("YYYY/MM/dd");
    		String datemysql=dafm.format(d);
    		
    		try{
   			 Double am = Double.parseDouble(amnt.getText());

   				Balance.insert_balance(datemysql, naame, id_f,am);   			}
   			 catch(Exception a){
   				 a.printStackTrace();
   JOptionPane.showMessageDialog(null, "Invalid Input");
   			}
    		
    		DateFormat dfm=new SimpleDateFormat("YYYY/MM");
    		Date ad=dateChooser_fund.getDate();
    		String adatemysql=dfm.format(d);
    		
    		Balance.load_balance(adatemysql);
    		Double t= Balance.total_balance(adatemysql);
    	    total_bal.setText(t.toString());
    	    
    	    now_bal.setText(Cost.now_balance(adatemysql).toString());
    	    
    	    id_fund.setText("");
    	    amnt.setText("");
    		
    	}
    });
    btnAddBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnAddBalance.setFocusPainted(false);
    btnAddBalance.setBorderPainted(false);
    btnAddBalance.setBackground(new Color(215,215,236));
    btnAddBalance.setBounds(784, 58, 155, 35);
    fund_panel.add(btnAddBalance);
    
    invalid_fund = new JLabel("\u25A0 Invalid ID No");
    invalid_fund.setVisible(false);
    invalid_fund.setForeground(new Color(255, 0, 0));
    invalid_fund.setFont(new Font("Tahoma", Font.PLAIN, 17));
    invalid_fund.setBounds(379, 48, 119, 26);
    fund_panel.add(invalid_fund);
    
    
    cost_pan = new JPanel();
    cost_pan.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		cost_tab.clearSelection();
    		dlt_lst.setEnabled(true);
    	}
    });
    main.add(cost_pan, "name_44070753051063");
    cost_pan.setFocusable(false);
    cost_pan.setBackground(new Color(229,233,240));
    cost_pan.setLayout(null);
    
    label = new JLabel("Cost Name ::");
    label.setForeground(new Color(54,54,54));
    label.setFont(new Font("Tahoma", Font.BOLD, 19));
    label.setBounds(30, 32, 129, 35);
    cost_pan.add(label);
    
    separator_7 = new JSeparator();
    separator_7.setForeground(new Color(54,54,54));
    separator_7.setBackground(new Color(54,54,54));
    separator_7.setBounds(169, 68, 180, 17);
    cost_pan.add(separator_7);
    
    c_name = new JTextField();
    c_name.setForeground(Color.DARK_GRAY);
    c_name.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    c_name.setColumns(10);
    c_name.setCaretColor(Color.DARK_GRAY);
    c_name.setBorder(null);
    c_name.setBackground(new Color(229,233,240));
    c_name.setBounds(169, 32, 180, 35);
    cost_pan.add(c_name);
    
    label_1 = new JLabel("Quantity ::");
    label_1.setForeground(new Color(54,54,54));
    label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
    label_1.setBounds(373, 32, 111, 35);
    cost_pan.add(label_1);
    
    quan = new JTextField();
    quan.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyReleased(KeyEvent e) {
    		if(price.getText().equals("0")){
    			total.setText("0");
    		}
    		else{
    			double quant =Double.parseDouble(quan.getText());
    			double pr =Double.parseDouble(price.getText());
    		
    		
    		double totall=quant*pr;
    		String a=Double.toString(totall);
    		total.setText(a);
    		}
    	}
    });
    quan.setText("0");
    
    quan.setForeground(Color.DARK_GRAY);
    quan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    quan.setColumns(10);
    quan.setCaretColor(Color.DARK_GRAY);
    quan.setBorder(null);
    quan.setBackground(new Color(229,233,240));
    quan.setBounds(478, 32, 103, 35);
    cost_pan.add(quan);
    
    separator_8 = new JSeparator();
    separator_8.setForeground(new Color(54,54,54));
    separator_8.setBackground(new Color(54,54,54));
    separator_8.setBounds(478, 68, 103, 17);
    cost_pan.add(separator_8);
    
    label_2 = new JLabel("KG/Liter/Pieces");
    label_2.setForeground(Color.LIGHT_GRAY);
    label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
    label_2.setBounds(588, 32, 162, 35);
    cost_pan.add(label_2);
    
    label_3 = new JLabel("Price ::");
    label_3.setForeground(new Color(54,54,54));
    label_3.setFont(new Font("Tahoma", Font.BOLD, 19));
    label_3.setBounds(743, 32, 76, 35);
    cost_pan.add(label_3);
    
    price = new JTextField();
    price.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		if(price.getText().equals("0")){
    			total.setText("0");
    		}
    		else{
    			double quant =Double.parseDouble(quan.getText());
    			double pr =Double.parseDouble(price.getText());
    		
    		
    		double totall=quant*pr;
    		String a=Double.toString(totall);
    		total.setText(a);
    		}
    	}
    });
    price.setText("0");

    price.setForeground(Color.DARK_GRAY);
    price.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    price.setColumns(10);
    price.setCaretColor(Color.DARK_GRAY);
    price.setBorder(null);
    price.setBackground(new Color(229,233,240));
    price.setBounds(818, 32, 103, 35);
    cost_pan.add(price);
    
    total = new JTextField();
    total.setEditable(false);
    total.setForeground(Color.DARK_GRAY);
    total.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    total.setColumns(10);
    total.setCaretColor(Color.DARK_GRAY);
    total.setBorder(null);
    total.setBackground(new Color(229,233,240));
    total.setBounds(818, 78, 103, 35);
    cost_pan.add(total);
    
    separator_9 = new JSeparator();
    separator_9.setForeground(new Color(54,54,54));
    separator_9.setBackground(new Color(54,54,54));
    separator_9.setBounds(818, 114, 103, 17);
    cost_pan.add(separator_9);
    
    separator_10 = new JSeparator();
    separator_10.setForeground(new Color(54,54,54));
    separator_10.setBackground(new Color(54,54,54));
    separator_10.setBounds(818, 68, 103, 17);
    cost_pan.add(separator_10);
    
    label_4 = new JLabel("Total ::");
    label_4.setForeground(new Color(54,54,54));
    label_4.setFont(new Font("Tahoma", Font.BOLD, 19));
    label_4.setBounds(743, 78, 76, 35);
    cost_pan.add(label_4);
    
    dateChooser = new JDateChooser();
    
    Date date = new Date();
    dateChooser.setDate(date);
    dateChooser.setBounds(30, 88, 129, 35);
    dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
    	public void propertyChange(PropertyChangeEvent arg0) {
    		
    		Date d=dateChooser.getDate();	
    	
    		DateFormat dafm=new SimpleDateFormat("YYYY/MM");

			//String datemysql=dafm.format(d);
			
			String a=dafm.format(d);
			//System.out.println(a);
    		Cost.load_cost_by_dat_yr(a);
    		tot_cos.setText(Cost.total_cost(a).toString());
    	}
    });
    cost_pan.add(dateChooser);
    
    JScrollPane scrollPane_3 = new JScrollPane();
    scrollPane_3.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
    scrollPane_3.getViewport().setBackground(new Color(229,233,240));
    
    scrollPane_3.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		cost_tab.clearSelection();
    		dlt_lst.setEnabled(true);
    	}
    });
    scrollPane_3.setBounds(30, 142, 819, 311);
    cost_pan.add(scrollPane_3);
    
    cost_tab = new JTable();
    cost_tab.setGridColor(new Color(229,233,240));
    cost_tab.setBorder(new LineBorder(new Color(0, 0, 0)));
    cost_tab.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    cost_tab.setSelectionForeground(new Color(221,222,236));
    cost_tab.setBackground(new Color(215,215,236));
    cost_tab.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		
    		
int row=cost_tab.getSelectedRow();
			
    		if(cost_tab.isRowSelected(row)){
    			
    			dlt_s.setEnabled(true);
    			dlt_lst.setEnabled(false);
    			
    			
    		}
    	}
    });
    scrollPane_3.setViewportView(cost_tab);
    //Cost.load_cost();
    
    JButton button_1 = new JButton("SAVE");
    button_1.setForeground(Color.DARK_GRAY);
    button_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		DateFormat dfm=new SimpleDateFormat("YYYY/MM/dd");
    		DateFormat dafm=new SimpleDateFormat("YYYY/MM");
    		
    		System.out.println(dafm);
    		Date d=dateChooser.getDate();
			
			String datemysql=dfm.format(d);
			
			String a=dafm.format(d);
			System.out.println(a);
			
    		String cost_name=c_name.getText();
    		String quant=quan.getText();
    		String priz=price.getText();
    		String to=total.getText();
    		
    		java.sql.Date sqlDate = new java.sql.Date(d.getTime());

    		double quanti = Double.parseDouble(quant);
    		double pz = Double.parseDouble(priz);
    		double tot = Double.parseDouble(to);
    		
    		Cost.insert_cost(datemysql, cost_name, quanti, pz, tot);

    		Cost.load_cost_by_dat_yr(a);
    		now_bal.setText(Cost.now_balance(a).toString());
    		tot_cos.setText(Cost.total_cost(a).toString());
    		
    		c_name.setText("");
    		quan.setText("");
    		price.setText("");
    		total.setText("");
    			
    		
    		
    		
    		
    		
    	}
    });
    button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
    button_1.setFocusPainted(false);
    button_1.setBorderPainted(false);
    button_1.setBackground(new Color(215,215,236));
    button_1.setBounds(856, 142, 99, 35);
    cost_pan.add(button_1);
    
    dlt_s = new JButton("");
    dlt_s.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
int row=cost_tab.getSelectedRow();
			
			String get_date=cost_tab.getModel().getValueAt(row, 0).toString();
			String get_cost_name=cost_tab.getModel().getValueAt(row, 1).toString();
			String get_qun=cost_tab.getModel().getValueAt(row, 2).toString();
			String get_price=cost_tab.getModel().getValueAt(row, 3).toString();
			String get_total=cost_tab.getModel().getValueAt(row, 4).toString();

			
			Cost.delete_selected(get_date, get_cost_name, get_qun, get_price, get_total);
			
DateFormat dafm=new SimpleDateFormat("YYYY/MM");
Date d=dateChooser.getDate();
String a=dafm.format(d);

			Cost.load_cost_by_dat_yr(a);
			now_bal.setText(Cost.now_balance(a).toString());
			tot_cos.setText(Cost.total_cost(a).toString());
    		
    	}
    });
    dlt_s.setEnabled(false);
    dlt_s.setIcon(new ImageIcon(Main_view.class.getResource("/img/delete-sele.png")));
    dlt_s.setFont(new Font("Nasalization", Font.PLAIN, 25));
    dlt_s.setFocusPainted(false);
    dlt_s.setBorderPainted(false);
    dlt_s.setBackground(new Color(48, 51, 66));
    dlt_s.setBounds(856, 253, 99, 63);
    cost_pan.add(dlt_s);
    
    dlt_lst = new JButton("");
    dlt_lst.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		Cost.delete_lst_entry();
    		
    		DateFormat dafm=new SimpleDateFormat("YYYY/MM");
    		Date d=dateChooser.getDate();
    		String datemysql=dafm.format(d);
    		String a=dafm.format(d);
    		
    		Cost.load_cost_by_dat_yr(a);
    		now_bal.setText(Cost.now_balance(a).toString());
    		tot_cos.setText(Cost.total_cost(a).toString());
    	}
    });
    dlt_lst.setIcon(new ImageIcon(Main_view.class.getResource("/img/delete-last.png")));
    dlt_lst.setFont(new Font("Myanmar Text", Font.PLAIN, 19));
    dlt_lst.setFocusPainted(false);
    dlt_lst.setBorderPainted(false);
    dlt_lst.setBackground(new Color(48, 51, 66));
    dlt_lst.setBounds(856, 350, 99, 63);
    cost_pan.add(dlt_lst);
    
    JLabel lblBalance = new JLabel("Balance ::");
    lblBalance.setForeground(new Color(61,56,56));
    lblBalance.setFont(new Font("Tahoma", Font.BOLD, 19));
    lblBalance.setBounds(209, 96, 111, 35);
    cost_pan.add(lblBalance);
    
    now_bal = new JLabel("");
    
    DateFormat dafm=new SimpleDateFormat("YYYY/MM");
    Date d=dateChooser.getDate();
    String q=dafm.format(d);
    now_bal.setText(Cost.now_balance(q).toString());
    now_bal.setForeground(new Color(61,56,56));
    now_bal.setFont(new Font("Tahoma", Font.BOLD, 19));
    now_bal.setBounds(321, 96, 111, 35);
    cost_pan.add(now_bal);
    
    JLabel lblTotalCost = new JLabel("Total Cost ::");
    lblTotalCost.setForeground(new Color(61,56,56));
    lblTotalCost.setFont(new Font("Tahoma", Font.BOLD, 19));
    lblTotalCost.setBounds(442, 96, 129, 35);
    cost_pan.add(lblTotalCost);
    
    tot_cos = new JLabel("10.0");
    tot_cos.setForeground(new Color(61,56,56));
    tot_cos.setFont(new Font("Tahoma", Font.BOLD, 19));
    tot_cos.setBounds(581, 96, 111, 35);
    cost_pan.add(tot_cos);
    
    mem_panel = new JPanel();
    mem_panel.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		active.setText(Mem_info.active_mem());
    		inactive.setText(Mem_info.inactive_mem());
    		tot.setText(Mem_info.tot_mem());
    	}
    });
    mem_panel.setFocusable(false);
    mem_panel.setBackground(new Color(229,233,240));
    main.add(mem_panel, "name_39233053894742");
    mem_panel.setLayout(null);
    
    JButton btnNewButton = new JButton("");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		main.removeAll();
    		main.repaint();
    		main.revalidate();
    		
    		main.add(reg_mem);
    		main.repaint();
    		main.revalidate();
    	}
    });
    btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnNewButton.setBorderPainted(false);
    btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    btnNewButton.setFocusPainted(false);
    btnNewButton.setBackground(new Color(211,219,232));
    btnNewButton.setIcon(new ImageIcon(Main_view.class.getResource("/img/Add-User-Male_48px.png")));
    btnNewButton.setBounds(662, 26, 293, 48);
    mem_panel.add(btnNewButton);
    
    button = new JButton("");
    button.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		Admin a=new Admin();
    		a.setVisible(true);
    	}
    });
    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button.setBorderPainted(false);
    button.setIcon(new ImageIcon(Main_view.class.getResource("/img/Add-User-Malde_48px.png")));
    button.setFocusPainted(false);
    button.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    button.setBackground(new Color(211,219,232));
    button.setBounds(662, 85, 293, 48);
    mem_panel.add(button);
    
    lblActiveMember = new JLabel("Active Member ::");
    lblActiveMember.setForeground(Color.DARK_GRAY);
    lblActiveMember.setFont(new Font("Core Slab M", Font.PLAIN, 20));
    lblActiveMember.setBounds(662, 169, 171, 37);
    mem_panel.add(lblActiveMember);
    
    lblInactiveMember = new JLabel("InActive Member ::");
    lblInactiveMember.setForeground(Color.DARK_GRAY);
    lblInactiveMember.setFont(new Font("Core Slab M", Font.PLAIN, 20));
    lblInactiveMember.setBounds(662, 213, 171, 37);
    mem_panel.add(lblInactiveMember);
    
    lblTotalMember = new JLabel("Total Member ::");
    lblTotalMember.setForeground(Color.DARK_GRAY);
    lblTotalMember.setFont(new Font("Core Slab M", Font.PLAIN, 20));
    lblTotalMember.setBounds(662, 261, 171, 37);
    mem_panel.add(lblTotalMember);
    
    JLabel lblAllMembers = new JLabel("All Members");
    lblAllMembers.setBackground(Color.DARK_GRAY);
    lblAllMembers.setForeground(Color.DARK_GRAY);
    lblAllMembers.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblAllMembers.setBounds(278, 0, 208, 37);
    mem_panel.add(lblAllMembers);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
    scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
    scrollPane.setForeground(Color.PINK);
    scrollPane.getViewport().setBackground(new Color(229,233,240));
    scrollPane.setBackground(Color.CYAN);
    scrollPane.setBounds(28, 36, 624, 235);
    mem_panel.add(scrollPane);
    
    active_tab = new JTable();
    active_tab.setGridColor(new Color(229,233,240));
    active_tab.setBorder(new LineBorder(new Color(0, 0, 0)));
    active_tab.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    active_tab.setSelectionForeground(new Color(221,222,236));
    active_tab.setBackground(new Color(215,215,236));
    active_tab.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		int row=active_tab.getSelectedRow();
			
			String get_name=active_tab.getModel().getValueAt(row, 0).toString();
			String get_id_no=active_tab.getModel().getValueAt(row, 1).toString();
			String get_roll=active_tab.getModel().getValueAt(row, 2).toString();
			String get_reg=active_tab.getModel().getValueAt(row, 3).toString();
			String get_phone=active_tab.getModel().getValueAt(row, 4).toString();
			String get_adress=active_tab.getModel().getValueAt(row, 5).toString();
			String get_status=active_tab.getModel().getValueAt(row, 6).toString();
			String get_photo_path=active_tab.getModel().getValueAt(row, 7).toString();
			
			Profile_view Profile_view=new Profile_view();
	//		Profile_view.id.setText("sdf");
			
			
		

			Profile_view.buildGUI(get_name, get_id_no, get_roll, get_reg, get_phone, get_adress, get_status,get_photo_path);
			
			
    	}
    });
    scrollPane.setViewportView(active_tab);
    Mem_info.load_active();
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    scrollPane_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
    scrollPane_1.getViewport().setBackground(new Color(229,233,240));
    scrollPane_1.setBounds(28, 296, 624, 157);
    mem_panel.add(scrollPane_1);
    
    inactive_tab = new JTable();
    inactive_tab.setGridColor(new Color(229,233,240));
    inactive_tab.setBorder(new LineBorder(new Color(0, 0, 0)));
    inactive_tab.setBackground(new Color(215,215,236));
    inactive_tab.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
int rrow=inactive_tab.getSelectedRow();
			
			String inactive_get_name=inactive_tab.getModel().getValueAt(rrow, 0).toString();
			String inactive_get_id_no=inactive_tab.getModel().getValueAt(rrow, 1).toString();
			String inactive_get_roll=inactive_tab.getModel().getValueAt(rrow, 2).toString();
			String inactive_get_reg=inactive_tab.getModel().getValueAt(rrow, 3).toString();
			String inactive_get_phone=inactive_tab.getModel().getValueAt(rrow, 4).toString();
			String inactive_get_adress=inactive_tab.getModel().getValueAt(rrow, 5).toString();
			String inactive_get_status=inactive_tab.getModel().getValueAt(rrow, 6).toString();
			String inactive_get_photo_path=inactive_tab.getModel().getValueAt(rrow, 7).toString();
			
			System.out.println(inactive_get_name);
			Profile_view Profile_view=new Profile_view();
			
		

			Profile_view.buildGUI(inactive_get_name, inactive_get_id_no, inactive_get_roll, inactive_get_reg, inactive_get_phone, inactive_get_adress, inactive_get_status,inactive_get_photo_path);
    		
    	}
    });
    scrollPane_1.setViewportView(inactive_tab);
    
    lblActiveMembers = new JLabel("Active Members ::\r\n");
    lblActiveMembers.setForeground(Color.DARK_GRAY);
    lblActiveMembers.setFont(new Font("Calibri", Font.BOLD, 15));
    lblActiveMembers.setBounds(28, 11, 208, 37);
    mem_panel.add(lblActiveMembers);
    
    lblIanctiveMembers = new JLabel("Inactive Members ::");
    lblIanctiveMembers.setForeground(Color.DARK_GRAY);
    lblIanctiveMembers.setFont(new Font("Calibri", Font.BOLD, 15));
    lblIanctiveMembers.setBounds(28, 263, 208, 37);
    mem_panel.add(lblIanctiveMembers);
    
    active = new JLabel("");
    active.setText(Mem_info.active_mem());
    active.setForeground(new Color(215,215,236));
    active.setFont(new Font("Core Slab M", Font.PLAIN, 20));
    active.setBounds(851, 169, 94, 37);
    mem_panel.add(active);
    
    inactive = new JLabel("");
    inactive.setText(Mem_info.inactive_mem());
    inactive.setForeground(new Color(215,215,236));
    inactive.setFont(new Font("Core Slab M", Font.PLAIN, 20));
    inactive.setBounds(881, 213, 74, 37);
    mem_panel.add(inactive);
    
    tot = new JLabel("");
    tot.setText(Mem_info.tot_mem());
    tot.setForeground(new Color(215,215,236));
    tot.setFont(new Font("Core Slab M", Font.PLAIN, 20));
    tot.setBounds(835, 261, 94, 37);
    mem_panel.add(tot);
    Mem_info.load_inactive();
    
    report_panel = new JPanel();
    report_panel.setBackground(new Color(229,233,240));
    main.add(report_panel, "name_60352729605588");
    report_panel.setLayout(null);
    
    JLabel lblPerMealPrice = new JLabel("Per Meal Price ::");
    lblPerMealPrice.setForeground(new Color(54,54,54));
    lblPerMealPrice.setFont(new Font("Tahoma", Font.BOLD, 19));
    lblPerMealPrice.setBounds(279, 39, 155, 35);
    report_panel.add(lblPerMealPrice);
    
    per_meal = new JTextField();
    per_meal.setForeground(Color.DARK_GRAY);
    per_meal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    per_meal.setColumns(10);
    per_meal.setCaretColor(Color.DARK_GRAY);
    per_meal.setBorder(null);
    per_meal.setBackground(new Color(229,233,240));
    per_meal.setBounds(444, 39, 83, 35);
    report_panel.add(per_meal);
    
    JSeparator separator_5 = new JSeparator();
    separator_5.setForeground(new Color(54,54,54));
    separator_5.setBackground(new Color(54,54,54));
    separator_5.setBounds(444, 75, 83, 17);
    report_panel.add(separator_5);
    
    JLabel label_6 = new JLabel("Date ::");
    label_6.setForeground(new Color(54,54,54));
    label_6.setFont(new Font("Tahoma", Font.BOLD, 19));
    label_6.setBounds(32, 51, 70, 35);
    report_panel.add(label_6);
    
    dateChooser_rep = new JDateChooser();
    dateChooser_rep.setBorder(new LineBorder(Color.LIGHT_GRAY));
    dateChooser_rep.setBackground(Color.LIGHT_GRAY);
    dateChooser_rep.getCalendarButton().addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    	}
    });
    dateChooser_rep.getCalendarButton().setBackground(new Color(211,219,232));
    dateChooser_rep.getCalendarButton().setForeground(Color.LIGHT_GRAY);
    Date date_rep=new Date();
    dateChooser_rep.setDate(date_rep);
    
    dateChooser_rep.addPropertyChangeListener(new PropertyChangeListener() {
    	public void propertyChange(PropertyChangeEvent arg0) {
    		
    		Date d=dateChooser_rep.getDate();	
        	
    		DateFormat dafm=new SimpleDateFormat("YYYY/MM");

			String a=dafm.format(d);
			per_meal.setText(Reports.per_meal_price(a));
			tot_meal.setText(Reports.total_meal(a));
			
			
			

    	}
    });
    dateChooser_rep.setBounds(102, 39, 129, 54);
    report_panel.add(dateChooser_rep);
    
    tot_meal = new JTextField();
    tot_meal.setForeground(Color.DARK_GRAY);
    tot_meal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    tot_meal.setColumns(10);
    tot_meal.setCaretColor(Color.DARK_GRAY);
    tot_meal.setBorder(null);
    tot_meal.setBackground(new Color(229,233,240));
    tot_meal.setBounds(702, 39, 83, 35);
    report_panel.add(tot_meal);
    
    JSeparator separator_17 = new JSeparator();
    separator_17.setForeground(new Color(54,54,54));
    separator_17.setBackground(new Color(54,54,54));
    separator_17.setBounds(702, 75, 83, 17);
    report_panel.add(separator_17);
    
    JLabel lblTotalMeal = new JLabel("Total Meal ::");
    lblTotalMeal.setForeground(new Color(54,54,54));
    lblTotalMeal.setFont(new Font("Tahoma", Font.BOLD, 19));
    lblTotalMeal.setBounds(537, 39, 155, 35);
    report_panel.add(lblTotalMeal);
    
    JScrollPane scrollPane_5 = new JScrollPane();
    scrollPane_5.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
    scrollPane_5.getViewport().setBackground(new Color(229,233,240));
    scrollPane_5.setBounds(77, 146, 750, 307);
    report_panel.add(scrollPane_5);
    
    rep_tab = new JTable();
    rep_tab.setGridColor(new Color(229,233,240));
    rep_tab.setBorder(new LineBorder(new Color(0, 0, 0)));
    rep_tab.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    rep_tab.setSelectionForeground(new Color(221,222,236));
    rep_tab.setBackground(new Color(215,215,236));
    rep_tab.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
int rrow=rep_tab.getSelectedRow();
			
			String rep_get_name=rep_tab.getModel().getValueAt(rrow, 0).toString();
			String rep_get_id_no=rep_tab.getModel().getValueAt(rrow, 1).toString();
			
			Report 			Report=new 			Report();
			Report.name_r.setText(rep_get_name);
			Report.id_r.setText(rep_get_id_no);
			
			Report.setVisible(true);
			
    	}
    });
    scrollPane_5.setViewportView(rep_tab);
    
    JLabel lblClickOnA = new JLabel("Click on a member to find full report");
    lblClickOnA.setForeground(new Color(54,54,54));
    lblClickOnA.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblClickOnA.setBounds(77, 114, 260, 35);
    report_panel.add(lblClickOnA);
    Reports.load_active();
    
    setting_panel = new JPanel();
    setting_panel.setBackground(new Color(229,233,240));
    main.add(setting_panel, "name_65445993321208");
    setting_panel.setLayout(null);
    
    JButton btnNewButton_2 = new JButton("");
    btnNewButton_2.setForeground(new Color(184, 134, 11));
    
    JFileChooser jfc=new JFileChooser();
    
    btnNewButton_2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		//jfc.setCurrentDirectory(new java.io.File("user.home"));
    		
    		String file_pth = null;
    		
            jfc.setDialogTitle("Save Location");
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.setCurrentDirectory(new File(System.getProperty("user.name")));
            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file_pth= jfc.getSelectedFile().getAbsolutePath();
                
                String currentDir = System.getProperty("user.dir");
                
                File source = new File(currentDir+"/DB/Meal_lab.sqlite");
                File dest = new File(file_pth+"/Meal_lab.sqlite");
                try {
                    FileUtils.copyFile(source, dest);
                    JOptionPane.showMessageDialog(null, "File Saved in this location");
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "BackUp Failed !!!");
                }
            }
            
            
    	}
    });
    btnNewButton_2.setIcon(new ImageIcon(Main_view.class.getResource("/img/Data-Backup_80px.png")));
    btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnNewButton_2.setBackground(new Color(211,219,232));
    btnNewButton_2.setBounds(88, 78, 205, 147);
    setting_panel.add(btnNewButton_2);
    
    JFileChooser jc=new JFileChooser();
    
    JButton button_2 = new JButton("");
    button_2.setForeground(new Color(184, 134, 11));
    button_2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		
    		Import obj=new Import(null);
    		obj.setVisible(true);
    		
    		
    		/*
    		String file_pt = null;
    		
    		 FileFilter filter = new FileNameExtensionFilter("sqlite", new String[] {"sqlite"});
			jc.setFileFilter(filter);
    		jc.setDialogTitle("Import file");
            jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            jc.setCurrentDirectory(new File(System.getProperty("user.name")));
            if (jc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file_pt= jc.getSelectedFile().getAbsolutePath();
            }
            System.out.println(file_pt);
            Path source = Paths.get(file_pt);
            Path dest = Paths.get("C://Program Files//RF's Programme//Meal Lab//Meal_lab.sqlite");
            try {
                Files.copy(source, dest,StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "File Saved in this location");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Import Failed !!!");
            }
            */
            
    	}
    });
    button_2.setIcon(new ImageIcon(Main_view.class.getResource("/img/Data-Backuxp_80px.png")));
    button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button_2.setBackground(new Color(211,219,232));
    button_2.setBounds(397, 78, 205, 147);
    setting_panel.add(button_2);
    
    JButton button_3 = new JButton("");
    button_3.setForeground(new Color(211,219,232));
    button_3.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		Support obj=new Support(null);
    		obj.setVisible(true);
    		
    	}
    });
    button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button_3.setBackground(new Color(211,219,232));
    button_3.setIcon(new ImageIcon(Main_view.class.getResource("/img/Customer-Support_70px.png")));
    button_3.setBounds(707, 78, 205, 147);
    setting_panel.add(button_3);
    
    JButton btnAbout = new JButton("ABOUT");
    btnAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnAbout.setBackground(new Color(211,219,232));
    btnAbout.setForeground(Color.DARK_GRAY);
    btnAbout.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		About a=new About();
    		a.setVisible(true);
    	}
    });
    btnAbout.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnAbout.setIcon(new ImageIcon(Main_view.class.getResource("/img/Info_30px.png")));
    btnAbout.setBounds(785, 414, 127, 39);
    setting_panel.add(btnAbout);
    
    btnResetAndDelete = new JButton("Reset and Delete all in Database");
    btnResetAndDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnResetAndDelete.setBackground(new Color(211,219,232));
    btnResetAndDelete.setForeground(new Color(153, 0, 0));
    btnResetAndDelete.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		Dlt_Confirm obj=new Dlt_Confirm(null);
    		obj.setVisible(true);
    	}
    });
    btnResetAndDelete.setIcon(new ImageIcon(Main_view.class.getResource("/img/Minus_30px.png")));
    btnResetAndDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
    btnResetAndDelete.setBounds(472, 414, 286, 39);
    setting_panel.add(btnResetAndDelete);
    
    
    String z=Allow_log.show_chk();
    System.out.println();
    if(z.equals("")){
    	//alw_log.setVisible(false);
    }
    else{
    	
    	alw_log = new JCheckBox("Allow Login Option");
        alw_log.setFont(new Font("Tahoma", Font.BOLD, 17));
        alw_log.setForeground(new Color(54,54,54));
        alw_log.setBackground(new Color(211,219,232));
        
        String c=Allow_log.chek_log();
        if(c.equals("active")){
        	alw_log.setSelected(true);
        }
        
        alw_log.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(alw_log.isSelected()==true){
        			Allow_log.active();
        			JOptionPane.showMessageDialog(null, "Login Option On.........Check your ID and Password in Admin panel");
        		}
        		else if(alw_log.isSelected()==false){
        			Allow_log.inactive();
        			JOptionPane.showMessageDialog(null, "Login Option Turn Off Successfully !!!");
        		}
        	}
        });
        alw_log.setBounds(397, 313, 205, 23);
        setting_panel.add(alw_log);
    	
    	
    }
    
    reg_mem = new JPanel();
    reg_mem.setBackground(new Color(229,233,240));
    main.add(reg_mem, "name_6051106241113");
    reg_mem.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("New Member Registration__");
    lblNewLabel.setForeground(Color.DARK_GRAY);
    lblNewLabel.setFont(new Font("Oswald", Font.PLAIN, 24));
    lblNewLabel.setBounds(115, 2, 272, 49);
    reg_mem.add(lblNewLabel);
    
    photo_label = new JLabel("");
    photo_label.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(215,215,236)));
    photo_label.setForeground(Color.MAGENTA);
    photo_label.setBackground(new Color(153, 204, 255));
    photo_label.setBounds(93, 83, 294, 259);
    reg_mem.add(photo_label);
    
    JButton btnNewButton_1 = new JButton("Add Photo");
    btnNewButton_1.setForeground(Color.DARK_GRAY);
    btnNewButton_1.setBackground(new Color(203,211,225));
    btnNewButton_1.setFocusPainted(false);
    JFileChooser fc = new JFileChooser();
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		//fc.setCurrentDirectory(new java.io.File("user.home"));
    		
            fc.setDialogTitle("Select a Photo");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.setCurrentDirectory(new File(System.getProperty("user.name")));
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file_path= fc.getSelectedFile().getAbsolutePath();
            }
            
            path_t.setText(file_path);
			
            //input image and set label size
            BufferedImage img = null;
            try {
            	
                img = ImageIO.read(new File(file_path));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
            Image dimg = img.getScaledInstance(photo_label.getWidth(), photo_label.getHeight(),
                    Image.SCALE_SMOOTH);
            
			photo_label.setIcon(new ImageIcon(dimg));
    	}
    });
    btnNewButton_1.setBounds(298, 368, 110, 23);
    reg_mem.add(btnNewButton_1);
    
    path_t = new JTextField();
    path_t.setForeground(Color.DARK_GRAY);
    path_t.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    path_t.setBackground(new Color(203,211,225));
    path_t.setCaretColor(new Color(153, 204, 255));
    path_t.setDisabledTextColor(Color.MAGENTA);
    path_t.setEditable(false);
    path_t.setBounds(93, 369, 195, 20);
    reg_mem.add(path_t);
    path_t.setColumns(10);
    
    JSeparator separator = new JSeparator();
    separator.setBackground(new Color(0, 0, 51));
    separator.setForeground(new Color(215,215,236));
    separator.setBounds(115, 49, 272, 12);
    reg_mem.add(separator);
    
    JLabel lblName = new JLabel("Name :");
    lblName.setForeground(new Color(61,56,56));
    lblName.setFont(new Font("Code Pro", Font.PLAIN, 17));
    lblName.setBounds(490, 83, 55, 23);
    reg_mem.add(lblName);
    
    JLabel lblRoll = new JLabel("Roll No :");
    lblRoll.setForeground(new Color(61,56,56));
    lblRoll.setFont(new Font("Code Pro", Font.PLAIN, 17));
    lblRoll.setBounds(490, 130, 78, 23);
    reg_mem.add(lblRoll);
    
    lblRegNo = new JLabel("REG No :");
    lblRegNo.setForeground(new Color(61,56,56));
    lblRegNo.setFont(new Font("Code Pro", Font.PLAIN, 17));
    lblRegNo.setBounds(730, 130, 78, 23);
    reg_mem.add(lblRegNo);
    
    lblAdress = new JLabel("Adress :");
    lblAdress.setForeground(new Color(61,56,56));
    lblAdress.setFont(new Font("Code Pro", Font.PLAIN, 17));
    lblAdress.setBounds(490, 189, 91, 23);
    reg_mem.add(lblAdress);
    
    lblPhoneNo = new JLabel("Phone No :");
    lblPhoneNo.setForeground(new Color(61,56,56));
    lblPhoneNo.setFont(new Font("Code Pro", Font.PLAIN, 17));
    lblPhoneNo.setBounds(490, 312, 102, 23);
    reg_mem.add(lblPhoneNo);
    
    lblIdNo = new JLabel("ID No :");
    lblIdNo.setForeground(new Color(61,56,56));
    lblIdNo.setFont(new Font("Code Pro", Font.PLAIN, 17));
    lblIdNo.setBounds(730, 83, 55, 23);
    reg_mem.add(lblIdNo);
    
    name_t = new JTextField();
    name_t.setFont(new Font("Tahoma", Font.PLAIN, 17));
    name_t.setBorder(null);
    name_t.setCaretColor(Color.DARK_GRAY);
    name_t.setBackground(new Color(229,233,240));
    name_t.setForeground(Color.DARK_GRAY);
    name_t.setBounds(551, 83, 169, 20);
    reg_mem.add(name_t);
    name_t.setColumns(10);
    
    separator_1 = new JSeparator();
    separator_1.setForeground(new Color(215,215,236));
    separator_1.setBackground(new Color(0, 0, 51));
    separator_1.setBounds(551, 103, 169, 12);
    reg_mem.add(separator_1);
    
    roll_t = new JTextField();
    roll_t.setFont(new Font("Tahoma", Font.PLAIN, 17));
    roll_t.setForeground(Color.DARK_GRAY);
    roll_t.setColumns(10);
    roll_t.setCaretColor(Color.DARK_GRAY);
    roll_t.setBorder(null);
    roll_t.setBackground(new Color(229,233,240));
    roll_t.setBounds(572, 130, 152, 20);
    reg_mem.add(roll_t);
    
    separator_2 = new JSeparator();
    separator_2.setForeground(new Color(215,215,236));
    separator_2.setBackground(new Color(0, 0, 51));
    separator_2.setBounds(572, 150, 152, 12);
    reg_mem.add(separator_2);
    
    id_t = new JTextField();
    id_t.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String id=id_t.getText();
    		String a=Meal.giv_id_get_nam(id);
    		if(a.equals("")){
    		 exist.setVisible(false);
    		 mem_sav.setEnabled(true);
    		}
    		else{
    			exist.setVisible(true);
       		 mem_sav.setEnabled(false);
    		}
    	}
    });
    id_t.setFont(new Font("Tahoma", Font.PLAIN, 17));
    id_t.setForeground(Color.DARK_GRAY);
    id_t.setColumns(10);
    id_t.setCaretColor(Color.DARK_GRAY);
    id_t.setBorder(null);
    id_t.setBackground(new Color(229,233,240));
    id_t.setBounds(786, 83, 106, 20);
    reg_mem.add(id_t);
    
    separator_3 = new JSeparator();
    separator_3.setForeground(new Color(215,215,236));
    separator_3.setBackground(new Color(0, 0, 51));
    separator_3.setBounds(786, 103, 106, 12);
    reg_mem.add(separator_3);
    
    reg_t = new JTextField();
    reg_t.setFont(new Font("Tahoma", Font.PLAIN, 17));
    reg_t.setForeground(Color.DARK_GRAY);
    reg_t.setColumns(10);
    reg_t.setCaretColor(Color.DARK_GRAY);
    reg_t.setBorder(null);
    reg_t.setBackground(new Color(229,233,240));
    reg_t.setBounds(796, 130, 106, 20);
    reg_mem.add(reg_t);
    
    separator_4 = new JSeparator();
    separator_4.setForeground(new Color(215,215,236));
    separator_4.setBackground(new Color(0, 0, 51));
    separator_4.setBounds(796, 150, 106, 12);
    reg_mem.add(separator_4);
    
    phone_t = new JTextField();
    phone_t.setFont(new Font("Tahoma", Font.PLAIN, 17));
    phone_t.setForeground(Color.DARK_GRAY);
    phone_t.setColumns(10);
    phone_t.setCaretColor(Color.DARK_GRAY);
    phone_t.setBorder(null);
    phone_t.setBackground(new Color(229,233,240));
    phone_t.setBounds(587, 312, 169, 20);
    reg_mem.add(phone_t);
    
    separator_6 = new JSeparator();
    separator_6.setForeground(new Color(215,215,236));
    separator_6.setBackground(new Color(0, 0, 51));
    separator_6.setBounds(587, 332, 169, 12);
    reg_mem.add(separator_6);
    
    adress_t = new JTextArea();
    adress_t.setFont(new Font("Tahoma", Font.PLAIN, 17));
    adress_t.setForeground(new Color(102, 204, 255));
    adress_t.setBorder(null);
    adress_t.setCaretColor(Color.DARK_GRAY);
    adress_t.setBackground(new Color(203,211,225));
    adress_t.setBounds(572, 190, 288, 111);
    reg_mem.add(adress_t);
    
    mem_sav = new JButton("SAVE");
    mem_sav.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		if(name_t.getText().trim().isEmpty()||
    				id_t.getText().trim().isEmpty()||
    				roll_t.getText().trim().isEmpty()||
    				reg_t.getText().trim().isEmpty()||
    				phone_t.getText().trim().isEmpty()||
    				adress_t.getText().trim().isEmpty()||
    				path_t.getText().trim().isEmpty())   {JOptionPane.showMessageDialog(null, "Please,Give All Information");
    			
    		}
    		else{
    			String name=name_t.getText();
        		String id=id_t.getText();
        		String roll=roll_t.getText();
        		String reg=reg_t.getText();
        		String phn=phone_t.getText();
        		String adress=adress_t.getText();
        		String path=path_t.getText();
        		
        		
        		Double balance=0.0;
        
        		
        		new File("E://Dont Delete this file ,Meallab software data store").mkdir();
        		
        		File fileToCopy = new File(path);
        	    File newFile = new File("E:/Dont Delete this file ,Meallab software data store/"+name+"_"+id+".jpg");
        	    		
 
        		try{
        		Files.copy(fileToCopy.toPath(),newFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
        		//FileUtils.copyFile(fileToCopy,newFile);
        		}
        		catch(IOException e){
        			e.printStackTrace();
        		}
        	
 
        		name_t.setText("");
        		id_t.setText("");
        		roll_t.setText("");
        		reg_t.setText("");
        		phone_t.setText("");
        		adress_t.setText("");
        		path_t.setText("");
        		photo_label.setIcon(null);
        		
        		Mem_info_con Mem_info_con=new Mem_info_con();
        		String new_path=("E:/Dont Delete this file ,Meallab software data store/"+name+"_"+id+".jpg");
        		
        		Mem_info_con.insert_mem_info(name,id,roll,reg,phn,adress,new_path);
        		
        		
        	//	Balance.load_balance();
        		Mem_info.load_active();
        		
        		
        		
    		}
    		active.setText(Mem_info.active_mem());
    		inactive.setText(Mem_info.inactive_mem());
    		tot.setText(Mem_info.tot_mem());
    		
    	}
    });
    mem_sav.setFocusPainted(false);
    mem_sav.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    mem_sav.setBackground(new Color(203,211,225));
    mem_sav.setBorderPainted(false);
    mem_sav.setFont(new Font("Tahoma", Font.BOLD, 20));
    mem_sav.setBounds(803, 351, 99, 56);
    reg_mem.add(mem_sav);
    
    JLabel lblBack = new JLabel("Back");
    lblBack.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		main.removeAll();
    		main.repaint();
    		main.revalidate();
    		
    		main.add(mem_panel);
    		main.repaint();
    		main.revalidate();
    	}
    });
    lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblBack.setBackground(new Color(51, 204, 102));
    lblBack.setForeground(new Color(61,56,56));
    lblBack.setIcon(new ImageIcon(Main_view.class.getResource("/img/Back_48px.png")));
    lblBack.setBounds(1, 11, 95, 49);
    reg_mem.add(lblBack);
    
    exist = new JLabel("\u263B ID No Already Exist !!!");
    exist.setVisible(false);
    exist.setFont(new Font("Tahoma", Font.PLAIN, 13));
    exist.setForeground(new Color(255, 0, 51));
    exist.setBounds(755, 42, 147, 30);
    reg_mem.add(exist);
    
    title = new JLabel("");
    title.setIcon(new ImageIcon(Main_view.class.getResource("/img/meal-lab.png")));
    title.setBounds(403, 1, 218, 50);
    f.getContentPane().add(title);
    f.setVisible(true);
    f.getContentPane().addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
    	 f.setOpacity(0.80f);
        resizing = f.getCursor().equals(Cursor.getDefaultCursor())? false:true;
        if(!e.isMetaDown()){
          point.x = e.getX();
          point.y = e.getY();
        }
      }
    	@Override
    	public void mouseReleased(MouseEvent e) {
    		f.setOpacity(1f);
    	}
    });
    f.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        if(resizing){
          Point pt = e.getPoint();
          f.setSize(f.getWidth()+pt.x - point.x,f.getHeight());
          point.x = pt.x;
        }
        else if(!e.isMetaDown()){
        Point p = f.getLocation();
        f.setLocation(p.x + e.getX() - point.x,
            p.y + e.getY() - point.y);
        }
      }
      
      //Resizeable
      
      public void mouseMoved(MouseEvent me){
        Point cursorLocation = me.getPoint();
        int xPos = cursorLocation.x;
        int yPos = cursorLocation.y;
  //      if(xPos < 5) f.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
  //      else if(xPos > f.getContentPane().getWidth()-5) f.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
     //   else if(yPos < 5) f.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
    //    else if(yPos > f.getContentPane().getHeight()-5) f.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
    //    else if(f.getCursor().equals(Cursor.getDefaultCursor()) == false) f.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    });
  }
  
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new Main_view().buildGUI();
      }
    });
  }
}