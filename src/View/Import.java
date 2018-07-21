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

public class Import extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Import frame = new Import(null);
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
	public Import(String idd) {
		setTitle("Import");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 669, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221,222,230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancel = new JButton("OK");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Import.this.dispose();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
		btnCancel.setBackground(new Color(2, 145, 255));
		btnCancel.setBounds(277, 333, 95, 23);
		contentPane.add(btnCancel);
		
		JLabel lblThankYou = new JLabel("Thank You !!!");
		lblThankYou.setForeground(new Color(0, 153, 255));
		lblThankYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThankYou.setBounds(262, 299, 132, 23);
		contentPane.add(lblThankYou);
		
		JLabel lblImportDatabase = new JLabel("Import OLD Database :");
		lblImportDatabase.setForeground(new Color(0, 153, 255));
		lblImportDatabase.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImportDatabase.setBounds(51, 34, 239, 23);
		contentPane.add(lblImportDatabase);
		
		JLabel lblRenameYour = new JLabel("1.Make sure Rename of Your Old Backuped Database to  \"Meal_lab.sqlite\"");
		lblRenameYour.setForeground(new Color(0, 153, 255));
		lblRenameYour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRenameYour.setBounds(51, 66, 534, 23);
		contentPane.add(lblRenameYour);
		
		JLabel lblDeletemeallabsqlite = new JLabel("2. Delete \"Meal_lab.sqlite\" from C:/Programme Files/RF's Programme/Meal Lab/");
		lblDeletemeallabsqlite.setForeground(new Color(0, 153, 255));
		lblDeletemeallabsqlite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeletemeallabsqlite.setBounds(51, 105, 534, 23);
		contentPane.add(lblDeletemeallabsqlite);
		
		JLabel lblCopyOld = new JLabel("3. Copy old backuped \"Meal_lab.sqlite\" ");
		lblCopyOld.setForeground(new Color(0, 153, 255));
		lblCopyOld.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCopyOld.setBounds(51, 139, 534, 23);
		contentPane.add(lblCopyOld);
		
		JLabel lblAndPasteOr = new JLabel("   and Paste or Replace in \"C:/ Programme Files/RF's Programme/Meal Lab\"   folder");
		lblAndPasteOr.setForeground(new Color(0, 153, 255));
		lblAndPasteOr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAndPasteOr.setBounds(51, 169, 534, 23);
		contentPane.add(lblAndPasteOr);
		
		JLabel lblIfFaced = new JLabel("4. If faced any problem please contact with Support Team.");
		lblIfFaced.setForeground(new Color(0, 153, 255));
		lblIfFaced.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIfFaced.setBounds(51, 234, 534, 23);
		contentPane.add(lblIfFaced);
	}
}
