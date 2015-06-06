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

public class BuyerWindow extends JDialog {
  private JPanel panel1 = new JPanel();
  private Database database1 = new Database();
  private QueryDataSet queryDataSet1 = new QueryDataSet();
  private QueryDataSet queryDataSet2 = new QueryDataSet();
  private QueryDataSet queryDataSet3 = new QueryDataSet();
  private QueryDataSet queryDataSet4 = new QueryDataSet();
  private QueryDataSet queryDataSet5 = new QueryDataSet();
  private XYLayout xYLayout1 = new XYLayout();
  private JPanel jPanel1 = new JPanel();
  private XYLayout xYLayout2 = new XYLayout();
  private JdbTable jdbTable1 = new JdbTable();
  private TableScrollPane tableScrollPane1 = new TableScrollPane();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton5 = new JButton();
  private JButton jButton3 = new JButton();
  private JButton jButton4 = new JButton();

  public BuyerWindow(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public BuyerWindow() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    panel1.setLayout(xYLayout1);
    database1.setConnection(new com.borland.dx.sql.dataset.ConnectionDescriptor("jdbc:odbc:gaokaiSQL", "sa", "", false, "sun.jdbc.odbc.JdbcOdbcDriver"));
    jPanel1.setLayout(xYLayout2);
    jButton1.setText("查看全部订货单");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jButton2.setText("分项查询");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    jButton5.setText("退出");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton5_actionPerformed(e);
      }
    });
    jButton3.setText("增加订单");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton3_actionPerformed(e);
      }
    });
    jButton4.setText("更改订单状态");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton4_actionPerformed(e);
      }
    });
    panel1.add(jPanel1,  new XYConstraints(190, 154, -1, -1));
    panel1.add(jdbTable1,  new XYConstraints(1, 0, 399, 238));
    panel1.add(tableScrollPane1,  new XYConstraints(192, 117, -1, -1));
    panel1.add(jButton2,  new XYConstraints(155, 244, 110, 23));
    panel1.add(jButton1, new XYConstraints(8, 244, 128, 22));
    panel1.add(jButton3,   new XYConstraints(9, 274, 128, 20));
    panel1.add(jButton4,      new XYConstraints(155, 274, 111, 21));
    panel1.add(jButton5,  new XYConstraints(292, 274, 106, 22));
    this.getContentPane().add(panel1, BorderLayout.SOUTH);
  }
  public void cancel(){
    dispose() ;
  }
  //浏览全部商品订货单
  void jButton1_actionPerformed(ActionEvent e) {
    initialize () ;
    queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1, "SELECT Buyer_TABLE.BuyerID,Buyer_TABLE.BuyerGoodsName,Buyer_TABLE.BuyerGoodsNumber,Buyer_TABLE.BuyerM" +
        "anufacturer,Buyer_TABLE.BuyerDate,Buyer_TABLE.BuyerStatus FROM UML_CS.dbo.Buyer_TABLE", null, true, Load.ALL));
    jdbTable1.setDataSet(queryDataSet1);
    queryDataSet1.refresh();
  }
  //增加订货单
  void jButton3_actionPerformed(ActionEvent e) {
    AddOrderForm addOrderForm = new AddOrderForm() ;
    Dimension dlgSize = addOrderForm.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    addOrderForm.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    addOrderForm.setModal(true);
    addOrderForm.pack();
    addOrderForm.show();
    queryDataSet1.refresh();
  }

  void jButton5_actionPerformed(ActionEvent e) {
    cancel() ;
  }
  //分项选择
  void jButton2_actionPerformed(ActionEvent e) {
    QueryOrderForm queryOrderForm = new QueryOrderForm() ;
    Dimension dlgSize = queryOrderForm.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    queryOrderForm.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    queryOrderForm.setModal(true);
    queryOrderForm.pack();
    queryOrderForm.show();
    switch(queryOrderForm.gettestQuery()){
      case 1:
        initialize () ;
        String BuyerGoodsName = queryOrderForm.getBuyerGoodsName().trim();
        queryDataSet2.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1, "SELECT Buyer_TABLE.BuyerID,Buyer_TABLE.BuyerGoodsName,Buyer_TABLE.BuyerGoodsNumber,Buyer_TABLE.BuyerM" +
            "anufacturer,Buyer_TABLE.BuyerDate,Buyer_TABLE.BuyerStatus FROM UML_CS.dbo.Buyer_TABLE WHERE BuyerGoodsName = '"+BuyerGoodsName+"'", null, true, Load.ALL));
        jdbTable1.setDataSet(queryDataSet2);
        queryDataSet2.refresh();
        break;
      case 2:
        initialize () ;
        String BuyerManufacturer = queryOrderForm.getBuyerManufacturer().trim();
        queryDataSet3.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1, "SELECT Buyer_TABLE.BuyerID,Buyer_TABLE.BuyerGoodsName,Buyer_TABLE.BuyerGoodsNumber,Buyer_TABLE.BuyerM" +
            "anufacturer,Buyer_TABLE.BuyerDate,Buyer_TABLE.BuyerStatus FROM UML_CS.dbo.Buyer_TABLE WHERE BuyerManufacturer = '"+BuyerManufacturer+"'", null, true, Load.ALL));
        jdbTable1.setDataSet(queryDataSet3);
        queryDataSet3.refresh();
        break;
      case 3:
        initialize () ;
        String BuyerDate = queryOrderForm.getBuyerDate().trim();
        queryDataSet4.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1, "SELECT Buyer_TABLE.BuyerID,Buyer_TABLE.BuyerGoodsName,Buyer_TABLE.BuyerGoodsNumber,Buyer_TABLE.BuyerM" +
            "anufacturer,Buyer_TABLE.BuyerDate,Buyer_TABLE.BuyerStatus FROM UML_CS.dbo.Buyer_TABLE WHERE BuyerDate = '"+BuyerDate+"'", null, true, Load.ALL));
        jdbTable1.setDataSet(queryDataSet4);
        queryDataSet4.refresh();
        break;
      case 4:
        initialize () ;
        String BuyerStatus = queryOrderForm.getBuyerStatus().trim();
        queryDataSet5.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1, "SELECT Buyer_TABLE.BuyerID,Buyer_TABLE.BuyerGoodsName,Buyer_TABLE.BuyerGoodsNumber,Buyer_TABLE.BuyerM" +
            "anufacturer,Buyer_TABLE.BuyerDate,Buyer_TABLE.BuyerStatus FROM UML_CS.dbo.Buyer_TABLE WHERE BuyerStatus = '"+BuyerStatus+"'", null, true, Load.ALL));
        jdbTable1.setDataSet(queryDataSet5);
        queryDataSet5.refresh();
        break;
      default:JOptionPane.showMessageDialog(null,"请选择正确的选项","",JOptionPane.DEFAULT_OPTION);
    }
  }
  public void initialize (){
    queryDataSet1.close() ;
    queryDataSet2.close() ;
    queryDataSet3.close() ;
    queryDataSet4.close() ;
    queryDataSet5.close() ;
  }

  void jButton4_actionPerformed(ActionEvent e) {
    UpdateOrderForm updateOrderForm = new UpdateOrderForm() ;
   Dimension dlgSize = updateOrderForm.getPreferredSize();
   Dimension frmSize = getSize();
   Point loc = getLocation();
   updateOrderForm.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
   updateOrderForm.setModal(true);
   updateOrderForm.pack();
   updateOrderForm.show();
    queryDataSet1.refresh();
  }
}
