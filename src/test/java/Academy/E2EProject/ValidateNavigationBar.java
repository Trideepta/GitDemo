package Academy.E2EProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.LandingPage;
import resources.base; 	

//aDDING lOGS
//generating html reports
//screenshots on failures
//jenkins integration


public class ValidateNavigationBar extends base{

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
	@Test
	public void basePageNavigation() throws IOException
	{
		LandingPage lp=new LandingPage(Driver);
		//compare the text from the browser with actual text
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Successfully validated navigation bar");
		
		
	}	
	@AfterTest
	public void tearDown()
	{
		Driver.close();
	}
	
}
