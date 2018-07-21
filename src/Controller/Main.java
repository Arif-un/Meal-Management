package Controller;
import javax.swing.JOptionPane;

import Model.Allow_log;
import View.Login_view;
import View.Main_view;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String status=Allow_log.chek_log();
			if(status.equals("active")){
				
				Login_view obj=new Login_view();
				obj.buildGUI();
			}
			else if(status.equals("inactive")){
				Main_view.main(null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Database Missing !!!");
		}
	}

}
