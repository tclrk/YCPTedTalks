package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;
import java.sql.Connection;

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
import java.sql.SQLException;
import java.util.ArrayList;


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
			
			ArrayList <TedTalk> foundList = null;
			ArrayList <TedTalk> searchList = new ArrayList();
			query = conn.prepareStatement(
					"select * "
					+ "  from tedtalks, speakers, topics"
					+ "  where tedtalks.speaker_id = speakers.speaker_id"
					+ "  and tedtalks.topic_id = topics.topid_id"
					+ "  and reviews.tedtalk_id = tedtalks.tedtalk_id"
					+ "  and title like %" + searchInput + "% "
					+ "  or text like %" + searchInput + "% "
					+ "  or topic like %" + searchInput + "% " 
					+ "  or Description like %" + searchInput + "% " 
					+ "  or URL like %" + searchInput + "% " );

			query.setString(1, searchInput);			
			resultSet = query.executeQuery();
			
			while(resultSet.next()){
				foundList = new ArrayList();
				for(int i = 0; i < foundList.size(); i++){
					foundList.add((TedTalk) resultSet.getObject(0));
					searchList.add(foundList.get(i));
				}
			}
			req.setAttribute("model", model);
			req.getRequestDispatcher("/_view/searchView.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//private int getInteger(HttpServletRequest req, String name) {
		//return Integer.parseInt(req.getParameter(name));
	//}
}
