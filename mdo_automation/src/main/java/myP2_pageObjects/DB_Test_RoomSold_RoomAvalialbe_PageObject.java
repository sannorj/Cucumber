package myP2_pageObjects;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dbConnection.DBConnection;
import utils.ConstantsReader;

public class DB_Test_RoomSold_RoomAvalialbe_PageObject {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	private Statement st;
	private ResultSet rs;
	ArrayList<Integer> roomAvailable, roomsSold;
	int arRoomAvailable[], arRoomsSold[];

	public DB_Test_RoomSold_RoomAvalialbe_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		roomAvailable = new ArrayList<>();
		roomsSold = new ArrayList<>();

	}

	@FindBy(xpath = "//div[@data-el='data-container-1']//tbody//tr[1]//td")
	List<WebElement> lstRoomAvailable;

	@FindBy(xpath = "//div[@data-el='data-container-1']//tbody//tr[2]//td")
	List<WebElement> lstRoomSold;

	public void selectRoomAvailableData(String table, String startDate, String endDate, String hotelId) {
		try {

			String query = "SELECT EXTRACT(year from date) AS year, EXTRACT(month from date) AS month,sum(rooms_available) AS rooms_available FROM  "
					+ table + " where removed_at IS NULL AND hotel_id = '" + hotelId + "' and date >= '" + startDate
					+ "' and date <= '" + endDate
					+ "' GROUP BY EXTRACT(year from date),EXTRACT(month from date) ORDER BY  year ASC,month ASC";

			System.out.println("Query : " + query);
			st = DBConnection.getConnection().createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				int result = rs.getInt("rooms_available");
				System.out.println("Rooms Available : " + result);

				roomAvailable.add(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRoomSoldData(String table, String startDate, String endDate, String hotelId) {
		try {

			String query = "SELECT EXTRACT(year from date) AS year, EXTRACT(month from date) AS month,sum(rooms_sold) AS rooms_sold FROM  "
					+ table + " where removed_at IS NULL AND hotel_id = '" + hotelId + "' and date >= '" + startDate
					+ "' and date <= '" + endDate
					+ "' GROUP BY EXTRACT(year from date),EXTRACT(month from date) ORDER BY  year ASC,month ASC";

			System.out.println("Query : " + query);
			st = DBConnection.getConnection().createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				int result = rs.getInt("rooms_sold");
				System.out.println("Rooms Sold : " + result);

				roomsSold.add(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void storeRoomsAvailble() {
		arRoomAvailable = new int[lstRoomAvailable.size() - 5];

		for (int i = 0; i < lstRoomAvailable.size() - 5; i++) {
			arRoomAvailable[i] = Integer
					.parseInt(lstRoomAvailable.get(i + 2).getText().replaceAll(",", "").replaceAll("\\$", ""));
		}
	}

	public void storeRoomsSold() {
		arRoomsSold = new int[lstRoomSold.size() - 5];

		for (int i = 0; i < lstRoomSold.size() - 5; i++) {
			arRoomsSold[i] = Integer
					.parseInt(lstRoomSold.get(i + 2).getText().replaceAll(",", "").replaceAll("\\$", ""));
		}
	}

	public boolean verifyRoomsSold() {
		boolean result = false;

		if (roomsSold.size() == arRoomsSold.length) {
			for (int i = 0; i < arRoomsSold.length; i++) {

				if (roomsSold.get(i) == arRoomsSold[i]) {
					System.out.println("Rooms Sold : " + roomsSold.get(i) + " -- " + arRoomsSold[i]);
					result = true;
				} else {
					result = false;
					break;
				}

			}
		}

		return result;
	}

	public boolean verifyRoomsAvailable() {
		boolean result = false;
		
		if (roomAvailable.size() == arRoomAvailable.length) {
			for (int i = 0; i < arRoomAvailable.length; i++) {

				if (roomAvailable.get(i) == arRoomAvailable[i]) {
					System.out.println("Rooms Available : " + roomAvailable.get(i) + " -- " + arRoomAvailable[i]);
					result = true;
				} else {
					result = false;
					break;
				}

			}
		}

		return result;
	}

	public void printResult() {
		// DB room available
		for (int i = 0; i < roomAvailable.size(); i++) {

			System.out.println("Rooms Available DB Value: " + i + 1 + " : " + roomAvailable.get(i));
		}

		// DB Room sold
		for (int i = 0; i < roomsSold.size(); i++) {

			System.out.println("Rooms Sold DB Value: " + i + 1 + " : " + roomsSold.get(i));
		}

		// PnL Yeary RoomSold
		for (int i = 0; i < arRoomsSold.length; i++) {

			System.out.println("Rooms Sold PnL Yearly Value: " + i + 1 + " : " + arRoomsSold[i]);

		}

		// PnL Yearly RoomAvailable
		for (int i = 0; i < arRoomAvailable.length; i++) {

			System.out.println("Rooms Available PnL Yearly Value: " + i + 1 + " : " + arRoomAvailable[i]);

		}

	}

}// =======================================================================================================================================
