package crmpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmbase.Cmrbaseclass;

public class Crm_logout  extends Cmrbaseclass{




	@FindBy(xpath="//*[@id=\"top-header-menu\"]/div[3]/div[2]/div/i")
	static 
	WebElement click;

	@FindBy(xpath="//*[text()='Log Out']")
	static
	WebElement logoutbutton;

	@FindBy(xpath="//*[text()='Login']")
	static 
	WebElement loginpage;

	public Crm_logout() {

		PageFactory.initElements(driver, this);


	}


	public static void logoutpage() throws InterruptedException {
		click.click();
		Thread.sleep(3000);
		logoutbutton.click();
		Thread.sleep(3000);
		loginpage.getText();
		Thread.sleep(3000);


	}













}
