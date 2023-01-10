package myP2_pageObjects;

import java.util.Iterator;
import java.util.List;

import org.jsoup.select.Evaluator.IsEmpty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConstantsReader;

public class AR_Aging_Dashboard_DataValidation_PageObjective {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	
	public AR_Aging_Dashboard_DataValidation_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tr//td[1]//span//span[2]")
	List<WebElement> firstColValuesLst;

	public boolean verifyProperty() {
		boolean result= true;
		for (int i = 0; i < firstColValuesLst.size(); i++) {
			if(firstColValuesLst.get(i).getText().isEmpty()) {
				System.out.println(firstColValuesLst.get(i).getText());
				result= false;
			}
		}
		return result;
	}

}
