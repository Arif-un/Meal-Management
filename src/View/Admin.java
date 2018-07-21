package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import Model.Admins;
import Model.Meal;
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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JLabel id_wrong;
	private JButton button;
	public static JTable table;
	private JButton btnD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Admin dialog = new Admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arifu\\Desktop\\Meal Lab\\Meal-labb.png"));
		setTitle("Admin Panel");
		setBounds(100, 100, 799, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(23, 25, 35));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblFrom = new JLabel("List of Admin");
		lblFrom.setForeground(new Color(248, 46, 0));
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(10, 80, 129, 23);
		contentPanel.add(lblFrom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 646, 291);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row=table.getSelectedRow();
				
				String get_name=table.getModel().getValueAt(row, 0).toString();
				String get_id_no=table.getModel().getValueAt(row, 1).toString();
				
				
				
			}
		});
		scrollPane.setViewportView(table);
		Admins.load_admin();
		
		JLabel lblMakeNew = new JLabel("Make new ");
		lblMakeNew.setForeground(new Color(248, 46, 0));
		lblMakeNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMakeNew.setBounds(10, 11, 129, 35);
		contentPanel.add(lblMakeNew);
		
		JLabel lblMemberId = new JLabel("Member Id :");
		lblMemberId.setForeground(new Color(248, 46, 0));
		lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMemberId.setBounds(170, 43, 129, 23);
		contentPanel.add(lblMemberId);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(248, 46, 0));
		separator.setBackground(new Color(248, 46, 0));
		separator.setBounds(293, 77, 180, 17);
		contentPanel.add(separator);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String id=textField.getText();
	    		String a=Meal.giv_id_get_nam(id);
	    		if(a.equals("")){
	    		 id_wrong.setVisible(true);
	    		 button.setEnabled(false);
	    		}
	    		else{
	    			id_wrong.setVisible(false);
		    		 button.setEnabled(true);
	    		}
			}
		});
		textField.setForeground(new Color(102, 204, 255));
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setCaretColor(new Color(153, 204, 255));
		textField.setBorder(null);
		textField.setBackground(new Color(23, 25, 35));
		textField.setBounds(293, 39, 180, 35);
		contentPanel.add(textField);
		
		id_wrong = new JLabel("\u25A0 INVALID ID");
		id_wrong.setVisible(false);
		id_wrong.setForeground(new Color(248, 46, 0));
		id_wrong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		id_wrong.setBounds(306, 11, 129, 35);
		contentPanel.add(id_wrong);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(102, 204, 255));
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setCaretColor(new Color(153, 204, 255));
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(23, 25, 35));
		textField_1.setBounds(598, 39, 170, 35);
		contentPanel.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(248, 46, 0));
		separator_1.setBackground(new Color(248, 46, 0));
		separator_1.setBounds(598, 77, 170, 17);
		contentPanel.add(separator_1);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(248, 46, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPassword.setBounds(483, 43, 129, 23);
		contentPanel.add(lblPassword);
		
		button = new JButton("SAVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id=textField.getText();
				String pass=textField_1.getText();
				
				String name=Meal.giv_id_get_nam(id);
				
				Admins.add_meal(name, id, pass);
				Admins.load_admin();
				
				
			}
		});
		button.setFont(new Font("Nasalization", Font.PLAIN, 25));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBackground(new Color(51, 153, 255));
		button.setBounds(669, 113, 99, 35);
		contentPanel.add(button);
		
		btnD = new JButton("DELETE");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int row=table.getSelectedRow();
				
				String get_name=table.getModel().getValueAt(row, 0).toString();
				String get_id_no=table.getModel().getValueAt(row, 1).toString();
				System.out.println(get_id_no);
				Admins.dlt_admin(get_id_no);
				Admins.load_admin();
			}
		});
		btnD.setFont(new Font("Nasalization", Font.PLAIN, 18));
		btnD.setFocusPainted(false);
		btnD.setBorderPainted(false);
		btnD.setBackground(new Color(51, 153, 255));
		btnD.setBounds(669, 170, 99, 35);
		contentPanel.add(btnD);
	}
}
