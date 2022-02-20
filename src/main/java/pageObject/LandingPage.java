package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver Driver;
	
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By title=By.xpath("//div[@class='text-center']/h2");
	private By navBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By Header=By.cssSelector("div[class*='video-banner'] h3");
	private By popup=By.xpath("//button[text()='NO THANKS']");
	
	
	public LandingPage(WebDriver Driver) {
		// TODO Auto-generated constructor stub
		this.Driver=Driver; 
	}



	public LoginPage getLogin()
	{
		Driver.findElement(signIn).click();
		LoginPage ln=new LoginPage(Driver);
		return ln;
		
	}
	public WebElement getTitle()
	{
		return Driver.findElement(title);
		
	}
	public WebElement getNavigationBar()
	{
		return Driver.findElement(navBar);
		
	}
	public WebElement getHeader()
	{
		return Driver.findElement(Header);
		
	}
	public List<WebElement> getpopupsize()
	{
		return Driver.findElements(popup);
		
	}
	public WebElement getpopup()
	{
		return Driver.findElement(popup);
		
	}

}
