package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import myP2_pageObjects.Login_PageObject;

public class Login_StepDefinition {

	private Login_PageObject loginPO = new Login_PageObject(DriverFactory.getDriver());
	
	@Given("I am login to the myp2 site")
	public void i_am_login_to_the_myp2_site() throws InterruptedException {
		loginPO.launchURLAndLogin();
	}

	@And("System navigate to the home page")
	public void system_navigate_to_the_home_page() throws InterruptedException {
		assertTrue(loginPO.navigateHomePage());
	}
}
