package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.propertyDashboard_WeatherForecastOTAinsight_PageObjects;

public class propertyDashboard_WeatherForecastOTAinsight_StepDefinition {

	propertyDashboard_WeatherForecastOTAinsight_PageObjects dashboardWeatherForecastOTAinsightPo = new propertyDashboard_WeatherForecastOTAinsight_PageObjects(
			DriverFactory.getDriver());

	@Given("Verify Weather Forecast loaded according to celsius")
	public void verify_weather_forecast_loaded_according_to_celsius() throws InterruptedException {
		assertTrue(dashboardWeatherForecastOTAinsightPo.IsWeatherForecastLoadedInCelsius());
	}

	@And("Verify Weather Forecast loaded according to fahrenheit")
	public void verify_weather_forecast_loaded_according_to_fahrenheit() throws InterruptedException {
		assertTrue(dashboardWeatherForecastOTAinsightPo.IsWeatherForecastLoadedInFahrenheit());
	}

	@When("Check OTA Insight Table is loaded")
	public void check_ota_insight_table_is_loaded() throws InterruptedException {
		assertTrue(dashboardWeatherForecastOTAinsightPo.isOTAInsightTblLoaded());
	}

	@Then("Check OTA Insight Chart is loaded")
	public void check_ota_insight_chart_is_loaded() throws InterruptedException {
		assertTrue(dashboardWeatherForecastOTAinsightPo.isOTAInsightChartLoaded());
	}

	@And("Click on OTA Insight Go To Details link")
	public void click_on_ota_insight_go_to_details_link() {
		dashboardWeatherForecastOTAinsightPo.clickOTAinsightgotoDetails();
	}

	@When("I navigate to OTA Insight Page")
	public void i_navigate_to_ota_insight_page() {
		assertTrue(dashboardWeatherForecastOTAinsightPo.OTAinsightDisplayed());
	}

}
