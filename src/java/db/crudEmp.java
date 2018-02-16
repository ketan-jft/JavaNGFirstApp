package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class crudEmp extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String dml_type = req.getParameter("dmlType");
	String emp_code = req.getParameter("empCode");
	String emp_name = req.getParameter("empName");
        if("Ins".equals(dml_type))
        {
            try{
                db.Admin.addEmp(emp_code, emp_name);
            }catch(Exception e){
                
            }
        }
	else if("Del".equals(dml_type))
	{
            try{
                db.Admin.delEmp(emp_code);
            }catch(Exception e){
                
            }
        }
	else if("Upd".equals(dml_type))
	{
            try{
                db.Admin.updEmp(emp_code, emp_name);
            }catch(Exception e){
                
            }
        }
    }

}
