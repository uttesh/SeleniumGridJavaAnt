package test.java.com.uttesh.selenium.Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonBookSearch {
	
	private WebDriver driver;

    public AmazonBookSearch(WebDriver driver) {
        this.driver = driver;
    }
    
    public BookDetails clickOnBookLink() {
    	driver.findElement(By.cssSelector("span.lrg.bold")).click();
    	
    	return new BookDetails(driver);
    }


}
