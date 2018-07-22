package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import Model.Reports;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Report extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable rep_tab;
	private JLabel tot_din;
	private JLabel tot_lun;
	private JLabel tot_bf;
	private JDateChooser DC_2;
	private JDateChooser DC;
	public static JLabel id_r;
	private JLabel tot;
	public static JLabel name_r;
	private JLabel amnt;
	private JLabel pd;
	private JLabel du;
	public  static JTable fund_tab;
	public static JTable cost_tab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Report dialog = new Report();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Report() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arifu\\Desktop\\Meal Lab\\Meal-labb.png"));
		setTitle("Reports");
		setBounds(100, 100, 799, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(23, 25, 35));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		DC = new JDateChooser();
		DC.setBounds(29, 33, 129, 35);
		contentPanel.add(DC);
		
		DC_2 = new JDateChooser();
		DC_2.setBounds(205, 33, 129, 35);
		contentPanel.add(DC_2);
		
		JLabel lblFrom = new JLabel("From _");
		lblFrom.setForeground(new Color(248, 46, 0));
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblFrom.setBounds(29, 0, 129, 35);
		contentPanel.add(lblFrom);
		
		JLabel lblto = new JLabel("_to");
		lblto.setForeground(new Color(248, 46, 0));
		lblto.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblto.setBounds(205, 0, 129, 35);
		contentPanel.add(lblto);
		
		JLabel label_2 = new JLabel("---");
		label_2.setForeground(new Color(248, 46, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_2.setBounds(168, 33, 46, 35);
		contentPanel.add(label_2);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(id_r.getText().equals("")||DC.getDate().toString().equals("")||DC_2.getDate().toString().equals("")){
				JOptionPane.showMessageDialog(null, "Invadid Seach");
			}
				else{
					String id=id_r.getText();
					
					 DateFormat dfm=new SimpleDateFormat("YYYY/MM/dd");
			    		Date d1=DC.getDate();
			    		Date d2=DC_2.getDate();
			    		String da1=dfm.format(d1);
			    		String da2=dfm.format(d2);
			    		
			    	DateFormat dm=new SimpleDateFormat("YYYY/MM");

		    		String dm1=dm.format(d1);
		    		String dm2=dm.format(d2);
		    		

		    		double amount=Reports.total_amnt(dm1, dm2, dm1, dm2, id, da1, da2); 
		    		
		    		System.out.println(dm1+ dm2+ dm1+ dm2+ id+ da1+ da2);
		    		String amont = Double.toString(amount);
		    		amnt.setText(amont);
		    		
		    		du.setText(Reports.due(id,da1, da2, dm1, dm2, dm1, dm2, id, da1, da2));
		    		
			    		pd.setText(Reports.paid(id,da1,da2));
			    		tot_bf.setText(Reports.total_bf(id, da1, da2));
			    		tot_lun.setText(Reports.total_lun(id, da1, da2));
			    		tot_din.setText(Reports.total_dnr(id, da1, da2));
			    		tot.setText(Reports.total_meal(id, da1, da2));
			    		
			    		
			    		Reports.load_fund(id, da1, da2);
			    		Reports.load_cost(da1, da2);
			    		Reports.load_meal(id, da1, da2);
		
				}
			}
		});
		
		button.setBackground(new Color(48, 51, 67));
		button.setIcon(new ImageIcon(Report.class.getResource("/img/fsdf.png")));
		button.setBounds(348, 23, 89, 45);
		contentPanel.add(button);
		
		JLabel lblName = new JLabel("Name ::");
		lblName.setForeground(new Color(248, 46, 0));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblName.setBounds(493, 6, 82, 23);
		contentPanel.add(lblName);
		
		JLabel lblId = new JLabel("ID ::");
		lblId.setForeground(new Color(248, 46, 0));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblId.setBounds(520, 39, 48, 23);
		contentPanel.add(lblId);
		
		name_r = new JLabel("");
		name_r.setForeground(new Color(248, 46, 0));
		name_r.setFont(new Font("Tahoma", Font.BOLD, 19));
		name_r.setBounds(578, 6, 89, 23);
		contentPanel.add(name_r);
		
		id_r = new JLabel("");
		id_r.setForeground(new Color(248, 46, 0));
		id_r.setFont(new Font("Tahoma", Font.BOLD, 19));
		id_r.setBounds(577, 39, 73, 23);
		contentPanel.add(id_r);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				scrollPane_1.setBounds(153, 80, 224, 325);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				scrollPane_1.setBounds(153, 80, 155, 325);
			}
		});
		scrollPane_1.setBounds(153, 80, 155, 325);
		contentPanel.add(scrollPane_1);
		
		cost_tab = new JTable();
		cost_tab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		scrollPane_1.setViewportView(cost_tab);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(316, 80, 308, 325);
		contentPanel.add(scrollPane);
		
		rep_tab = new JTable();
		scrollPane.setViewportView(rep_tab);
		
		JLabel lblName_1 = new JLabel("Breakfast :");
		lblName_1.setForeground(new Color(248, 46, 0));
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName_1.setBounds(631, 94, 95, 23);
		contentPanel.add(lblName_1);
		
		JLabel lblLunch = new JLabel("Lunch :");
		lblLunch.setForeground(new Color(248, 46, 0));
		lblLunch.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLunch.setBounds(634, 128, 73, 23);
		contentPanel.add(lblLunch);
		
		JLabel lblDinner = new JLabel("Dinner :");
		lblDinner.setForeground(new Color(248, 46, 0));
		lblDinner.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDinner.setBounds(634, 162, 73, 23);
		contentPanel.add(lblDinner);
		
		tot_bf = new JLabel("");
		tot_bf.setForeground(new Color(248, 46, 0));
		tot_bf.setFont(new Font("Tahoma", Font.BOLD, 16));
		tot_bf.setBounds(727, 94, 46, 23);
		contentPanel.add(tot_bf);
		
		tot_lun = new JLabel("");
		tot_lun.setForeground(new Color(248, 46, 0));
		tot_lun.setFont(new Font("Tahoma", Font.BOLD, 16));
		tot_lun.setBounds(697, 128, 46, 23);
		contentPanel.add(tot_lun);
		
		tot_din = new JLabel("");
		tot_din.setForeground(new Color(248, 46, 0));
		tot_din.setFont(new Font("Tahoma", Font.BOLD, 16));
		tot_din.setBounds(707, 162, 46, 23);
		contentPanel.add(tot_din);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setForeground(new Color(248, 46, 0));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(634, 201, 73, 23);
		contentPanel.add(lblTotal);
		
		tot = new JLabel("");
		tot.setForeground(new Color(248, 46, 0));
		tot.setFont(new Font("Tahoma", Font.BOLD, 16));
		tot.setBounds(697, 201, 46, 23);
		contentPanel.add(tot);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setForeground(new Color(248, 46, 0));
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmount.setBounds(631, 246, 76, 23);
		contentPanel.add(lblAmount);
		
		amnt = new JLabel("");
		amnt.setForeground(new Color(248, 46, 0));
		amnt.setFont(new Font("Tahoma", Font.BOLD, 16));
		amnt.setBounds(707, 246, 66, 23);
		contentPanel.add(amnt);
		
		JLabel lblPaid = new JLabel("Paid :");
		lblPaid.setForeground(new Color(248, 46, 0));
		lblPaid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPaid.setBounds(634, 281, 53, 23);
		contentPanel.add(lblPaid);
		
		pd = new JLabel("");
		pd.setForeground(new Color(248, 46, 0));
		pd.setFont(new Font("Tahoma", Font.BOLD, 16));
		pd.setBounds(687, 281, 89, 23);
		contentPanel.add(pd);
		
		du = new JLabel("");
		du.setForeground(new Color(248, 46, 0));
		du.setFont(new Font("Tahoma", Font.BOLD, 16));
		du.setBounds(674, 318, 89, 23);
		contentPanel.add(du);
		
		JLabel lblDue = new JLabel("Due :");
		lblDue.setForeground(new Color(248, 46, 0));
		lblDue.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDue.setBounds(631, 318, 46, 23);
		contentPanel.add(lblDue);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 79, 133, 325);
		contentPanel.add(scrollPane_2);
		
		fund_tab = new JTable();
		scrollPane_2.setViewportView(fund_tab);
	}
}
