package Academy.E2EProject;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.LandingPage;
import resources.base; 	

public class ValidateTitle extends base{
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver Driver;
	LandingPage lp;
	@BeforeTest
	public void initialize() throws IOException
	{
		Driver=initializeDriver();
		log.info("Driver is initialized");
		Driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	@Test
	public void validateAppTitle() throws IOException
	{
		Driver=initializeDriver();
		Driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(Driver);
		//compare the text from the browser with actual text
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("title is displayed");
		System.out.println("Github updates");
		
	}	
	
	@Test
	public void validateHeader() throws IOException
	{
		//compare the text from the browser with actual text
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("title is displayed");
		
	}
	@AfterTest
	public void tearDown()
	{
		Driver.close();
	}
	
}
