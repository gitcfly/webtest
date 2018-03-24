package main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String admine=(String) req.getParameter("admine");
		String password=(String) req.getParameter("password");
		
		if(admine==null||password==null||admine.equals("")||password.equals("")){
			resp.getWriter().print("the requried data is not provided fully");
			return;
		}else{
			String sql="select * from users where admine='"+admine+"' and password='"+password+"'";
			ResultSet set=tomysql.querysql(sql);
			try {
				if(set.next()){
					HttpSession session=req.getSession();
					session.setAttribute("admine",admine);
					session.setAttribute("name", set.getString("name"));
					session.setAttribute("isonline", "true");
					resp.sendRedirect("/webtest/views/friendslist.jsp");
				}else{
					HttpSession session=req.getSession();
					session.setAttribute("isonline", "false");
					resp.getWriter().print("the user is not exist or the admine or password is error");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
