package test.java.com.uttesh.selenium.Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetails {

	private WebDriver driver;

	public BookDetails(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isISBNFoundOnPage(String isbn) {
		return driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*ISBN-10: " + isbn + "[\\s\\S]*$");
	}

}
