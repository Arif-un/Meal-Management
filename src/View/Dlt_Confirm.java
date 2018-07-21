package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Model.Mem_info;
import Model.Reports;

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Dlt_Confirm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dlt_Confirm frame = new Dlt_Confirm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param idd 
	 */
	public Dlt_Confirm(String idd) {
		setTitle("Confirm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 348, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221,222,236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("Yes");
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reports.reset();


			}
		});
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
		btnOk.setFocusPainted(false);
		btnOk.setBorderPainted(false);
		btnOk.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
		btnOk.setBackground(Color.LIGHT_GRAY);
		btnOk.setBounds(52, 127, 95, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dlt_Confirm.this.dispose();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(170, 128, 95, 23);
		contentPane.add(btnCancel);
		
		JLabel lblAreYouSure = new JLabel("Are You Sure !!!! ");
		lblAreYouSure.setForeground(new Color(0, 153, 255));
		lblAreYouSure.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 16));
		lblAreYouSure.setBounds(100, 78, 178, 14);
		contentPane.add(lblAreYouSure);
		
		JLabel lblItWillDelete = new JLabel("IT Will Delete All of Records in Database !!!");
		lblItWillDelete.setForeground(new Color(255, 0, 0));
		lblItWillDelete.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 17));
		lblItWillDelete.setBounds(10, 34, 312, 33);
		contentPane.add(lblItWillDelete);
	}
}
