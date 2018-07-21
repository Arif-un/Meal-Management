package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Login {
	 public static String login(String id,String  pass) {
	        String sql = "SELECT id_no from admin where id_no=? AND pass=?";
	 
	        Connect Connect=new Connect();
	        
	        String idd="";
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	pstmt.setString(1,id);
	        	pstmt.setString(2,pass);

	            pstmt.execute();
	            
	            ResultSet rs=pstmt.executeQuery();
				
				while(rs.next()){
					idd=rs.getString("id_no");	
				}
	            
	         //  JOptionPane.showMessageDialog(null, "Successfully Deleted  !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	     //      JOptionPane.showMessageDialog(null, "Database Sending Failed !!!/// Wrong value ");
	        }
	        return idd;
	    }

}
