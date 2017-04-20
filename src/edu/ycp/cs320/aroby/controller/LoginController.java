package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.aroby.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.aroby.booksdb.persist.IDatabase;
import edu.ycp.cs320.aroby.model.Account;

public class LoginController {
	private Account model;
	private IDatabase db;
	
	public LoginController() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public void setModel(Account model) {
		this.model = model;
	}
	
	public boolean login() {
		boolean success = false;
		
		Account retrievedAccount = db.findAccount(model.getEmail());
		if (retrievedAccount.getEmail().equals(model.getEmail())
				&& retrievedAccount.getPassword().equals(model.getPassword())) {
			success = true;
		}
		
		return success;
	}
}
