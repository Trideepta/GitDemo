package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base; 	

public class HomePage extends base{
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver Driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		Driver=initializeDriver();
		log.info("Driver is initialized");
		Driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName, String password, String text) throws IOException
	{
		Driver=initializeDriver();
		Driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(Driver);
		LoginPage ln=lp.getLogin();
		ln.Email().sendKeys(userName);
		ln.password().sendKeys(password);
		log.info(text);
		System.out.println(text);
		ln.Submit().click();
		
		ForgotPassword fp=ln.forgotPassword();
		fp.Email().sendKeys("poiuy");
		fp.sendMeInstruction().click();
		
	}
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		//column stands for how many values for each test
		Object[][] data= new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]="Non Restricted User";
		
		return data;
		
	}
	@AfterTest
	public void tearDown()
	{
		Driver.close();
	}
	
}
