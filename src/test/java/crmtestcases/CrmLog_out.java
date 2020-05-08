package crmtestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmbase.Cmrbaseclass;
import crmpages.Crm_login_page;
import crmpages.Crm_logout;

public class CrmLog_out extends Cmrbaseclass {
	
	Crm_login_page Loginpage;
	Crm_logout logout;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		Broswersetup();
		
		Loginpage = new Crm_login_page();
		logout= new Crm_logout();
		Loginpage.loginpage(pro.getProperty("username"), pro.getProperty("passwor"));
		
	}
	
	@Test
	public void logout() throws InterruptedException {
		logout.logoutpage();
	//String str=	driver.getCurrentUrl();
	
	//Assert.assertEquals(str,"https://ui.cogmento.com/");
	}

	
	@AfterMethod
	public void close() {
		//driver.quit();
	}
}
