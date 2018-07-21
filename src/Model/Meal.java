package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.Main_view;
import net.proteanit.sql.DbUtils;

public class Meal {
	
	 public static String giv_id_get_nam(String id){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT name from Mem_info Where id_no=?";
			
			String name="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				
				ps.setString(1, id);
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					name=rs.getString("name");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return name;
		}
	 
	 public static String giv_id_get_nam_meal(String id){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT name from Mem_info Where id_no=?";
			
			String name="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				
				ps.setString(1, id);
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					name=rs.getString("name");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return name;
		}
	 
	 public static void add_meal(String date, String name,String id_no,int brk,int lun,int dn) {
	        String sql = "INSERT INTO  meal (date,name,id_no,breakfast,lunch,dinner) VALUES(?,?,?,?,?,?)";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, date);
	            pstmt.setString(2, name);
	            pstmt.setString(3, id_no);
	            pstmt.setInt(4, brk);
	            pstmt.setInt(5, lun);
	            pstmt.setInt(6, dn);
	            

	            pstmt.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Successfully Meal Added  !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           JOptionPane.showMessageDialog(null, "Insert a wrong vallue...........or.......Database Sending Failed !!! ");
	        }
	    }
	 
	 public static void load_by_date(String date){
		 Connect Connect=new Connect();
			
			String command="SELECT date as 'Date',name as 'Name',id_no as 'ID No',(CASE breakfast WHEN 1 THEN '√' WHEN 2 THEN '√√' WHEN 3 THEN '√√√' WHEN 0 THEN '○' ELSE breakfast END) as Brekfast,(CASE lunch WHEN 1 THEN '√' WHEN 2 THEN '√√' WHEN 3 THEN '√√√' WHEN 0 THEN '○' ELSE lunch END) as Lunch ,(CASE dinner WHEN 1 THEN '√' WHEN 2 THEN '√√' WHEN 3 THEN '√√√' WHEN 0 THEN '○' ELSE dinner END) as Dinner FROM meal WHERE date=?";
			
			try{
				Connection conn = Connect.connecting();
				
				PreparedStatement ps=conn.prepareStatement(command);
				ps.setString(1,date);
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				Main_view.meal_tab.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception x){
				x.printStackTrace();
			}
			
		}
	 
	 public static void delete_lst_entry_meal(String date) {
	        String sql = "DELETE FROM meal WHERE id = (SELECT MAX(id) AND date= ? FROM meal)";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	pstmt.setString(1,date);

	            pstmt.executeUpdate();
	            
	           JOptionPane.showMessageDialog(null, "Successfully Deleted Last One !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           JOptionPane.showMessageDialog(null, "Database Sending Failed !!!/// Wrong value ");
	        }
	    }

}
