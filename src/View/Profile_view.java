package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;

import Model.Mem_info;
public class Profile_view
{
  Point point = new Point();
  boolean resizing = false;
 public static JTextField name;
 public static  JTextField id;
 public static  JTextField roll;
 public static  JTextField reg;
 public static  JTextField phone;
 public static  JSeparator reg_s;
 public static  JSeparator phone_s;
 public static  JComboBox status_c;
 public  static JTextArea adress;
public JLabel lbl;
private JTextField path;
private JLabel label;
private JButton btnChangePhoto;
String file_path;
public static JButton close;
private JTextField new_path;

  public void buildGUI(String get_name,String get_id,String get_roll,String get_reg,String get_phone,String get_adress,String get_status, String get_photo_path)
  {
     final JFrame f1 = new JFrame();
    f1.getContentPane().setBackground(new Color(221,222,232));
    f1.setUndecorated(true);
    f1.setSize(701,452);
    f1.setLocationRelativeTo(null);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.getContentPane().setLayout(null);
    
    close = new JButton("");
    close.setBorderPainted(false);
    close.setContentAreaFilled(false);
    close.setDefaultCapable(false);
    close.setFocusPainted(false);
    close.setFocusable(false);
    close.setRolloverIcon(new ImageIcon(Profile_view.class.getResource("/img/Cancel_24px_1.png")));
    close.setIcon(new ImageIcon(Profile_view.class.getResource("/img/Cancel_24px_2.png")));
    close.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		f1.dispose();    	}
    });
    close.setBounds(668, 0, 33, 32);
    f1.getContentPane().add(close);
    
    JButton btnRemoveThisMember = new JButton("Remove This Member");
    btnRemoveThisMember.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String idd=id.getText();
    		Confirm Confirm=new Confirm(idd);
    		Confirm.setVisible(true);
    		
			
    	}
    });
    btnRemoveThisMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnRemoveThisMember.setForeground(Color.BLACK);
    btnRemoveThisMember.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
    btnRemoveThisMember.setBorderPainted(false);
    btnRemoveThisMember.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
    btnRemoveThisMember.setFocusPainted(false);
    btnRemoveThisMember.setBackground(new Color(153, 153, 153));
    btnRemoveThisMember.setBounds(237, 418, 166, 23);
    f1.getContentPane().add(btnRemoveThisMember);
    
    lbl = new JLabel("Member Profile");
    lbl.setForeground(new Color(255, 27, 27));
    lbl.setFont(new Font("Bauhaus 93", Font.PLAIN, 32));
    lbl.setBounds(10, 0, 245, 40);
    f1.getContentPane().add(lbl);
    
    label = new JLabel("");
    label.setIcon(new ImageIcon(get_photo_path));
    
   
	
  
    
    label.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 255)));
    label.setForeground(Color.MAGENTA);
    label.setBackground(Color.CYAN);
    label.setBounds(46, 55, 269, 236);
    //input image and set label size
    BufferedImage img = null;
    try {
        img = ImageIO.read(new File(get_photo_path));
        Image dimg = img.getScaledInstance(label.getWidth(),label.getHeight(),
                Image.SCALE_SMOOTH);
        
    	label.setIcon(new ImageIcon(dimg));
    } catch (IOException e1) {
        e1.printStackTrace();
    }
    
    
    
    f1.getContentPane().add(label);
    
    
    JSeparator separator_1 = new JSeparator();
    separator_1.setForeground(new Color(10, 13, 13));
    separator_1.setBackground(Color.BLACK);
    separator_1.setBounds(12, 37, 215, 15);
    f1.getContentPane().add(separator_1);
    
    JLabel lblName = new JLabel("Name :");
    lblName.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 16));
    lblName.setForeground(new Color(0, 153, 255));
    lblName.setBounds(360, 55, 49, 14);
    f1.getContentPane().add(lblName);
    
    JLabel lblIdNo = new JLabel("ID NO :");
    lblIdNo.setForeground(new Color(0, 153, 255));
    lblIdNo.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 16));
    lblIdNo.setBounds(360, 90, 49, 14);
    f1.getContentPane().add(lblIdNo);
    
    JLabel lblRoll = new JLabel("Roll :");
    lblRoll.setForeground(new Color(0, 153, 255));
    lblRoll.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 16));
    lblRoll.setBounds(360, 126, 49, 14);
    f1.getContentPane().add(lblRoll);
    
    JSeparator name_s = new JSeparator();
    name_s.setForeground(new Color(10, 13, 13));
    name_s.setBackground(Color.BLACK);
    name_s.setBounds(419, 69, 153, 15);
    f1.getContentPane().add(name_s);
    
    name = new JTextField();
    name.setText(get_name);
    name.addFocusListener(new FocusAdapter() {
    	@Override
    	public void focusGained(FocusEvent arg0) {
    		name_s.setForeground(new Color(7,182,255));
    	}
    	@Override
    	public void focusLost(FocusEvent e) {
    		name_s.setForeground(new Color(221,222,232));
    	}
    });
    name.setCaretColor(Color.DARK_GRAY);
    name.setForeground(Color.DARK_GRAY);
    name.setColumns(10);
    name.setBorder(null);
    name.setBackground(new Color(221,222,232));
    name.setBounds(419, 49, 153, 20);
    f1.getContentPane().add(name);
    
    JSeparator id_s = new JSeparator();
    id_s.setForeground(new Color(10, 13, 13));
    id_s.setBackground(Color.BLACK);
    id_s.setBounds(419, 102, 153, 15);
    f1.getContentPane().add(id_s);
    
    id = new JTextField();
    id.setText(get_id);
    id.setEditable(false);
    id.addFocusListener(new FocusAdapter() {
    	@Override
    	public void focusGained(FocusEvent e) {
    		id_s.setForeground(new Color(7,182,255));
    	}
    	@Override
    	public void focusLost(FocusEvent e) {
    		id_s.setForeground(new Color(221,222,232));
    	}
    });
    id.setCaretColor(Color.DARK_GRAY);
    id.setForeground(Color.DARK_GRAY);
    id.setColumns(10);
    id.setBorder(null);
    id.setBackground(new Color(221,222,232));
    id.setBounds(419, 82, 153, 20);
    f1.getContentPane().add(id);
    
    JSeparator roll_s = new JSeparator();
    roll_s.setForeground(new Color(10, 13, 13));
    roll_s.setBackground(Color.BLACK);
    roll_s.setBounds(419, 137, 153, 15);
    f1.getContentPane().add(roll_s);
    
    roll = new JTextField();
    roll.setText(get_roll);
    roll.addFocusListener(new FocusAdapter() {
    	@Override
    	public void focusGained(FocusEvent e) {
    		roll_s.setForeground(new Color(7,182,255));
    	}
    	@Override
    	public void focusLost(FocusEvent e) {
    		roll_s.setForeground(new Color(221,222,232));
    	}
    });
    roll.setCaretColor(Color.DARK_GRAY);
    roll.setForeground(Color.DARK_GRAY);
    roll.setColumns(10);
    roll.setBorder(null);
    roll.setBackground(new Color(221,222,232));
    roll.setBounds(419, 117, 153, 20);
    f1.getContentPane().add(roll);
    
    reg = new JTextField();
    reg.setText(get_reg);
    reg.addFocusListener(new FocusAdapter() {
    	@Override
    	public void focusGained(FocusEvent e) {
    		reg_s.setForeground(new Color(7,182,255));
    	}
    	@Override
    	public void focusLost(FocusEvent e) {
    		reg_s.setForeground(new Color(221,222,232));
    	}
    });
    reg.setCaretColor(Color.DARK_GRAY);
    reg.setForeground(Color.DARK_GRAY);
    reg.setColumns(10);
    reg.setBorder(null);
    reg.setBackground(new Color(221,222,232));
    reg.setBounds(419, 158, 153, 20);
    f1.getContentPane().add(reg);
    
    JLabel lblReg_1 = new JLabel("REG :");
    lblReg_1.setForeground(new Color(0, 153, 255));
    lblReg_1.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 16));
    lblReg_1.setBounds(360, 167, 49, 14);
    f1.getContentPane().add(lblReg_1);
    
    reg_s = new JSeparator();
    reg_s.setForeground(new Color(10, 13, 13));
    reg_s.setBackground(Color.BLACK);
    reg_s.setBounds(419, 178, 153, 15);
    f1.getContentPane().add(reg_s);
    
    phone = new JTextField();
    phone.setText(get_phone);
    phone.addFocusListener(new FocusAdapter() {
    	@Override
    	public void focusGained(FocusEvent e) {
    		phone_s.setForeground(new Color(7,182,255));
    	}
    	@Override
    	public void focusLost(FocusEvent e) {
    		phone_s.setForeground(new Color(221,222,232));
    	}
    });
    phone.setCaretColor(Color.DARK_GRAY);
    phone.setForeground(Color.DARK_GRAY);
    phone.setColumns(10);
    phone.setBorder(null);
    phone.setBackground(new Color(221,222,232));
    phone.setBounds(419, 195, 153, 20);
    f1.getContentPane().add(phone);
    
    JLabel lblPhone = new JLabel("Phone :");
    lblPhone.setForeground(new Color(0, 153, 255));
    lblPhone.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 16));
    lblPhone.setBounds(360, 201, 72, 14);
    f1.getContentPane().add(lblPhone);
    
    phone_s = new JSeparator();
    phone_s.setForeground(new Color(10, 13, 13));
    phone_s.setBackground(Color.BLACK);
    phone_s.setBounds(419, 215, 153, 15);
    f1.getContentPane().add(phone_s);
    
    JLabel lblAdress = new JLabel("Adress :");
    lblAdress.setForeground(new Color(0, 153, 255));
    lblAdress.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 16));
    lblAdress.setBounds(360, 277, 64, 14);
    f1.getContentPane().add(lblAdress);
    
    JLabel lblStatus = new JLabel("Status :");
    lblStatus.setForeground(new Color(0, 153, 255));
    lblStatus.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 16));
    lblStatus.setBounds(360, 241, 59, 14);
    f1.getContentPane().add(lblStatus);
    
    status_c = new JComboBox();
    status_c.setFocusTraversalKeysEnabled(false);
    status_c.setForeground(new Color(0, 0, 0));
    
    
    status_c.setIgnoreRepaint(true);
    status_c.setFocusable(false);
    status_c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    status_c.setBorder(null);
    status_c.setBackground(new Color(221,222,232));
    status_c.setFont(new Font("Calibri Light", Font.BOLD, 13));
    status_c.setModel(new DefaultComboBoxModel(new String[] {"Active", "Inactive"}));
    status_c.setBounds(429, 238, 81, 20);
    status_c.setSelectedItem(get_status);
    f1.getContentPane().add(status_c);
    
    adress = new JTextArea();
    adress.setText(get_adress);
    
    adress.addFocusListener(new FocusAdapter() {
    	@Override
    	public void focusGained(FocusEvent e) {
    		adress.setBorder(new LineBorder(new Color(51, 255, 255)));
    		
    	}
    	@Override
    	public void focusLost(FocusEvent e) {
    		
    		adress.setBorder(new LineBorder(new Color(221,222,232)));
    	}
    });
    adress.setCaretColor(new Color(51, 255, 255));
    adress.setForeground(new Color(51, 153, 255));
    adress.setBackground(new Color(204, 204, 204));
    adress.setBounds(430, 281, 202, 92);
    f1.getContentPane().add(adress);
    
    JButton btnUpdateMemberInfo = new JButton("Update Member Info");
    btnUpdateMemberInfo.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		if(new_path.getText().equals("")){
    			String nam=name.getText();
        		String rol=roll.getText();
        		String reeg=reg.getText();
        		String phn=phone.getText();
        		String ads=adress.getText();
        		String st=status_c.getSelectedItem().toString();
        		String pathh=path.getText();
        		String idd=id.getText();
        		
        		Mem_info.update(nam, idd, rol, reeg, phn, ads, pathh, st);
        		Mem_info.load_active();
        		Mem_info.load_inactive();
        		f1.dispose();
    			
    		}
    		else{
    			//////////////////delete the old pic
    			try{

    	    		File file = new File(path.getText());

    	    		if(file.delete()){
    	    			System.out.println(file.getName() + " is deleted!");
    	    		}else{
    	    			System.out.println("Delete operation is failed.");
    	    		}

    	    	}catch(Exception e1){

    	    		e1.printStackTrace();

    	    	}
    			
    			///////////////copy new pic to dir
    			
    			File fileToCopy = new File(new_path.getText());
        	    File newFile = new File("E:/Dont Delete this file ,Meallab software data store/"+name.getText()+"_"+id.getText()+".jpg");
        	    		
 
        		try{
        		Files.copy(fileToCopy.toPath(),newFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
        		//FileUtils.copyFile(fileToCopy,newFile);
        		}
        		catch(IOException e1){
        			e1.printStackTrace();
        		}
        		
        		//////update
        		
        		String nam=name.getText();
        		String rol=roll.getText();
        		String reeg=reg.getText();
        		String phn=phone.getText();
        		String ads=adress.getText();
        		String st=status_c.getSelectedItem().toString();
        		String pathh="E:/Dont Delete this file ,Meallab software data store/"+name.getText()+"_"+id.getText()+".jpg";
        		String idd=id.getText();
        		
        		Mem_info.update(nam, idd, rol, reeg, phn, ads, pathh, st);
        		Mem_info.load_active();
        		Mem_info.load_inactive();
        		f1.dispose();
        		
    		}
    		
    		
    		
    	}
    });
    btnUpdateMemberInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpdateMemberInfo.setForeground(Color.BLACK);
    btnUpdateMemberInfo.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
    btnUpdateMemberInfo.setFocusPainted(false);
    btnUpdateMemberInfo.setBorderPainted(false);
    btnUpdateMemberInfo.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
    btnUpdateMemberInfo.setBackground(new Color(153, 153, 153));
    btnUpdateMemberInfo.setBounds(421, 418, 166, 23);
    f1.getContentPane().add(btnUpdateMemberInfo);
    
    JButton btnCancel = new JButton("Cancel");
    btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCancel.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		f1.dispose();
    	}
    });
    btnCancel.setForeground(Color.BLACK);
    btnCancel.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
    btnCancel.setFocusPainted(false);
    btnCancel.setBorderPainted(false);
    btnCancel.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
    btnCancel.setBackground(new Color(153, 153, 153));
    btnCancel.setBounds(605, 418, 86, 23);
    f1.getContentPane().add(btnCancel);
    
    path = new JTextField();
    
    path.setEditable(false);
    path.setText(get_photo_path);
    
    path.setForeground(Color.DARK_GRAY);
    path.setColumns(10);
    path.setCaretColor(Color.DARK_GRAY);
    path.setBorder(null);
    path.setBackground(new Color(221,222,232));
    path.setBounds(101, 302, 153, 20);
    f1.getContentPane().add(path);
    
    btnChangePhoto = new JButton("Change Photo");
    btnChangePhoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnChangePhoto.setForeground(Color.BLACK);
    btnChangePhoto.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		JFileChooser fc = new JFileChooser();
    		 fc.setDialogTitle("This is a JFileChooser");
             fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
             fc.setCurrentDirectory(new File(System.getProperty("user.name")));
             if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                 file_path= fc.getSelectedFile().getAbsolutePath();
             }
             
             new_path.setText(file_path);
 			
             //input image and set label size
             BufferedImage img = null;
             try {
                 img = ImageIO.read(new File(file_path));
             } catch (IOException e1) {
                 e1.printStackTrace();
             }
             
             Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
                     Image.SCALE_SMOOTH);
             
 			label.setIcon(new ImageIcon(dimg));
     	}
    	
  
    });
    btnChangePhoto.setFont(new Font("BERTHOLD", Font.PLAIN, 13));
    btnChangePhoto.setFocusPainted(false);
    btnChangePhoto.setBorderPainted(false);
    btnChangePhoto.setBorder(new LineBorder(new Color(0, 191, 255), 5, true));
    btnChangePhoto.setBackground(new Color(2, 145, 255));
    btnChangePhoto.setBounds(111, 332, 131, 23);
    f1.getContentPane().add(btnChangePhoto);
    
    new_path = new JTextField();
    new_path.setText((String) null);
    new_path.setForeground(Color.DARK_GRAY);
    new_path.setEditable(false);
    new_path.setColumns(10);
    new_path.setCaretColor(Color.DARK_GRAY);
    new_path.setBorder(null);
    new_path.setBackground(new Color(221,222,232));
    new_path.setBounds(102, 366, 153, 20);
    f1.getContentPane().add(new_path);
    
    new_path = new JTextField();
    new_path.setText((String) null);
    new_path.setForeground(new Color(0, 191, 255));
    new_path.setEditable(false);
    new_path.setColumns(10);
    new_path.setCaretColor(new Color(51, 255, 255));
    new_path.setBorder(null);
    new_path.setBackground(new Color(10, 13, 18));
    new_path.setBounds(102, 366, 153, 20);
    f1.getContentPane().add(new_path);
    

    f1.setVisible(true);
    f1.getContentPane().addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
    	 f1.setOpacity(0.80f);
        resizing = f1.getCursor().equals(Cursor.getDefaultCursor())? false:true;
        if(!e.isMetaDown()){
          point.x = e.getX();
          point.y = e.getY();
        }
      }
    	@Override
    	public void mouseReleased(MouseEvent e) {
    		f1.setOpacity(1f);
    	}
    });
    f1.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        if(resizing){
          Point pt = e.getPoint();
          f1.setSize(f1.getWidth()+pt.x - point.x,f1.getHeight());
          point.x = pt.x;
        }
        else if(!e.isMetaDown()){
        Point p = f1.getLocation();
        f1.setLocation(p.x + e.getX() - point.x,
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
        new Profile_view().buildGUI(null,null, null, null, null, null, null, null);
      }
    });
  }
}