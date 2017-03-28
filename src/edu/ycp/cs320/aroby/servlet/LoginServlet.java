package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.aroby.controller.LoginController;
import edu.ycp.cs320.aroby.controller.NumbersController;
import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Numbers;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account model = new Account();
		LoginController controller= new LoginController();
		controller.setModel(model);
		
		String inputEmail = req.getParameter("email");
		String inputPass = req.getParameter("password");
		
		if(inputEmail != null) {
			model.setEmail(inputEmail);
		}
		if(inputPass != null) {
			model.setPassword(inputPass);
		}
		// TODO: Session information
		HttpSession session =  req.getSession(true);
		session.setAttribute("login", true);
		session.setAttribute("name", model.getName());

		// TODO: check database to see if this matches any accounts we have
		resp.sendRedirect("/aroby/index");
	}
}
