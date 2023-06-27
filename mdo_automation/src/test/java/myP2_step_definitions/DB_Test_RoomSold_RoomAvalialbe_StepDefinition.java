package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.DB_Test_RoomSold_RoomAvalialbe_PageObject;

public class DB_Test_RoomSold_RoomAvalialbe_StepDefinition {

	DB_Test_RoomSold_RoomAvalialbe_PageObject DB = new DB_Test_RoomSold_RoomAvalialbe_PageObject(
			DriverFactory.getDriver());

	@When("I retrieve the rooms available data from {string} for {string} {string} {string}")
	public void I_retrieve_the_rooms_available_data(String string, String string2, String string3, String string4)
			throws InterruptedException {
		DB.selectRoomAvailableData(string, string2, string3, string4);
	}

	@When("I retrieve the rooms sold data from {string} for {string} {string} {string}")
	public void I_retrieve_the_rooms_sold_data(String string, String string2, String string3, String string4)
			throws InterruptedException {
		DB.selectRoomSoldData(string, string2, string3, string4);
	}

	@Then("I am storing the Rooms Available data")
	public void I_am_storing_the_Rooms_Available_data() {
		DB.storeRoomsAvailble();
	}

	@Then("I am storing the Rooms Sold data")
	public void I_am_storing_the_Rooms_Sold_data() {
		DB.storeRoomsSold();
	}

	@Then("I Compare the store data with DB captured value")
	public void I_Compare_the_store_data_with_DB_captured_value() {
		assertTrue(DB.verifyRoomsAvailable());
		assertTrue(DB.verifyRoomsSold());

	}

}
