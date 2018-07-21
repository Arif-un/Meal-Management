package Model;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connect {
    private static Connection con = null; 

    public static Connection connecting(){

        try{
            Class.forName("org.sqlite.JDBC"); 
            
            String currentDir = System.getProperty("user.dir");
            
            con = DriverManager.getConnection("jdbc:sqlite:"+currentDir+"/DB/Meal_lab.sqlite");
           // JOptionPane.showMessageDialog(null, "Working", null, JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE); 
        }
        return con; 
    }

}