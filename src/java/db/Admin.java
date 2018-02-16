package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Admin {
    public static String display()
    {
        return "Powered by eTechShala";
    }
    
   public static Connection connect() throws Exception 
   {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/ngjava","root","12345");
   }
   
   public static ResultSet getEmployee() throws Exception
   {
       return connect().prepareCall("{call getEmployee()}").executeQuery();
   }
   
   public static ResultSet getEmpNames() throws Exception
   {
       return connect().prepareCall("{call getEmpNames()}").executeQuery();
   }
   
   public static void addEmp(String emp_code,String emp_name)
   {
     try
     {
         CallableStatement cs = connect().prepareCall("{call addEmp(?,?)}");
         cs.setString(1, emp_code);
         cs.setString(2, emp_name);
         cs.execute();
     }catch(Exception ex) { }
   }
   
   public static void updEmp(String emp_code,String emp_name)
   {
     try
     {
         CallableStatement cs = connect().prepareCall("{call updEmp(?,?)}");
         cs.setString(1, emp_code);
         cs.setString(2, emp_name);
         cs.execute();
     }catch(Exception ex) { }
   }
   
   public static void delEmp(String id)
   {
       try
       {
         CallableStatement cs = connect().prepareCall("{call delEmp(?)}");
         cs.setString(1, id);  
         cs.execute();
       }catch(Exception ex)
       {   }
   }
 
}
