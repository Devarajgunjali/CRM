package crmpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import crmbase.Cmrbaseclass;

public  class Crm_login_page extends Cmrbaseclass {



	@FindBy(name="email")
	static
	WebElement username;

	@FindBy(name="password")
	static
	WebElement password;

	@FindBy(xpath="//div[text()='Login']")
	static
	WebElement loginbutton;
	@FindBy(xpath="//a[text()='Free account']")
	static 
	WebElement account;





	public Crm_login_page() {
		PageFactory.initElements(driver, this);
	}
	public static  void account() throws InterruptedException {

		String accountName=	account.getText();
		Thread.sleep(3000);
		System.out.println(accountName);
		Thread.sleep(3000);
		Assert.assertEquals(accountName, "Free account");
		Thread.sleep(3000);
	}

	public static homepage loginpage(String user,String pass) throws InterruptedException {
		username.sendKeys(user);
		Thread.sleep(3000);
		password.sendKeys(pass);
		Thread.sleep(3000);
		loginbutton.click();
		Thread.sleep(3000);


		return new homepage();
	}
}
