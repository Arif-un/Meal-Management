package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.Main_view;
import net.proteanit.sql.DbUtils;

public class Balance {
	
	 public static void load_balance(String yr_mn){
		 Connect Connect=new Connect();
			
			String command="SELECT date as Date, name as 'Name',id_no as 'ID No',balance as 'Balance' FROM balance WHERE date LIKE ?";
			
			try{
				Connection conn = Connect.connecting();
				
				PreparedStatement ps=conn.prepareStatement(command);
				ps.setString(1, yr_mn+"%");

	            ps.execute();
				ResultSet rs=ps.executeQuery();
				
				Main_view.bal_tab.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception x){
				x.printStackTrace();
			}
			
		}
	 
	 
	 public static void insert_balance(String date, String nm, String id_f, double balance) {
	        String sql = "INSERT INTO  balance (date,name,id_no,balance) VALUES(?,?,?,?)";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	pstmt.setString(1, date);
	        	pstmt.setString(2, nm);
	            pstmt.setString(3, id_f);
	            pstmt.setDouble(4, balance);

	            pstmt.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Successfully New balance Added !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Database Sending Failed !!! ");
	        }
	    }
	 
	 public static void add_balance(String id, double add) {
	        String sql = "UPDATE balance SET balance = balance + ? WHERE id_no=?";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setDouble(1, add);
	            pstmt.setString(2, id);
	            

	            pstmt.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Successfully Balance Added "+add+" !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           JOptionPane.showMessageDialog(null, "Insert a wrong vallue...........or.......Database Sending Failed !!! ");
	        }
	    }
	 
	 public static void min_balance(String id, double min) {
	        String sql = "UPDATE balance SET balance = balance - ? WHERE id_no=?";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setDouble(1, min);
	            pstmt.setString(2, id);
	            

	            pstmt.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Successfully Balance Minus "+min+" !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           JOptionPane.showMessageDialog(null, "Insert a wrong vallue...........or.......Database Sending Failed !!! ");
	        }
	    }
	 
	 public static void load_search_balance(String id){
		 Connect Connect=new Connect();
			
			String command="SELECT name as 'Name',id_no as'ID No',balance as 'Balance' FROM balance WHERE id_no LIKE ?";
			
			try{
				Connection conn = Connect.connecting();
				
				PreparedStatement ps=conn.prepareStatement(command);
				ps.setString(1, id+"%");
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				Main_view.bal_tab.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception x){
				x.printStackTrace();
			}
			
		}
	 
	 public static Double total_balance(String dt){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT SUM(balance) FROM balance WHERE date LIKE ?";
			
			double total=0;
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, dt+"%");
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					total=rs.getDouble("SUM(balance)");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return total;
		}

}
