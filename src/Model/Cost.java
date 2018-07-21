package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JOptionPane;

import View.Main_view;
import net.proteanit.sql.DbUtils;

public class Cost {
	 
	 public static void insert_cost(String d,String c_name,double quan,double priz,double total) {
	        String sql = "INSERT INTO  cost (date,cost_name,quan,price,total) VALUES(?,?,?,?,?)";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, d);
	            pstmt.setString(2, c_name);
	            pstmt.setDouble(3, quan);
	            pstmt.setDouble(4, priz);
	            pstmt.setDouble(5, total);

	            pstmt.executeUpdate();
	            
	           JOptionPane.showMessageDialog(null, "Successfully Added   "+ c_name+ "   quantity : "+quan+"  price: "+priz+"  total :  "+total+" !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           JOptionPane.showMessageDialog(null, "Database Sending Failed !!!/// Wrong value ");
	        }
	    }
	 
	 public static void load_cost_by_dat_yr(String yr_dat){
		 Connect Connect=new Connect();
			
			String command="SELECT date as 'Date',cost_name as 'Cost',quan as 'Quantity',price as 'Price',total as 'Total' FROM cost Where date like ?";
			
			try{
				Connection conn = Connect.connecting();
				
				PreparedStatement ps=conn.prepareStatement(command);
				ps.setString(1, yr_dat+"%");

	            ps.execute();
				ResultSet rs=ps.executeQuery();
				
				Main_view.cost_tab.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception x){
				x.printStackTrace();
			}
			
		}
	 
	 public static void delete_lst_entry() {
	        String sql = "DELETE FROM cost WHERE id = (SELECT MAX(id) FROM cost)";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            

	            pstmt.executeUpdate();
	            
	           JOptionPane.showMessageDialog(null, "Successfully Deleted Last One !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           JOptionPane.showMessageDialog(null, "Database Sending Failed !!!/// Wrong value ");
	        }
	    }
	 
	 public static void delete_selected(String date, String cos_name,String qun,String price, String total) {
	        String sql = "DELETE  FROM cost WHERE id= (SELECT id FROM cost WHERE date=? AND cost_name=? AND quan=? AND price=? AND total=? order by id desc limit 1)  ";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	pstmt.setString(1, date);
	            pstmt.setString(2, cos_name);
	            pstmt.setString(3, qun);
	            pstmt.setString(4, price);
	            pstmt.setString(5, total);

	            pstmt.executeUpdate();
	            
	           JOptionPane.showMessageDialog(null, "Successfully Delete Selected !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           JOptionPane.showMessageDialog(null, "Database Sending Failed !!!/// Wrong value ");
	        }
	    }
	 
	 public static Double now_balance(String date){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT (SELECT SUM(balance) from balance  where date like ?)-(SELECT SUM(total) from cost   where date like ?)as 'now_balance'";
			
			double nw_bal=0;
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, date+"%");
				ps.setString(2, date+"%");
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					nw_bal=rs.getDouble("now_balance");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return nw_bal;
		}
	 
	 public static Double total_cost(String date){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT SUM(total) from cost WHERE date LIKE ?";
			
			double total_cost=0;
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, date+"%");

				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					total_cost=rs.getDouble("SUM(total)");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return total_cost;
		}

	

}
