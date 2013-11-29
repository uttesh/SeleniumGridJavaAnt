package test.java.com.uttesh.selenium.Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHome {
	
	 private WebDriver driver;

    public AmazonHome(WebDriver driver) {
        this.driver = driver;
        String baseUrl = "http://www.amazon.com";
        driver.get(baseUrl + "/");
    }


    public AmazonBookSearch searchFor(String searchString) {
 
		WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
		searchField.click();
		searchField.sendKeys(searchString);
		
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();

    	return new AmazonBookSearch(driver);
    }
    
}
