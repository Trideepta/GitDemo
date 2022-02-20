package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver Driver;
	
	private By email = By.id("user_email");
	private By password = By.id("user_password");
	private By LogIn = By.cssSelector("input[name='commit']");
	private By forgotPassword=By.cssSelector("[href*='password/new/index.php']");
	
	
	public LoginPage(WebDriver Driver) {
		// TODO Auto-generated constructor stub
		this.Driver=Driver; 
	}

	public WebElement Email()
	{
		return Driver.findElement(email);
		
	}
	public WebElement password()
	{
		return Driver.findElement(password);
		
	}
	public WebElement Submit()
	{
		return Driver.findElement(LogIn);
		
	}
	public ForgotPassword forgotPassword()
	{
		Driver.findElement(forgotPassword).click(); 
		ForgotPassword fp=new ForgotPassword(Driver);
		return fp;
		
	}

}
