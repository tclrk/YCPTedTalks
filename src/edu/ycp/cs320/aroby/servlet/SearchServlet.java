package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.model.Search;
import edu.ycp.cs320.aroby.controller.SearchController;
import edu.ycp.cs320.aroby.model.TedTalk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import edu.ycp.cs320.sqldemo.DBUtil;


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
		Connection conn =  null;
		PreparedStatement  query = null;
		ResultSet resultSet = null;
		
		try{
			conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");
			String searchInput = req.getParameter("search");
			
			if(searchInput != ""){
				model.setSearch(searchInput);
			}
			control.setModel(model);
			
			ArrayList<TedTalk> searchList = null;
			query = conn.prepareStatement(
					"select * "
					+ "  from (reviews)"
					+ "  where concat(author, title, topic, description, review, rating) like %" + searchInput + "% ");
		
			query.setString(1, searchInput);
			resultSet = query.executeQuery();
			
			while(resultSet.next()){
				searchList = new ArrayList();
				
				searchList.add(resultSet.getArray(0));
			}
			req.setAttribute("model", model);
			req.getRequestDispatcher("/_view/searchView.jsp").forward(req, resp);
		}
		finally{
			DBUtil.closeQuietly(conn);
			DBUtil.closeQuietly(query);
			DBUtil.closeQuietly(resultSet);
		}
	}
	
	//private int getInteger(HttpServletRequest req, String name) {
		//return Integer.parseInt(req.getParameter(name));
	//}
}
