package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.aroby.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.aroby.booksdb.persist.IDatabase;
import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Student;

public class AccountController {
	private Account model;
	private IDatabase db;
	
	public AccountController() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public Account getModel() {
		return model;
	}
	
	public void setModel(Account model) {
		this.model = model;
	}

	public boolean createAccount(Account model) {
		boolean success = false;
		success = db.createNewAccount(model.getEmail(), model.getPassword(),
					model.getFirstName(), model.getLastName(), model.getAdmin());
		
		return success;
	}
	
	public boolean createStudent(Student model) {
		boolean success = false;
		success = db.createNewAccount(model.getEmail(), model.getPassword(),
				model.getFirstName(), model.getLastName(), model.getAdmin());
		
		if (success) {
			success = db.createNewStudent(model.getYCPId(), model.getMajor(), model.getEmail());
		}
		
		
		return success;
	}
}
