package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

public class ElementUtils {
	
	public static boolean waitForElementToDisplay(WebElement element,int timeOutInSeconds) throws InterruptedException{
	        boolean isDisplayed=false;
	        for(int i=0;i<timeOutInSeconds;i++){
	            try {
	                if(element.isDisplayed()){
	                   System.out.println(element.toString()+" is visible");
	                    isDisplayed=true;
	                    break;
	                }
	            }catch (NoSuchElementException exception){
	            	  System.out.println(element.toString()+" is not visible");
	            		Thread.sleep(1000);
	            }
	        }
	        return isDisplayed;
	    }
	 
	 public static boolean waitForElementToHide(WebElement element,int timeOutInSeconds) throws InterruptedException{
	        boolean isNotDisplayed=false;
	        try {
	            for (int i=0;i<timeOutInSeconds;i++){
	                if(element.isDisplayed()){
	                	  System.out.println(element.toString()+" is visible");
	                	  Thread.sleep(1000);
	                }
	            }
	        }catch (NoSuchElementException | StaleElementReferenceException exception){
	        	  System.out.println(element.toString()+" is hidden");
	            isNotDisplayed=true;
	        }
	        return isNotDisplayed;
	    }
	 
	 public static boolean waitForElementContentToDisplay(WebElement element,int timeOutInSeconds) throws InterruptedException{
	        boolean _isContentDisplayed=false;
	        for(int i=0;i<timeOutInSeconds;i++){
	            String text=element.getAttribute("value");
	            if(text==null){
	                text=element.getText();
	            }
	            if(text!=null && !text.equals("")){
	            	System.out.println(element.toString()+" is visible");
	                _isContentDisplayed=true;
	                break;
	            }else{
	            	System.out.println(element.toString()+" is not visible");
	            	 Thread.sleep(1000);
	            }
	        }
	        return _isContentDisplayed;
	    }
	

}
