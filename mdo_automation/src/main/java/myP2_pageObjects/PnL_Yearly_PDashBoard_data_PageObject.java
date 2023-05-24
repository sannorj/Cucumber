package myP2_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConstantsReader;


public class PnL_Yearly_PDashBoard_data_PageObject {

	private WebDriver driver;	
	private ConstantsReader configReader = new ConstantsReader();
	List<String> PnL_Yearly_elements , PDashBoard_elements ,  PnL_Revenue_elements , PDashBoard_Revenue_elements , PnL_Expenses_elements , PDashBoard_Expenses_elements;
	boolean flag;

		public PnL_Yearly_PDashBoard_data_PageObject(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			PnL_Yearly_elements=new ArrayList<>();
			PDashBoard_elements=new ArrayList<>();
			PnL_Revenue_elements=new ArrayList<>();
			PDashBoard_Revenue_elements =new ArrayList<>();
			PnL_Expenses_elements = new ArrayList<>();
             PDashBoard_Expenses_elements = new ArrayList<>();
		}

		@FindBy(xpath = "//table/tbody/tr/td[count(//table/thead/tr/th[.='$columnName']/preceding-sibling::th)+5]")
		List<WebElement> lstMarchValue ;

		@FindBy(xpath = "//div[@role='cell']")
		List<WebElement> listRow;

		@FindBy(xpath = "//button[@data-el='menuToggle']")
		WebElement selector;

		@FindBy(xpath = "//div[text()='Dashboard']//ancestor::li")
		WebElement dashBoard;

		@FindBy(xpath = "//a[contains(text(),'Primary Dashboard')]//ancestor::li")
		WebElement primaryDashboard;

		@FindBy(xpath = "//h1[contains(text(),'Primary Dashboard')]")
		WebElement h1PrimaryDashboard;

		@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
		WebElement txtDate;

		@FindBy(xpath = "//div//label[text() = 'Date'] //following-sibling::div//button")
		WebElement btnDatePicker;

		@FindBy(xpath = "//div[@role='dialog']")
		WebElement divCalender;

		@FindBy(xpath = "//div[@role='presentation']//button[contains(@aria-label, 'calendar view is open, switch to year view')]")
		WebElement btnExpandYear;

		@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Previous month']")
		WebElement btnPreviousMonth;

		@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Next month']")
		WebElement btnNextMonth;

		@FindBy(xpath = "//div[@data-el='appName']")
		WebElement header;

		@FindBy(xpath = "//input[@name='porfolio-group']")
		WebElement dropDownGroup;

		@FindBy(xpath = "//ul[@role='listbox']//li")
		List<WebElement> lstDropDowGroup;

		@FindBy(xpath = "//input[@name='porfolio-hotel']")
		WebElement dropDownProperty;

		@FindBy(xpath = "//ul[@role='listbox']//li")
		List<WebElement> lstDropDowProperty;

		@FindBy(xpath = "//tbody//tr[@data-el='0']//td[1]//div[text()]")
		WebElement txtRowField;


		public int getMonth() {
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);

			return month + 1;
		}

		public void validateOkCancelandClick() {
			int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

			if (btnStatus > 0) {
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
			}

		}

		public boolean selectDate() throws InterruptedException {
			boolean flag = false;
			String[] dateForPicker = configReader.getProp("PnLY_date").split("/");

			txtDate.click();

			int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();
			if (btnDatePickforLocal > 0) {
				btnDatePicker.click();
			}

			int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

			if (status == 1) {

				WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnExpandYear));
				expandYear.click();

				Thread.sleep(2500);

				WebElement pickYear = driver.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"+ dateForPicker[2] + "')]"));

				pickYear.click();
				Thread.sleep(2500);

				int monthInnum = getMonth();

				int monthDiff = monthInnum - Integer.parseInt(dateForPicker[0]);
				if (monthDiff > 0) {
					for (int i = 0; i < monthDiff; i++) {
						WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnPreviousMonth));
						btnPrevious.click();
						Thread.sleep(1500);

					}
					WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
					btnDate.click();

					validateOkCancelandClick();

					flag = true;
				}

				else if (monthDiff < 0) {
					for (int i = 0; i > monthDiff; i--) {
						WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnNextMonth));
						btnNext.click();
						Thread.sleep(1500);
					}

					WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
					btnDate.click();
					validateOkCancelandClick();

					flag = true;
				}

				else {
					WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
					btnDate.click();
					validateOkCancelandClick();

					flag = true;
				}

			} else {
				flag = false;
			}

			return flag;

		}


		public void StorePnLStaticValueFunc() throws InterruptedException {

			Thread.sleep(3500);
		    for(int x=0; x<3; x++){
		    	PnL_Yearly_elements.add(lstMarchValue.get(x).getText());
		        System.out.println(lstMarchValue.get(x).getText());
		    }
		    Thread.sleep(5000);

		}

		public void navigateToPrimaryDashBoardFunc() throws InterruptedException {

			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(selector));
			menu.click();

			WebElement dash = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(dashBoard));
			dash.click();

			WebElement trendDashboardEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(primaryDashboard));
			trendDashboardEle.click();

			Thread.sleep(5000);

		}

		/***************************** static values ************************************/
		public void selectPramsFunc() throws InterruptedException {

			ExpectedConditions.visibilityOf(header);
			selectDate();
			Thread.sleep(5000);
			ExpectedConditions.visibilityOf(txtRowField);

		}

        public void StorePrimarydashBoardStaticValueFunc() throws InterruptedException {

			Thread.sleep(3500);
		    for(int x=3; x<6; x++){
		    	PDashBoard_elements.add(listRow.get(x).getText());
		        System.out.println(listRow.get(x).getText());
		    }
		    Thread.sleep(3500);
		}

        public boolean verifyStaticKPIFunc() throws InterruptedException {
    	    if (PnL_Yearly_elements.equals(PDashBoard_elements)) {
    			flag = true;
    		} else {
    			flag = false;
    		}
    		return flag;

    	}

        /***************************** OPERATING REVENUE ************************************/
        public void StorePnLRevenueValueFunc() throws InterruptedException {

			Thread.sleep(3500);
		    for(int x=7; x<10; x++){
		    	PnL_Revenue_elements.add(lstMarchValue.get(x).getText());
		    }
		    Thread.sleep(5000);

		}

       public void StorePrimarydashBoardRevenueValueFunc() throws InterruptedException {

			Thread.sleep(3500);
		    for(int x=8; x<11; x++){
		    	PDashBoard_Revenue_elements.add(listRow.get(x).getText());
		    }
		    Thread.sleep(3500);
		}


       public boolean verifyRevenueKPIFunc() throws InterruptedException {
   	    if (PnL_Revenue_elements.equals(PDashBoard_Revenue_elements)) {
   			flag = true;
   		} else {
   			flag = false;
   		}
   		return flag;

   	}

       /***************************** DEPARTMENTAL EXPENSES ************************************/
       public void StorePnLExpensesValueFunc() throws InterruptedException {

			Thread.sleep(3500);
		    for(int x=14; x<16; x++){
		    	PnL_Expenses_elements.add(lstMarchValue.get(x).getText());
		    }
		    Thread.sleep(5000);

		}

       public void StorePrimarydashBoardExpensesValueFunc() throws InterruptedException {

			Thread.sleep(3500);
		    for(int x=12; x<14; x++){
		    	PDashBoard_Expenses_elements.add(listRow.get(x).getText());
		    }
		    Thread.sleep(3500);
		}

       public boolean verifyExpensesKPIFunc() throws InterruptedException {
      	    if (PnL_Expenses_elements.equals(PDashBoard_Expenses_elements)) {
      			flag = true;
      		} else {
      			flag = false;
      		}
      		return flag;

      	}

}
