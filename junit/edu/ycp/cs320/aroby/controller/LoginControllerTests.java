package edu.ycp.cs320.aroby.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.controller.GuessingGameController;
import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.GuessingGame;

public class LoginControllerTests {
	private Account model;
	private LoginController controller;
	
	@Before
	public void setUp() {
		model = new Account();
		controller = new LoginController();
		
		model.setEmail("email");
		model.setPassword("password");
		
		controller.setModel(model);
	}
	
	@Test
	public void TestLogin() {
		assertTrue(controller.login());
	}
	
	public void TestCheckPassword() {
		assertTrue(controller.checkPassword());
	}
	
	public void TestCheckEmail() {
		assertTrue(controller.checkEmail());
	}
}
