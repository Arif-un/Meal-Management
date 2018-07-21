package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.Main_view;
import net.proteanit.sql.DbUtils;

public class Mem_info {
	
	 public static void insert_mem_info_db(String name, String id, String roll, String reg, String phn, String adress, String path, String status) {
	        String sql = "INSERT INTO Mem_info (name,id_no,roll,reg,phone,adress,photo_path,status) VALUES(?,?,?,?,?,?,?,?)";
	 
	        Connect Connect=new Connect();
	        
	        try (Connection conn = Connect.connecting();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, id);
	            pstmt.setString(3, roll);
	            pstmt.setString(4, reg);
	            pstmt.setString(5, phn);
	            pstmt.setString(6, adress);
	            pstmt.setString(7, path);
	            pstmt.setString(8, status);
	            
	            pstmt.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Successfully New Member Added !!");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Database Sending Failed !!! ");
	        }
	    }
	 
	 
	 public static void load_active(){
		 Connect Connect=new Connect();
			
			String command="SELECT name,id_no,roll,reg,phone,adress,status,photo_path FROM Mem_info WHERE status='Active'";
			
			try{
				Connection conn = Connect.connecting();
				
				PreparedStatement ps=conn.prepareStatement(command);
				ResultSet rs=ps.executeQuery();
				
				Main_view.active_tab.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				
			}
			catch(Exception x){
				x.printStackTrace();
			}
			
		}
	 
	 public static void load_inactive(){
		 Connect Connect=new Connect();
			
			String command="SELECT name,id_no,roll,reg,phone,adress,status,photo_path FROM Mem_info WHERE status='Inactive'";
			
			try{
				Connection conn = Connect.connecting();
				
				PreparedStatement ps=conn.prepareStatement(command);
				ResultSet rs=ps.executeQuery();
				
				Main_view.inactive_tab.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception x){
				x.printStackTrace();
			}
			
		}
	 
			 
			 
			
			 
			 
			 public static void delete_mem(String give_id) {
			        String sql = "DELETE FROM Mem_info WHERE id_no=?";
			 
			        Connect Connect=new Connect();
			        
			        try (Connection conn = Connect.connecting();
			                PreparedStatement pstmt = conn.prepareStatement(sql)) {
			            pstmt.setString(1, give_id);

			            pstmt.executeUpdate();
			            
			            JOptionPane.showMessageDialog(null, "Successfully New Member Removed !!");
			        } catch (SQLException e) {
			            System.out.println(e.getMessage());
			            JOptionPane.showMessageDialog(null, "Database Sending Failed !!! ");
			        }
			    }
			 
			 
			 public static void update(String name, String id, String roll, String reg, String phn, String adress, String path, String status) {
			        String sql = "UPDATE Mem_info SET name=?,roll=?,reg=?,phone=?,adress=?,photo_path=?,status=? WHERE id_no=?";
			 
			        Connect Connect=new Connect();
			        
			        try (Connection conn = Connect.connecting();
			                PreparedStatement pstmt = conn.prepareStatement(sql)) {
			            pstmt.setString(1, name);
			            pstmt.setString(2, roll);
			            pstmt.setString(3, reg);
			            pstmt.setString(4, phn);
			            pstmt.setString(5, adress);
			            pstmt.setString(6, path);
			            pstmt.setString(7, status);
			            pstmt.setString(8, id);
			            
			            pstmt.executeUpdate();
			            
			            JOptionPane.showMessageDialog(null, "Successfully New Updated !!");
			        } catch (SQLException e) {
			            System.out.println(e.getMessage());
			            JOptionPane.showMessageDialog(null, "Database Sending Failed !!! ");
			        }
			    }
			 
			 public static String path(String id){
				 Connection conn = Connect.connecting();
					
					String comnd="SELECT photo_path from Mem_info Where id_no=?";
					
					String path="";
					
					try{
						PreparedStatement ps=conn.prepareStatement(comnd);
						
						ps.setString(1, id);
						ps.execute();
						ResultSet rs=ps.executeQuery();
						
						while(rs.next()){
							path=rs.getString("photo_path");	
						}
						
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					return path;
				}
			 
			 public static String active_mem(){
				 Connection conn = Connect.connecting();
					
					String comnd="SELECT COUNT(*) FROM Mem_info WHERE status='Active'";
					
					String count="";
					
					try{
						PreparedStatement ps=conn.prepareStatement(comnd);
						
						
						ps.execute();
						ResultSet rs=ps.executeQuery();
						
						while(rs.next()){
							count=rs.getString("COUNT(*)");	
						}
						
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					return count;
				}
			 
			 public static String inactive_mem(){
				 Connection conn = Connect.connecting();
					
					String comnd="SELECT COUNT(*) FROM Mem_info WHERE status='Inactive'";
					
					String count="";
					
					try{
						PreparedStatement ps=conn.prepareStatement(comnd);
						
						
						ps.execute();
						ResultSet rs=ps.executeQuery();
						
						while(rs.next()){
							count=rs.getString("COUNT(*)");	
						}
						
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					return count;
				}
			 
			 public static String tot_mem(){
				 Connection conn = Connect.connecting();
					
					String comnd="SELECT COUNT(*) FROM Mem_info ";
					
					String count="";
					
					try{
						PreparedStatement ps=conn.prepareStatement(comnd);
						
						
						ps.execute();
						ResultSet rs=ps.executeQuery();
						
						while(rs.next()){
							count=rs.getString("COUNT(*)");	
						}
						
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					return count;
				}
			 
			

}
