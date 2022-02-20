package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver Driver;
	private By email = By.id("user_email");
	private By sendMeInstruction=By.cssSelector("[type='submit']");
	
	public ForgotPassword(WebDriver Driver) {
		// TODO Auto-generated constructor stub
		this.Driver=Driver; 
	}

	public WebElement Email()
	{
		return Driver.findElement(email);
		
	}
	public WebElement sendMeInstruction()
	{
		return Driver.findElement(sendMeInstruction);
		
	}
}
