package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.model.Account;

public class LoginController {
	private Account model;
	
	public void setModel(Account model) {
		this.model = model;
	}
	
	public boolean login() {
		return true;
	}
	
	public boolean checkPassword() {
		if(model.getPassword().equals("admin")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkEmail() {
		if(model.getEmail().equals("admin")) {
			return true;
		} else {
			return false;
		}
	}
}
