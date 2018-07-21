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

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Support extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Support frame = new Support(null);
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
	public Support(String idd) {
		setTitle("Support & Help");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 669, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221,222,232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancel = new JButton("OK");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Support.this.dispose();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
		btnCancel.setBackground(new Color(2, 145, 255));
		btnCancel.setBounds(277, 312, 95, 23);
		contentPane.add(btnCancel);
		
		JLabel lblAreYouSure = new JLabel("For Support And Help.");
		lblAreYouSure.setIcon(new ImageIcon(Support.class.getResource("/img/Customer Support_70px.png")));
		lblAreYouSure.setForeground(new Color(0, 153, 255));
		lblAreYouSure.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 30));
		lblAreYouSure.setBounds(141, 46, 401, 65);
		contentPane.add(lblAreYouSure);
		
		JLabel lblMailArifunctggmailcom = new JLabel("Mail : arifunctg@gmail.com");
		lblMailArifunctggmailcom.setForeground(new Color(0, 153, 255));
		lblMailArifunctggmailcom.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 20));
		lblMailArifunctggmailcom.setBounds(162, 122, 401, 23);
		contentPane.add(lblMailArifunctggmailcom);
		
		JLabel lblFacebookFbcomarifoverclocker = new JLabel("Facebook : fb.com/ArifOverclocker");
		lblFacebookFbcomarifoverclocker.setForeground(new Color(0, 153, 255));
		lblFacebookFbcomarifoverclocker.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 20));
		lblFacebookFbcomarifoverclocker.setBounds(162, 156, 401, 23);
		contentPane.add(lblFacebookFbcomarifoverclocker);
		
		JLabel lblCall = new JLabel("Call : +8801866604472");
		lblCall.setForeground(new Color(0, 153, 255));
		lblCall.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 20));
		lblCall.setBounds(162, 190, 401, 23);
		contentPane.add(lblCall);
		
		JLabel lblThankYou = new JLabel("Thank You !!!");
		lblThankYou.setForeground(new Color(0, 153, 255));
		lblThankYou.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 20));
		lblThankYou.setBounds(262, 278, 132, 23);
		contentPane.add(lblThankYou);
	}
}
