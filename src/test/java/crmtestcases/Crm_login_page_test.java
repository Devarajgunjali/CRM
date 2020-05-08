package crmtestcases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmbase.Cmrbaseclass;
import crmpages.Crm_login_page;


public class Crm_login_page_test extends Cmrbaseclass{
	Crm_login_page Loginpage;
	
	public Crm_login_page_test () {
		super();
	}
	
	
	@BeforeMethod
	public void Browsersetup() {
		Broswersetup();
	 Loginpage = new Crm_login_page();
	}

	@Test
	public void Login_Successfuly() throws InterruptedException {
	
	Loginpage.loginpage(pro.getProperty("username"), pro.getProperty("passwor"));

		
	}
	
	
	@AfterMethod
	public void closed() {
		driver.quit();
	}
	

}
