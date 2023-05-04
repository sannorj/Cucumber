package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
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
		WebElement addChartBtn = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnAddChart']")));
		addChartBtn.click();
		Thread.sleep(2000);
		WebElement editLRSettingsModal = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h4[text()='Add Chart']")));
		
		WebElement offColumn = driver.findElement(By.xpath("//label[text()='"+configReader.getMYP1Prop("Labor_Edit_AddChart")+"']//following-sibling::div//div[@class='ios-switch on']"));
		offColumn.click();
		System.out.println("disabled column== "+configReader.getMYP1Prop("Labor_Edit_AddChart"));
		
		submitBtn.click();
		Thread.sleep(3000);
	}

	public boolean verifyCardDesable() throws InterruptedException {
		Thread.sleep(6000);
		WebElement tblLoad = new WebDriverWait(driver, Duration.ofSeconds(900)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit']")));
		try {
				int findCard = driver.findElements(By.xpath("//label[text()='"+configReader.getMYP1Prop("Labor_Edit_CloseCard")+"']")).size();
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
		WebElement addChartBtn = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnAddChart']")));
		addChartBtn.click();
		Thread.sleep(2000);
		WebElement editLRSettingsModal = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h4[text()='Add Chart']")));
		
		WebElement firstColValue = driver.findElement(By.xpath("//label[text()='"+configReader.getMYP1Prop("Labor_Edit_AddChart")+"']//following-sibling::div//div[@class=@class='ios-switch off']"));
		firstColValue.click();
		System.out.println("disabled column== "+configReader.getMYP1Prop("Labor_Edit_AddChart"));
		Thread.sleep(1000);
		submitBtn.click();
		Thread.sleep(3000);
	}

	public boolean verifyCardEnable() throws InterruptedException {
		Thread.sleep(6000);
		WebElement tblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit']")));
		try {
				int findCard = driver.findElements(By.xpath("//label[text()='"+configReader.getMYP1Prop("Labor_Edit_CloseCard")+"']")).size();
				if(findCard>0) {
					System.out.println(configReader.getMYP1Prop("Labor_Edit_CloseCard")+" is available!");
					return true;
				}
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException occoured== "+configReader.getMYP1Prop("Labor_Edit_CloseCard"));
			}
			
		return false;
	}


}
