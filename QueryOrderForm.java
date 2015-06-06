package sj;

import java.awt.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class QueryOrderForm extends JDialog {
  private int testQuery =0 ;
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
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private JButton jButton4 = new JButton();
  private JButton jButton5 = new JButton();

  public QueryOrderForm(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public QueryOrderForm() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    jPanel1.setLayout(xYLayout1);
    jLabel1.setText("订货商品名称");
    jLabel2.setText("订货厂商");
    jLabel3.setText("订货日期");
    jLabel4.setText("订货状态");
    jButton1.setText("查询");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jButton2.setText("查询");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    jButton3.setText("查询");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton3_actionPerformed(e);
      }
    });
    jButton4.setText("查询");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton4_actionPerformed(e);
      }
    });
    jButton5.setText("退出");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton5_actionPerformed(e);
      }
    });
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jTextField1,    new XYConstraints(122, 20, 110, 24));
    jPanel1.add(jTextField4,     new XYConstraints(122, 156, 109, 25));
    jPanel1.add(jButton1,   new XYConstraints(281, 20, 61, 23));
    jPanel1.add(jButton3,     new XYConstraints(282, 112, 60, 21));
    jPanel1.add(jButton4,     new XYConstraints(283, 156, 60, 21));
    jPanel1.add(jButton2,      new XYConstraints(281, 65, 61, 22));
    jPanel1.add(jLabel1,  new XYConstraints(28, 20, 92, 24));
    jPanel1.add(jTextField2,     new XYConstraints(122, 65, 111, 25));
    jPanel1.add(jLabel3,     new XYConstraints(28, 112, 92, 24));
    jPanel1.add(jTextField3,     new XYConstraints(122, 112, 111, 25));
    jPanel1.add(jLabel4,    new XYConstraints(28, 156, 96, 24));
    jPanel1.add(jLabel2,   new XYConstraints(28, 65, 95, 26));
    jPanel1.add(jButton5,  new XYConstraints(291, 205, 75, 22));
  }
  public void cancel(){
    dispose() ;
  }
  void jButton1_actionPerformed(ActionEvent e) {
    testQuery = 1 ;
    cancel() ;
  }
  //cancel
  void jButton5_actionPerformed(ActionEvent e) {
    cancel() ;
  }

  void jButton2_actionPerformed(ActionEvent e) {
    testQuery = 2 ;
    cancel() ;
  }

  void jButton3_actionPerformed(ActionEvent e) {
    testQuery = 3 ;
    cancel() ;
  }

  void jButton4_actionPerformed(ActionEvent e) {
    testQuery = 4 ;
    cancel() ;
  }

  public String getBuyerGoodsName(){
    return jTextField1.getText( ) ;
  }
  public String getBuyerManufacturer(){
    return jTextField2.getText() ;
  }
  public String getBuyerDate(){
    return jTextField3.getText() ;
  }
  public String getBuyerStatus(){
    return jTextField4.getText() ;
  }
  public int gettestQuery(){
    return testQuery ;
  }

}
