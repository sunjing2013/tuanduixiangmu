package sj;

import java.awt.*;
import javax.swing.*;
import com.borland.dbswing.*;
import com.borland.jbcl.layout.*;
import com.borland.dx.sql.dataset.*;
import java.awt.event.*;
import java.sql.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class UserManagement extends JDialog {
  private JPanel panel1 = new JPanel();
  private XYLayout xYLayout1 = new XYLayout();
  private JdbTable jdbTable1 = new JdbTable();
  private QueryDataSet queryDataSet1 = new QueryDataSet();
  private Database database1 = new Database();
  private TableScrollPane tableScrollPane1 = new TableScrollPane();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private JButton jButton4 = new JButton();
  private JButton jButton5 = new JButton();

  public UserManagement(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public UserManagement() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    panel1.setLayout(xYLayout1);
    database1.setConnection(new com.borland.dx.sql.dataset.ConnectionDescriptor("jdbc:odbc:gaokaiSQL", "sa", "", false, "sun.jdbc.odbc.JdbcOdbcDriver"));
    queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1, "SELECT [user].userID,[user].userName,[user].userPassword,[user].userAddress,[user].userAuthority,[use" +
        "r].userGender,[user].userAge FROM [UML_CS].[dbo].[user]", null, true, Load.ALL));
    jButton1.setText("增加用户");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jButton2.setText("修改用户");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    jButton3.setText("删除用户");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton3_actionPerformed(e);
      }
    });
    jButton4.setText("查看用户");
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
    getContentPane().add(panel1);
    panel1.add(jdbTable1,              new XYConstraints(-1, 0, 389, 253));
    panel1.add(tableScrollPane1,  new XYConstraints(215, 192, -1, -1));
    panel1.add(jButton1,  new XYConstraints(112, 255, 100, 26));
    panel1.add(jButton4,     new XYConstraints(2, 255, 99, 27));
    panel1.add(jButton5,  new XYConstraints(316, 292, 72, 24));
    panel1.add(jButton2, new XYConstraints(1, 291, 99, 25));
    panel1.add(jButton3, new XYConstraints(111, 290, 104, 26));
  }

  void jButton4_actionPerformed(ActionEvent e) {
    jdbTable1.setDataSet(queryDataSet1) ;
    queryDataSet1.refresh();
  }
  //增加用户
  void jButton1_actionPerformed(ActionEvent e) {
    AddUser adduser = new AddUser() ;
    Dimension dlgSize = adduser.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    adduser.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    adduser.setModal(true);
    adduser.pack();
    adduser.show();
    queryDataSet1.refresh();
    jdbTable1.setDataSet(queryDataSet1) ;
  }

  void jButton3_actionPerformed(ActionEvent e) {
    DeleteUser deleteUser = new DeleteUser() ;
    Dimension dlgSize = deleteUser.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    deleteUser.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    deleteUser.setModal(true);
    deleteUser.pack();
    deleteUser.show();
    queryDataSet1.refresh();
    jdbTable1.setDataSet(queryDataSet1) ;
  }

  void jButton2_actionPerformed(ActionEvent e) {
    UpdateUser updateUser = new UpdateUser() ;
    Dimension dlgSize = updateUser.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    updateUser.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    updateUser.setModal(true);
    updateUser.pack();
    updateUser.show();
    queryDataSet1.refresh();
    jdbTable1.setDataSet(queryDataSet1) ;
  }

  void jButton5_actionPerformed(ActionEvent e) {
    dispose() ;
  }
}
