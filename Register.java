package sj;

import com.borland.dx.sql.dataset.*;
import java.sql.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Register {
  public Register( String userName , int userAge , String userGender , String userAuthority ,String userAddress ,String userPassword , String testPassword ){
    if(userPassword.equals(testPassword)){
      try{
        Database database1 = new Database();
         database1.setConnection(new com.borland.dx.sql.dataset.ConnectionDescriptor("jdbc:odbc:gaokaiSQL", "sa", "", false, "sun.jdbc.odbc.JdbcOdbcDriver"));
        Statement sql1 = database1.createStatement() ;
        JOptionPane.showMessageDialog(null,"注册成功,请重新登陆","",JOptionPane.DEFAULT_OPTION);
        sql1.executeUpdate("INSERT INTO [UML_CS].[dbo].[user](userName, userAge , userGender, userAuthority , userAddress , userPassword) VALUES('"+userName+"' , '"+userAge+"' , '"+userGender+"' , '"+userAuthority+"' , '"+userAddress+"','"+userPassword+"')") ;
      }
      catch(SQLException www){www.printStackTrace();}
    }
    else{
      JOptionPane.showMessageDialog(null,"您输入的密码前后不符,请重新输入","",JOptionPane.DEFAULT_OPTION);
    }
  }
}
