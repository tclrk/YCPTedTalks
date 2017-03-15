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
		if(model.getPassword() == "password") {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkEmail() {
		if(model.getEmail() == "email") {
			return true;
		} else {
			return false;
		}
	}
}
