package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import myP1_pageObjects.myP1_LoginPage_Objects;

public class myP1_Login_StepDefinition {
	private myP1_LoginPage_Objects loginPO = new myP1_LoginPage_Objects(DriverFactory.getDriver());
	
	@Given("I am login to the myp1 site")
	public void i_am_login_to_the_myp1_site() throws InterruptedException {
		loginPO.launchURLAndLogin();
	}
	
	@And("System navigate to the dashboard")
	public void system_navigate_to_the_dashboard() {
		assertTrue(loginPO.navigateHomePage());
	}

	
}
