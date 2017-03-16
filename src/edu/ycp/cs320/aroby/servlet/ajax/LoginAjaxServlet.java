package edu.ycp.cs320.aroby.servlet.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.controller.LoginController;
import edu.ycp.cs320.aroby.controller.NumbersController;
import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Numbers;

public class LoginAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account model = new Account();
		LoginController controller= new LoginController();
		controller.setModel(model);
		try {
			String inputEmail = req.getParameter("email");
			String inputPass = req.getParameter("password");

			if(inputEmail.equals("email")) {
				model.setEmail(inputEmail);
			}
			if(inputPass.equals("password")) {
				model.setPassword(inputPass);
			}
			else {
				throw new Exception();
			}
		} catch (Exception ex) {
			badRequest("Invalid login credentials.", resp);
		}
		
		// TODO: check database to see if this matches any accounts we have
	}

	private void badRequest(String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.getWriter().println(message);
	}
}
