/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.java.com.uttesh.selenium.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.com.uttesh.selenium.Tests.pages.AmazonHome;

/**
 *
 * @author Rivet Systems
 */
public class UtteshJavaBlogsTest extends BaseTest{
    
    private WebDriver driver;
    private String baseUrl;

        @Parameters({ "platform","browser","version", "url" })
	@BeforeClass
	public void setUp(String platform, String browser, String version, String url) {
            driver = getRemoteWebDriver(platform,browser,version,url);
             baseUrl = "https://www.google.co.in/";
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

    @Test
    public void BlogsSearchTest() throws Exception {
        driver.get(baseUrl + "/?gws_rd=cr&ei=Nw-YUsmHOcqNrgeynoCYDg");
        driver.findElement(By.id("gbqfq")).clear();
        driver.findElement(By.id("gbqfq")).sendKeys("uttesh blogspot");
        driver.findElement(By.linkText("Uttesh Java Blogs")).click();
    }
  
   
}
