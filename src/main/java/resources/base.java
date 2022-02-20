package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.*;

public class base {
	
	public WebDriver Driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);//load the data.properties file in reading mode
		
		//we will provide the browser info in cmd prompt:: mvn Test -Dbrowser=chrome
		
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if (browserName.contains("headless"))
					{
					options.addArguments("headless");
					Driver=new ChromeDriver(options);
					}	
			else
			Driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			Driver=new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D://IEDriverServer.exe");
			Driver=new InternetExplorerDriver();
		}
		
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return Driver;
		
	}
	public String getScreenShotPath(String testCaseName, WebDriver Driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) Driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destFile));
		return destFile;
	}
	
}
