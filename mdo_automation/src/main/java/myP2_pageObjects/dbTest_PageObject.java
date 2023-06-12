package myP2_pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import dbConnection.*;
import utils.ConstantsReader;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbTest_PageObject {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	private Statement st;
	private ResultSet rs;
	private ResultSet rs1;
	String Actual, Base;
	SimpleDateFormat sdf;

	public dbTest_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public void selectActualData(String table, String glCode, String date, String hotelId, String hre) {
		try {

			String query = "SELECT sum_amount FROM calculation_mdo_gl_code_actual where hotel_id = '" + hotelId
					+ "' and date = '" + date + "' and mdo_gl_code ='" + glCode + "' and hre_type_id ='" + hre + "' ";
			System.out.println("Query : " + query);
			st = DBConnection.getConnection().createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				System.out.println("Actual data  : " + rs.getString("sum_amount"));
				Actual = rs.getString("sum_amount");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectBaseData(String table, String kpi, String date, String hotelId, String hre) {
		try {

			String query = "SELECT amount_current FROM calculation_kpi_actual_periods_2021 where hotel_id = '" + hotelId
					+ "' and date = '" + date + "'  and kpi_name ='" + kpi + "' and hre_type_id ='" + hre + "' ";
			System.out.println("Query : " + query);
			st = DBConnection.getConnection().createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				System.out.println("Base data  : " + rs.getString("amount_current"));
				Base = rs.getString("amount_current");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean compareActualAndBaseValue() {
		boolean result = false;

		System.out.println("==============================");
		System.out.println("= Actual Data Value  : " + Actual + " =");
		System.out.println("==============================");
		System.out.println("= Base Data Value    : " + Base + " =");
		System.out.println("==============================");

		if (Double.parseDouble(Actual) == Double.parseDouble(Base)) {
			result = true;
		}

		return result;
	}
}
