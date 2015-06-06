package sj;

import java.awt.*;
import javax.swing.*;
import com.borland.dx.sql.dataset.*;
import com.borland.dbswing.*;
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

public class ManagementWindow extends JDialog {
  private Database database1 = new Database();
  private QueryDataSet queryDataSet1 = new QueryDataSet();
  private JPanel jPanel1 = new JPanel();
  private JdbTable jdbTable1 = new JdbTable();
  private XYLayout xYLayout1 = new XYLayout();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private QueryDataSet queryDataSet2 = new QueryDataSet();
  private TableScrollPane tableScrollPane1 = new TableScrollPane();

  public ManagementWindow(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public ManagementWindow() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    jPanel1.setLayout(xYLayout1);
    jButton1.setText("查看进货信息");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jButton2.setText("查看销售信息");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    jButton3.setText("退出");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton3_actionPerformed(e);
      }
    });
    database1.setConnection(new com.borland.dx.sql.dataset.ConnectionDescriptor("jdbc:odbc:gaokaiSQL", "sa", "", false, "sun.jdbc.odbc.JdbcOdbcDriver"));
    database1.setDatabaseName("");
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jdbTable1,        new XYConstraints(2, 2, 332, 187));
    jPanel1.add(jButton1,     new XYConstraints(5, 208, 109, 20));
    jPanel1.add(jButton3,     new XYConstraints(255, 208, 73, 20));
    jPanel1.add(jButton2,  new XYConstraints(123, 208, 106, 20));
    jPanel1.add(tableScrollPane1,  new XYConstraints(192, 61, -1, -1));
  }

  void jButton1_actionPerformed(ActionEvent e) {
    intilize();
    queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1, "SELECT Buyer_TABLE.BuyerID,Buyer_TABLE.BuyerGoodsName,Buyer_TABLE.BuyerGoodsNumber,Buyer_TABLE.BuyerM" +
        "anufacturer,Buyer_TABLE.BuyerDate,Buyer_TABLE.BuyerStatus,Buyer_TABLE.BuyerName " +
        "FROM UML_CS.dbo.Buyer_TABLE", null, true, Load.ALL));
    jdbTable1.setDataSet(queryDataSet1);
    queryDataSet1.refresh();
  }

  void jButton2_actionPerformed(ActionEvent e) {
    intilize();
    queryDataSet2.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1, "SELECT vendition_TABLE.VenditionID,vendition_TABLE.GoodsName,vendition_TABLE.GoodsCustomNumber,vendit" +
        "ion_TABLE.CustomerName,vendition_TABLE.VenditionDate,vendition_TABLE.GoodsSize,vendition_TABLE.GoodsP" +
        "rice FROM UML_CS.dbo.vendition_TABLE", null, true, Load.ALL));
    jdbTable1.setDataSet(queryDataSet2);
    queryDataSet2.refresh();
  }
  public void intilize(){
    queryDataSet1.close();
    queryDataSet2.close();
  }

  void jButton3_actionPerformed(ActionEvent e) {
    dispose() ;
  }
}
