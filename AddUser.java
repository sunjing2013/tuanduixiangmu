package sj;

import java.awt.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;
import java.awt.event.*;
import com.borland.dx.sql.dataset.*;
import java.sql.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class AddUser extends JDialog {
    private JPanel panel1 = new JPanel();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel jPanel1 = new JPanel();
    private XYLayout xYLayout1 = new XYLayout();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField3 = new JTextField();
    private JTextField jTextField4 = new JTextField();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JTextField jTextField5 = new JTextField();
    private JPasswordField jTextField6 = new JPasswordField();
    private JPasswordField jTextField7 = new JPasswordField();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();

    public AddUser(Frame frame, String title, boolean modal) {
      super(frame, title, modal);
      try {
        jbInit();
        pack();
      }
      catch(Exception ex) {
        ex.printStackTrace();
      }
    }

    public AddUser() {
      this(null, "", false);
    }
    private void jbInit() throws Exception {
      panel1.setLayout(borderLayout1);
      jPanel1.setLayout(xYLayout1);
      jLabel1.setText("姓名");
      jLabel2.setText("年龄");
      jLabel3.setText("性别");
      jLabel4.setText("类别");
      jLabel5.setText("请输入密码");
      jLabel6.setText("请再输一遍");
      jLabel7.setText("家庭住址");
      jButton1.setText("确定");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          jButton1_actionPerformed(e);
        }
      });
      jButton2.setText("取消");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          jButton2_actionPerformed(e);
        }
      });
      jPanel1.setPreferredSize(new Dimension(400, 300));
      getContentPane().add(panel1);
      panel1.add(jPanel1, BorderLayout.CENTER);
      jPanel1.add(jTextField1,  new XYConstraints(80, 31, 76, 25));
      jPanel1.add(jTextField2,   new XYConstraints(79, 76, 78, 23));
      jPanel1.add(jTextField3,  new XYConstraints(79, 119, 77, 25));
      jPanel1.add(jTextField4,  new XYConstraints(78, 159, 77, 26));
      jPanel1.add(jLabel4, new XYConstraints(26, 158, 42, 28));
      jPanel1.add(jLabel3, new XYConstraints(28, 118, 39, 28));
      jPanel1.add(jLabel2, new XYConstraints(28, 76, 48, 26));
      jPanel1.add(jLabel1,  new XYConstraints(31, 35, 41, 27));
      jPanel1.add(jLabel7, new XYConstraints(185, 30, 49, 25));
      jPanel1.add(jTextField5,     new XYConstraints(258, 35, 120, -1));
      jPanel1.add(jLabel5,  new XYConstraints(185, 78, 78, 23));
      jPanel1.add(jLabel6,    new XYConstraints(185, 116, 73, 23));
      jPanel1.add(jTextField7,    new XYConstraints(258, 119, 121, 23));
      jPanel1.add(jTextField6,  new XYConstraints(258, 79, 119, 24));
      jPanel1.add(jButton1,   new XYConstraints(197, 194, 80, 26));
      jPanel1.add(jButton2,    new XYConstraints(296, 194, 82, 26));
    }
    public void actionPerformed(ActionEvent ee){
    }

    void jButton1_actionPerformed(ActionEvent e) {
      String userName = String.valueOf(jTextField1.getText()) ;
      int userAge = Integer.parseInt(String.valueOf(jTextField2.getText())) ;
      String userGender = String.valueOf(jTextField3.getText()) ;
      String userAuthority = String.valueOf(jTextField4.getText()) ;
      String userAddress = String.valueOf(jTextField5.getText()) ;
      String userPassword = String.valueOf(jTextField6.getPassword()) ;
      String testPassword = String.valueOf(jTextField7.getPassword()) ;
      if(userPassword.equals(testPassword)){
        try{
          Database database1 = new Database();
          database1.setConnection(new com.borland.dx.sql.dataset.ConnectionDescriptor("jdbc:odbc:gaokaiSQL", "sa", "", false, "sun.jdbc.odbc.JdbcOdbcDriver"));
          Statement sql1 = database1.createStatement() ;
          sql1.executeUpdate("INSERT INTO [UML_CS].[dbo].[user](userName, userAge , userGender, userAuthority , userAddress , userPassword) VALUES('"+userName+"' , '"+userAge+"' , '"+userGender+"' , '"+userAuthority+"' , '"+userAddress+"','"+userPassword+"')") ;
          JOptionPane.showMessageDialog(null,"填加成功","",JOptionPane.DEFAULT_OPTION);
          cancel();
        }
        catch(SQLException www){www.printStackTrace();}
      }
      else{
        JOptionPane.showMessageDialog(null,"您输入的密码前后不符,请重新输入","",JOptionPane.DEFAULT_OPTION);
      }
    }

    public void cancel(){
      dispose() ;
    }
    void jButton2_actionPerformed(ActionEvent e) {
      cancel() ;
    }
  }

