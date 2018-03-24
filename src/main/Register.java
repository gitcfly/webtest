package main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String admine=(String) req.getParameter("admine");
		String name=(String) req.getParameter("name");
		String password=(String) req.getParameter("password");
		String repassword=(String) req.getParameter("repassword");
		if(name==null||admine==null||password==null||repassword==null||repassword==null||name.equals("")||admine.equals("")||password.equals("")||!password.equals(repassword)){
			resp.getWriter().print("the requried data is not provided fully");
			return;
		}else{
			String sql="select * from users where admine='"+admine+"'";
			ResultSet set=tomysql.querysql(sql);
			try {
				if(set.next()){
					resp.getWriter().print("the user is exsit..");
					return;
					
				}else{
					String sql0="insert into users values('"+admine+"','"+name+"','"+password+"')";
					int result=tomysql.updatesql(sql0);
					if(result>0)
						resp.getWriter().print("registerok");
					else
						resp.getWriter().print("registerfail");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
