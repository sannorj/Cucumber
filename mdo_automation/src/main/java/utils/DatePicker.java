package utils;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {
	private  WebDriver driver;
	boolean flag;

	public DatePicker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;
	
	@FindBy(xpath = "//div//label[text() = 'Date'] //following-sibling::div//button")
	WebElement btnDatePicker;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement divCalender;

	@FindBy(xpath = "//div[@role='presentation']//button")
	WebElement btnExpandYear;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Previous month']")
	WebElement btnPreviousMonth;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Next month']")
	WebElement btnNextMonth;

	public int getMonth() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);

		return month + 1;
	}

	public boolean selectDateFromPicker(String date) throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = date.split("/");
		
		txtDate.click();
		
		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {
			
			int sizeOfPicker = driver
					.findElements(By.xpath("//div[@role='presentation']//button[contains(@aria-label, 'calendar view is open, switch to year view')]")).size();
			
			System.out.println("Size of"+sizeOfPicker);
			
			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();

			Thread.sleep(2500);

			WebElement pickYear = driver
					.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"
							+ dateForPicker[2] + "')]"));

			pickYear.click();
			
			Thread.sleep(2500);

			int monthInnum = getMonth();

			int monthDiff = monthInnum - Integer.parseInt(dateForPicker[0]);

			if (monthDiff > 0) {
				for (int i = 0; i < monthDiff; i++) {
					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnPreviousMonth));

					btnPrevious.click();
					Thread.sleep(1500);

				}
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='cell']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();
				
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
				
				flag = true;
			}

			else if (monthDiff < 0) {
				for (int i = 0; i > monthDiff; i--) {
					WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnNextMonth));

					btnNext.click();
					Thread.sleep(1500);

				}
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='cell']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();
				
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
				
				flag = true;
			}

			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='cell']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();
			
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
				
				flag = true;
			}

		} else {
			flag = false;
		}

		return flag;

	}
}
