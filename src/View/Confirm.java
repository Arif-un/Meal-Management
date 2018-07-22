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

public class Confirm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm frame = new Confirm(null);
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
	public Confirm(String idd) {
		setTitle("Confirmation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 348, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 13, 33));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("Yes");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try{

    	    		File file = new File(Mem_info.path(idd));

    	    		if(file.delete()){
    	    			System.out.println(file.getName() + " is deleted!");
    	    		}else{
    	    			System.out.println("Delete operation is failed.");
    	    		}

    	    	}catch(Exception e1){

    	    		e1.printStackTrace();

    	    	}
				
	    		Mem_info.delete_mem(idd);
	    		Mem_info.load_active();
	    		Mem_info.load_inactive();
	    		Confirm.this.dispose();
	    		
	    		

			}
		});
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
		btnOk.setFocusPainted(false);
		btnOk.setBorderPainted(false);
		btnOk.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
		btnOk.setBackground(new Color(2, 145, 255));
		btnOk.setBounds(52, 127, 95, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confirm.this.dispose();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
		btnCancel.setBackground(new Color(2, 145, 255));
		btnCancel.setBounds(170, 128, 95, 23);
		contentPane.add(btnCancel);
		
		JLabel lblAreYouSure = new JLabel("Are You Sure !!!! ");
		lblAreYouSure.setForeground(new Color(0, 153, 255));
		lblAreYouSure.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 16));
		lblAreYouSure.setBounds(104, 53, 178, 14);
		contentPane.add(lblAreYouSure);
	}
}
