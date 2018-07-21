package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

import Model.Login;
public class Login_view
{
 /*While BTV Shooting in BSPI campus ..... and
 this comment I create a comment for memorable moment*/
	public JFrame f = new JFrame();
  Point point = new Point();
  boolean resizing = false;
  private JTextField id_t;
  private JSeparator pas;
  private JSeparator usr;
  private JPasswordField pass_t;
  public void buildGUI()
  {
    
    f.getContentPane().setBackground(new Color(221,222,233));
    f.setUndecorated(true);
    f.setSize(627,396);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(null);
    
    JButton close = new JButton("");
    close.setBorderPainted(false);
    close.setContentAreaFilled(false);
    close.setDefaultCapable(false);
    close.setFocusPainted(false);
    close.setFocusable(false);
    close.setRolloverIcon(new ImageIcon(Login_view.class.getResource("/img/Cancel_24px_1.png")));
    close.setIcon(new ImageIcon(Login_view.class.getResource("/img/Cancel_24px.png")));
    close.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		System.exit(0);
    	}
    });
    close.setBounds(594, 0, 33, 32);
    f.getContentPane().add(close);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon(Login_view.class.getResource("/img/Untitled-1.png")));
    label.setBounds(0, 0, 370, 396);
    f.getContentPane().add(label);
    
    JLabel lblLoginPanel = new JLabel("Login Panel");
    lblLoginPanel.setForeground(new Color(255, 27, 27));
    lblLoginPanel.setFont(new Font("Dialog", Font.BOLD, 24));
    lblLoginPanel.setBounds(435, 66, 162, 40);
    f.getContentPane().add(lblLoginPanel);
    
    JSeparator separator = new JSeparator();
    separator.setForeground(new Color(10,13,13));
    separator.setBackground(new Color(0, 0, 0));
    separator.setBounds(428, 105, 163, 15);
    f.getContentPane().add(separator);
    
    JLabel label_1 = new JLabel("");
    label_1.setIcon(new ImageIcon(Login_view.class.getResource("/img/User_24px.png")));
    label_1.setBounds(410, 200, 24, 24);
    f.getContentPane().add(label_1);
    
    id_t = new JTextField();
    id_t.setForeground(new Color(0, 191, 255));
    id_t.addFocusListener(new FocusAdapter() {
    	@Override
    	public void focusGained(FocusEvent arg0) {
    		usr.setForeground(new Color(7,182,255));

    	}
    	@Override
    	public void focusLost(FocusEvent e) {
    		usr.setForeground(new Color(10, 13, 13));
    	}
    });
 //   textField.setForeground(new Color(169, 169, 169));
  //  textField.setDisabledTextColor(new Color(128, 128, 128));
    id_t.setBackground(new Color(221,222,233));
    id_t.setBorder(null);
    id_t.setBounds(444, 204, 153, 20);
    f.getContentPane().add(id_t);
    id_t.setColumns(10);
    
    usr = new JSeparator();
    usr.setForeground(new Color(10, 13, 13));
    usr.setBackground(Color.BLACK);
    usr.setBounds(444, 224, 153, 15);
    f.getContentPane().add(usr);
    
    JLabel label_2 = new JLabel("");
    label_2.setIcon(new ImageIcon(Login_view.class.getResource("/img/Password_24px.png")));
    label_2.setBounds(410, 252, 24, 24);
    f.getContentPane().add(label_2);
    
    pas = new JSeparator();
    pas.setForeground(new Color(10, 13, 13));
    pas.setBackground(Color.BLACK);
    pas.setBounds(444, 276, 153, 15);
    f.getContentPane().add(pas);
    
    pass_t = new JPasswordField();
    pass_t.addFocusListener(new FocusAdapter() {
    	@Override
    	public void focusGained(FocusEvent e) {
    		pas.setForeground(new Color(7,182,255));
    	}
    	@Override
    	public void focusLost(FocusEvent e) {
    		pas.setForeground(new Color(10, 13, 13));
    	}
    });
    pass_t.setBorder(null);
    pass_t.setBackground(new Color(221,222,233));
    pass_t.setForeground(new Color(0, 191, 255));
    pass_t.setBounds(444, 256, 153, 20);
    f.getContentPane().add(pass_t);
    
    JButton button = new JButton("");
    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		String idd=id_t.getText();
    		String pa=pass_t.getText();
    		String a=Login.login(idd,pa);
    		
    		System.out.println(a);
    		if (a.equals("")){
    			JOptionPane.showMessageDialog(null, "Wrong ID or Password");
    		}
    		else{
    			Login_view l=new Login_view();
    			f.setVisible(false);
    			Main_view obj=new  Main_view();
    			obj.buildGUI();
    		}
    	}
    });
    button.setIcon(new ImageIcon(Login_view.class.getResource("/img/safas.png")));
    button.setBorderPainted(false);
    button.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
    button.setFocusPainted(false);
    button.setBackground(Color.LIGHT_GRAY);
    button.setBounds(462, 325, 89, 23);
    f.getContentPane().add(button);
    
    JLabel lblForgotPassword = new JLabel("Forgot Password ??");
    lblForgotPassword.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseEntered(MouseEvent arg0) {
    		lblForgotPassword.setForeground(new Color(0, 102, 204));
    	}
    	@Override
    	public void mouseExited(MouseEvent e) {
    		lblForgotPassword.setForeground(new Color(0, 51, 153));
    	}
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		Import obj=new Import(null);
    		obj.setVisible(true);
    	}
    });
    lblForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
    lblForgotPassword.setForeground(new Color(0, 51, 153));
    lblForgotPassword.setBounds(509, 371, 108, 14);
    f.getContentPane().add(lblForgotPassword);
    

    f.setVisible(true);
    f.getContentPane().addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
    	 f.setOpacity(0.80f);
        resizing = f.getCursor().equals(Cursor.getDefaultCursor())? false:true;
        if(!e.isMetaDown()){
          point.x = e.getX();
          point.y = e.getY();
        }
      }
    	@Override
    	public void mouseReleased(MouseEvent e) {
    		f.setOpacity(1f);
    	}
    });
    f.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        if(resizing){
          Point pt = e.getPoint();
          f.setSize(f.getWidth()+pt.x - point.x,f.getHeight());
          point.x = pt.x;
        }
        else if(!e.isMetaDown()){
        Point p = f.getLocation();
        f.setLocation(p.x + e.getX() - point.x,
            p.y + e.getY() - point.y);
        }
      }
      
      //Resizeable
      
      public void mouseMoved(MouseEvent me){
        Point cursorLocation = me.getPoint();
        int xPos = cursorLocation.x;
        int yPos = cursorLocation.y;
      //      if(xPos < 5) f.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
     //      else if(xPos > f.getContentPane().getWidth()-5) f.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
    //   else if(yPos < 5) f.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
   //    else if(yPos > f.getContentPane().getHeight()-5) f.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
  //    else if(f.getCursor().equals(Cursor.getDefaultCursor()) == false) f.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    });
  }
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new Login_view().buildGUI();
      }
    });
  }
}