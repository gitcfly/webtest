package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchUser extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String admine=(String)req.getParameter("searchwho");
		System.out.println("searchwho:"+admine);
		HttpSession session=req.getSession();
		ArrayList<User> fs=dbhelper.searchUser(admine);
		session.setAttribute("result", fs);
		resp.sendRedirect("/webtest/views/addfriend.jsp");
	}
}
