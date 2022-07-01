package hooks;

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
	public void setup() {
		String browserJenkin = System.getProperty("browserName");
		String browserName = prop.getProperty("browser");
		System.out.println("browserJenkin : " + browserJenkin);
		System.out.println("browserName : " + browserName);
		driverFactory = new DriverFactory();
		if(browserJenkin != null) {
			driver = driverFactory.setDriverJenkin(browserJenkin);
		}else {
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
