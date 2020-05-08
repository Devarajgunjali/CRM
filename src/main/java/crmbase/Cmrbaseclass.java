package crmbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Utility.Testutil;

public class Cmrbaseclass {
	public static Properties pro;
	public static WebDriver driver;


	public Cmrbaseclass() {
		String filepath =System.getProperty("user.dir");

		pro = new Properties();
		try {


			FileInputStream file = new FileInputStream(filepath+"//src/main/java/crmconfig/crm.properties");

			pro.load(file);
		}catch (Exception exp) {
			exp.getMessage();
		}
	}




	public static void Broswersetup() {
		String browser=	pro.getProperty("browserName");
		String driverpath=System.getProperty("user.dir");
		//System.out.println(driverpath);

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",driverpath+"//drivers/chromedriver/chromedriver.exe" );
			driver=new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",driverpath+"//drivers/geckodriver/geckodriver.exe");
			driver= new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdrive.ie.driver", driverpath+"//drivers/iedriver/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else {
			System.out.println("no drivers are found in this project");
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICT_WAIT_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
	}


}
