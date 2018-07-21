package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import View.Main_view;
import View.Report;
import net.proteanit.sql.DbUtils;

public class Reports {

	
	public static String per_meal_price(String dt){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT (SELECT SUM(total) from cost WHERE date like ?)/((SELECT SUM(breakfast) from meal WHERE date like ? )+(SELECT SUM(lunch) from meal WHERE date like ? )+(SELECT SUM(dinner) from meal WHERE date like ? ))as 'per_meal_price'";
			
			double price=0.0;
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				
				ps.setString(1, dt+"%");
				ps.setString(2, dt+"%");
				ps.setString(3, dt+"%");
				ps.setString(4, dt+"%");
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					price=rs.getDouble("per_meal_price");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			//Double result_4_str;
		//	result_4_str = (price+"").substring(0, 2);
			String result_4_str =(new DecimalFormat("##.##").format(price));
			
			/*try {
				result_4_str = (price+"").substring(0, 5);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
			
		  //  double result_4 = Long.parseLong(result_4_str);
			
			return result_4_str;
		}
	
	public static String total_meal(String dt){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT (SELECT SUM(breakfast) from meal WHERE date like ? )+(SELECT SUM(lunch) from meal WHERE date like  ?)+(SELECT SUM(dinner) from meal WHERE date like  ?)as 'total_meal'";
			
			String total_meal="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				
				ps.setString(1, dt+"%");
				ps.setString(2, dt+"%");
				ps.setString(3, dt+"%");
				//ps.setString(4, dt+"%");
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					total_meal=rs.getString("total_meal");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
			return total_meal;
		}
	
	public static void load_active(){
		 Connect Connect=new Connect();
			
			String command="SELECT name,id_no,roll,reg,phone,adress,status,photo_path FROM Mem_info WHERE status='Active'";
			
			try{
				Connection conn = Connect.connecting();
				
				PreparedStatement ps=conn.prepareStatement(command);
				
				ResultSet rss=ps.executeQuery();
				
				
				Main_view.rep_tab.setModel(DbUtils.resultSetToTableModel(rss));
				
				
			}
			catch(Exception x){
				x.printStackTrace();
			}
			
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
	
	
	
	
	public static String paid(String id,String da,String da2){
		 Connection conn = Connect.connecting();
			
			String comnd="select sum(balance) from balance where id_no=? and date between ? and ?";
			
			String paid="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, id);
				ps.setString(2, da+"%");
				ps.setString(3, da2+"%");
				


				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					paid=rs.getString("sum(balance)");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return paid;
		}
	
	
	public static String total_bf(String id,String date,String date2){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT SUM(breakfast) from meal where id_no= ? AND date BETWEEN ? AND ?";
			
			String total_bf="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, id);
				ps.setString(2, date);
				ps.setString(3, date2);

				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					total_bf=rs.getString("SUM(breakfast)");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return total_bf;
		}
	
	public static String total_lun(String id,String date,String date2){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT SUM(lunch) from meal where id_no=? AND date BETWEEN ? AND ?";
			
			String total_lun="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, id);
				ps.setString(2, date);
				ps.setString(3, date2);

				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					total_lun=rs.getString("SUM(lunch)");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return total_lun;
		}
	
	public static String total_dnr(String id,String date,String date2){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT SUM(dinner) from meal where id_no=? AND date BETWEEN ? AND ?";
			
			String total_dnr="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, id);
				ps.setString(2, date);
				ps.setString(3, date2);

				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					total_dnr=rs.getString("SUM(dinner)");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return total_dnr;
		}
	
	public static void load_fund(String id,String date,String date2){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT date,balance from balance where id_no=? AND date BETWEEN ? AND ?";
			
			
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, id);
				ps.setString(2, date);
				ps.setString(3, date2);

				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				Report.fund_tab.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
	
	public static void load_cost(String date,String date2){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT date,cost_name,total from cost where date BETWEEN ? AND ?";
			
			
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				
				ps.setString(1, date);
				ps.setString(2, date2);

				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				Report.cost_tab.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
	
	public static void load_meal(String id,String date,String date2){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT date,breakfast,lunch,dinner from meal where id_no=? AND date BETWEEN ? AND ?";
			
			
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, id);
				ps.setString(2, date);
				ps.setString(3, date2);

				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				Report.rep_tab.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
	
	public static String total_meal(String id,String date,String date2){
		 Connection conn = Connect.connecting();
			
			String comnd="SELECT SUM(lunch)+SUM(breakfast)+SUM(dinner) as total_meal from meal where id_no=? AND date BETWEEN ? AND ?";
			
			String total_meal="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				ps.setString(1, id);
				ps.setString(2, date);
				ps.setString(3, date2);

				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					total_meal=rs.getString("total_meal");	
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return total_meal;
		}
	
	
	
	public static double  total_amnt(String dm1,String dm2,String dm3,String dm4,String id,String dt1,String dt2){
		 Connection conn = Connect.connecting();
			
			String comnd="select ((SELECT  Sum(total) from cost  where (date like ?) + (date like ?))/(SELECT  Sum(breakfast+lunch+dinner) from meal where (date like ?) + (date like ?)))*(SELECT SUM(lunch)+SUM(breakfast)+SUM(dinner) as total_meal from meal where id_no=? AND date BETWEEN ? AND ?) as amnt";
			
			double  total_amnt=0.0;
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				
				ps.setString(1, dm1+"%");
				ps.setString(2, dm2+"%");
				ps.setString(3, dm3+"%");
				ps.setString(4, dm4+"%");
				ps.setString(5, id);
				ps.setString(6, dt1);
				ps.setString(7, dt2);
				
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					total_amnt=rs.getDouble("amnt");	
					System.out.println(total_amnt);
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		

			return total_amnt;
		}
	
	
	public static String  due(String idd,String dtt1,String dtt2,String dm1,String dm2,String dm3,String dm4,String id,String dt1,String dt2){
		 Connection conn = Connect.connecting();
			
			String comnd="select (select sum(balance) from balance where id_no=? and date between ? and ?)-((SELECT  Sum(total) from cost  where (date like ?) + (date like ?))/(SELECT  Sum(breakfast+lunch+dinner) from meal where (date like ?) + (date like ?)))*(SELECT SUM(lunch)+SUM(breakfast)+SUM(dinner) as total_meal from meal where id_no=? AND date BETWEEN ? AND ?) as amnt";
			
			String  du="";
			
			try{
				PreparedStatement ps=conn.prepareStatement(comnd);
				
				ps.setString(1, idd);
				ps.setString(2, dtt1);
				ps.setString(3, dtt2);
				ps.setString(4, dm1+"%");
				ps.setString(5, dm2+"%");
				ps.setString(6, dm3+"%");
				ps.setString(7, dm4+"%");
				ps.setString(8, id);
				ps.setString(9, dt1);
				ps.setString(10, dt2);
				
				ps.execute();
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					du=rs.getString ("amnt");	
					
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		

			return du;
		}
	
	public static void reset(){
		 Connect Connect=new Connect();
			
			String command1="Delete from Mem_info";
			String command2="Delete from cost";
			String command3="Delete from balance";
			String command4="Delete from meal";
			
			try{
				Connection conn = Connect.connecting();
				
				Statement stmt=conn.createStatement();
				stmt.addBatch(command1);
				stmt.addBatch(command2);
				stmt.addBatch(command3);
				stmt.addBatch(command4);
				
				stmt.executeBatch();
				
JOptionPane.showMessageDialog(null, "Successfully Deleted all Records");
				
			}
			catch(Exception x){
				x.printStackTrace();
				JOptionPane.showMessageDialog(null, "fail to delete");
			}
			
		}
}
