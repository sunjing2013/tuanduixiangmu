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

public class UpdateOrderForm extends JDialog {
  private JPanel panel1 = new JPanel();
  private XYLayout xYLayout1 = new XYLayout();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private Database database1 = new Database();

  public UpdateOrderForm(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public UpdateOrderForm() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    panel1.setLayout(xYLayout1);
    jLabel1.setText("BuyerID");
    jLabel2.setText("BuyerStatus");
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
    database1.setConnection(new com.borland.dx.sql.dataset.ConnectionDescriptor("jdbc:odbc:gaokaiSQL", "sa", "", false, "sun.jdbc.odbc.JdbcOdbcDriver"));
    getContentPane().add(panel1);
    panel1.add(jLabel1,   new XYConstraints(27, 27, 82, 19));
    panel1.add(jLabel2,   new XYConstraints(26, 63, 88, 20));
    panel1.add(jTextField1,     new XYConstraints(120, 27, 107, 21));
    panel1.add(jTextField2,   new XYConstraints(120, 63, 108, 21));
    panel1.add(jButton2,    new XYConstraints(235, 105, 70, 21));
    panel1.add(jButton1, new XYConstraints(153, 106, 69, 21));
  }
  public void cancel(){
    dispose() ;
  }

  void jButton2_actionPerformed(ActionEvent e) {
    cancel() ;
  }

  void jButton1_actionPerformed(ActionEvent e) {
    try{
      String BuyerID = jTextField1.getText().trim() ;
      String BuyerStatus = jTextField2.getText().trim();
      Statement sql = database1.createStatement() ;
      sql.executeUpdate("UPDATE [UML_CS].[dbo].[Buyer_TABLE] SET BuyerStatus = '"+BuyerStatus+"' WHERE BuyerID = '"+BuyerID+"' ") ;
      cancel() ;
    }
    catch(SQLException www){www.printStackTrace();}
  }
}
