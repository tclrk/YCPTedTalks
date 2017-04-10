package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.model.Search;
import edu.ycp.cs320.aroby.controller.SearchController;

public class SearchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/searchPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Search model = new Search();
		SearchController control = new SearchController();
		
		
		
		String searchInput = req.getParameter("search");
		if(searchInput != ""){
			model.setSearch(searchInput);
		}
		control.setModel(model);
		
		req.setAttribute("model", model);
		req.getRequestDispatcher("/_view/searchPage.jsp").forward(req, resp);
		
	}
	
	//private int getInteger(HttpServletRequest req, String name) {
		//return Integer.parseInt(req.getParameter(name));
	//}
}
