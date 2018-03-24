package main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFriend extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String addadmine=(String) req.getParameter("addadmine");
		String admine=(String) req.getSession().getAttribute("admine");
		if(addadmine.equals(admine)){
			req.setAttribute("addresult", "you can not add youself");
			req.getRequestDispatcher("/views/addresult.jsp").forward(req, resp);
		}else{
			String sql="select * from friendship where admine1='"+admine+"' and admine2='"+addadmine+"'";
			ResultSet set=tomysql.querysql(sql);
			try {
				if(set.next()){
					req.setAttribute("addresult", "you are aready friend");
					req.getRequestDispatcher("/views/addresult.jsp").forward(req, resp);
					
				}
				else{
					String sql1="insert into friendship VALUES('"+addadmine+"','"+admine+"')";
					String sql2="insert into friendship VALUES('"+admine+"','"+addadmine+"')";
					tomysql.updatesql(sql1);
					tomysql.updatesql(sql2);
					req.setAttribute("addresult", "addtrue");
					req.getRequestDispatcher("/views/addresult.jsp").forward(req, resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
