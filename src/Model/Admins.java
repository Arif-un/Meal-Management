package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.Admin;
import View.Main_view;
import net.proteanit.sql.DbUtils;

public class Admins {

	 public static void add_meal(String name, String id,String pass) {
	        String sql = "INSERT INTO  admin (name,id_no,pass) VALUES(?,?,?)";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, id);
	            pstmt.setString(3, pass);
	            
	            

	            pstmt.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Successfully admin Added  !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           JOptionPane.showMessageDialog(null, "Insert a wrong vallue...........or.......Database Sending Failed !!! ");
	        }
	    }
	 
	 
	 public static void load_admin(){
		 Connect Connect=new Connect();
			
			String command="SELECT name,id_no,pass from admin  where id>3";
			
			try{
				Connection conn = Connect.connecting();
				
				PreparedStatement ps=conn.prepareStatement(command);
				
				
				ResultSet rs=ps.executeQuery();
				
				Admin.table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception x){
				x.printStackTrace();
			}
			
		}
	 public static void dlt_admin(String id) {
	        String sql = "DELETE FROM admin WHERE id_no=?";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	pstmt.setString(1,id);

	            pstmt.executeUpdate();
	            
	           JOptionPane.showMessageDialog(null, "Successfully Deleted  !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           JOptionPane.showMessageDialog(null, "Database Sending Failed !!!/// Wrong value ");
	        }
	    }
}
