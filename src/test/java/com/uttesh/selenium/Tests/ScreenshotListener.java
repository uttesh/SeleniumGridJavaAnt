package test.java.com.uttesh.selenium.Tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ScreenshotListener extends TestListenerAdapter {
    
    private WebDriver driver;

  @Override
  public void onTestFailure(ITestResult tr) {
    File screenshot = new File("screenshots" + File.separator + System.currentTimeMillis() + "_" + tr.getName() + ".png");
    if (!screenshot.exists()) {
      new File(screenshot.getParent()).mkdirs();
      try {
        screenshot.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      new FileOutputStream(screenshot).write(((TakesScreenshot) getRemoteWebDriver()).getScreenshotAs(OutputType.BYTES));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
          private WebDriver getRemoteWebDriver(){
            try {
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
                return driver;
            }catch (MalformedURLException ex) {
                Logger.getLogger(AmazonTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
}

