package StepDefination;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

@RunWith(Cucumber.class)
public class MyStepDefinitions extends base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	Driver=initializeDriver();
    }
    
    @Given("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	Driver.get(strArg1);
    }
    
    @Given("^Click on Login link in home page to land on secure sign in page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    	LandingPage lp=new LandingPage(Driver);
    	if(lp.getpopupsize().size()>0)
    	{
    		lp.getpopup().click();
    	}
		lp.getLogin();
    }

    @When("^User enters (.+) and (.+) and clicks on login button$")
    public void user_enters_and_and_clicks_on_login_button(String username, String password) throws Throwable {
    	LoginPage ln=new LoginPage(Driver);
    	ln.Email().sendKeys(username);
		ln.password().sendKeys(password);
		ln.Submit().click();
    }

    @Then("^Verify the user is successfully logged in$")
    public void verify_the_user_is_successfully_logged_in() throws Throwable {
        System.out.println("Successfully logged in");
        Driver.quit();
    }

}