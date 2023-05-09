package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class laborDashboard_Edit_PageObjects {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	public laborDashboard_Edit_PageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@title='Edit']")
	WebElement editBtn;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitBtn;
	
	public void desableCard() throws InterruptedException {
		editBtn.click();
		WebElement addChartBtn = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnAddChart']")));
		addChartBtn.click();

		Thread.sleep(3000);
		WebElement UserNameLoad = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'User Name')]//parent::div//a[@class='select2-choice']//span[text()='"+configReader.getMYP1Prop("Labor_UserName")+"']")));
		
		Thread.sleep(2000);
		WebElement editLRSettingsModal = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h4[text()='Add Chart']")));
		
		WebElement offColumn = driver.findElement(By.xpath("//label[text()='"+configReader.getMYP1Prop("Labor_Edit_AddChart")+"']//following-sibling::div//div[@class='ios-switch on']"));
		offColumn.click();
		System.out.println("disabled column== "+configReader.getMYP1Prop("Labor_Edit_AddChart"));
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", submitBtn);
			System.out.println("submit btn click");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", submitBtn);
			System.out.println("submit btn clickkkkkkkkk");
		}
		Thread.sleep(3000);
	}

	public boolean verifyCardDesable() throws InterruptedException {
		Thread.sleep(9000);
		try {
			Boolean invisibleCloseIcon = new WebDriverWait(driver, Duration.ofSeconds(900)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//header//div[@class='panel-actions']//a[@title='Close']")));
		
		} catch (NoSuchElementException e) {
			Boolean invisibleCloseIcon = new WebDriverWait(driver, Duration.ofSeconds(900)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//header//div[@class='panel-actions']//a[@title='Close']")));
		}
		System.out.println("close icon invisibled");
		
		WebElement tblLoad = new WebDriverWait(driver, Duration.ofSeconds(900)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit']")));
		System.out.println("edit button visible");
		try {
				int findCard = driver.findElements(By.xpath("//h2[text()='"+configReader.getMYP1Prop("Labor_Edit_CloseCard")+"']")).size();
				if(findCard>0) {
					System.out.println(configReader.getMYP1Prop("Labor_Edit_AddChart")+" is not disabled!");
					return false;
				}
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException occoured== "+configReader.getMYP1Prop("Labor_Edit_CloseCard"));
			}
			
		return true;
	}

	public void enableCard() throws InterruptedException {
		editBtn.click();
		Thread.sleep(3000);
		System.out.println("edit button click");
		WebElement addChartBtn = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnAddChart']")));
		addChartBtn.click();
		System.out.println("add chart btn click");
		Thread.sleep(2000);
		WebElement editLRSettingsModal = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h4[text()='Add Chart']")));
		
		WebElement UserNameLoad = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'User Name')]//parent::div//a[@class='select2-choice']//span[text()='"+configReader.getMYP1Prop("Labor_UserName")+"']")));
		
		Thread.sleep(2000);
		System.out.println("add chart view");
		
		WebElement firstColValue = driver.findElement(By.xpath("//label[text()='"+configReader.getMYP1Prop("Labor_Edit_AddChart")+"']//following-sibling::div//div[@class=@class='ios-switch off']"));
		firstColValue.click();
		System.out.println("disabled column== "+configReader.getMYP1Prop("Labor_Edit_AddChart"));
		Thread.sleep(1000);
//		submitBtn.click();
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", submitBtn);
			System.out.println("submit btn clickss");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", submitBtn);
			System.out.println("submit btn clickkkkkkkkksss");
		}
		Thread.sleep(3000);
	}

	public boolean verifyCardEnable() throws InterruptedException {
		Thread.sleep(6000);
		WebElement tblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit']")));
		Thread.sleep(3000);
		try {
			System.out.println("#####################");
				int findCard = driver.findElements(By.xpath("//h2[text()='"+configReader.getMYP1Prop("Labor_Edit_CloseCard")+"']")).size();
				if(findCard>0) {
					System.out.println(configReader.getMYP1Prop("Labor_Edit_CloseCard")+" is available!");
					return true;
				}
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException occoured== "+configReader.getMYP1Prop("Labor_Edit_CloseCard"));
			}
		System.out.println(configReader.getMYP1Prop("Labor_Edit_CloseCard")+" is not available!");
		return false;
	}


}
