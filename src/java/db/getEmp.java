package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getEmp extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
	{
            ResultSet rs = db.Admin.getEmployee();
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();
            PrintWriter out=resp.getWriter();
            out.print("[");
            rs.next();

            while(true)
            {               
                    out.print("{");         
                for(int i=1;i<=numberOfColumns;i++)
                    {
                    out.print("\"" + rsMetaData.getColumnName(i) + "\":\""  + 
                    rs.getString(rsMetaData.getColumnName(i)) + "\""); 
                    if(i<numberOfColumns)
                                    out.print(",");
                    }
                out.print("}");
                if(rs.next())
                    out.print(",\n");
                else
                    {
                    out.print("]");
                    break;
                    }
            }
        }
        catch (Exception ex) {
            Logger.getLogger(getEmp.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
