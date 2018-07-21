package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Allow_log {

	public static void inactive() {
        String sql = "UPDATE login SET status ='inactive' WHERE rowid='1'";
 
        Connect Connect=new Connect();
        
        try (Connection conn = Connect.connecting();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
      
        }
    }
	
	public static void active() {
        String sql = "UPDATE login SET status ='active' WHERE rowid='1'";
 
        Connect Connect=new Connect();
        
        try (Connection conn = Connect.connecting();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
      
        }
    }
	
	 public static String chek_log(){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT status from login Where rowid=1";
			
			String st="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				
				
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					st=rs.getString("status");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return st;
		}
	 
	 public static String show_chk(){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT name from admin  where id>3";
			
			String st="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				
				
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					st=rs.getString("name");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return st;
		}
}
