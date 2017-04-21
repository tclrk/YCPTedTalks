package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.booksdb.persist.IDatabase;
import edu.ycp.cs320.aroby.model.Search;

public class SearchController {
	private Search model;
	private IDatabase db;
	
	public void setModel(Search model) {
		this.model = model;
	}

	public Search getSearch(){
		model.setSearch(model.getSearch());
		return model;
	}
}
