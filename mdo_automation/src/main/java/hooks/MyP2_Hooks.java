package hooks;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyP2_Hooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty(){
		configReader = new ConfigReader();
		prop = configReader.readProperties();
	}
	
	@Before(order=1)
	public void setup() throws MalformedURLException {

		String browserJenkin = System.getProperty("browserName");
		String browserName = prop.getProperty("browser");
		String status = prop.getProperty("docker");
	   // boolean dockerJenkin = Boolean.getBoolean("dockerStatus");
		String dockerJenkin =  System.getProperty("dockerStatus");
		
		System.out.println("browserJenkin : " + browserJenkin);
		System.out.println("browserName : " + browserName);
		System.out.println("dockerJenkin : " + dockerJenkin);
		System.out.println("status : " + status);

		driverFactory = new DriverFactory();

		if (browserJenkin != null && dockerJenkin.equals("true") ) {
		    driver = driverFactory.setDriverDockerJenkin(browserName);
		} 
		else if (browserJenkin != null && dockerJenkin.equals("false")) {
		    driver = driverFactory.setDriverJenkin(browserJenkin);
		} 
		else if (status.equals("true")) {
		    driver = driverFactory.setDriverDockerLocal(browserName);
		} 
		else {
		    driver = driverFactory.setDriverLocal(browserName);
		}
	}
	
	
	
	
	@After(order=0)
	public void after() {
		driver.close();
	}
	
	@After(order=1)
	public void tearDown(Scenario sc) {
		if(sc.isFailed()) {
			String screenshotName = sc.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png", screenshotName);
		}
	}

}
