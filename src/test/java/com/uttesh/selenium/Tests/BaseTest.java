/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.java.com.uttesh.selenium.Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author Rivet Systems
 */
public class BaseTest {
    
    private WebDriver driver;
    
    public WebDriver getRemoteWebDriver(String platform, String browser, String version, String url){
            try {
                DesiredCapabilities capability = new DesiredCapabilities();
                if(platform.equalsIgnoreCase("Windows")){
                    capability.setPlatform(Platform.WINDOWS);
                }
                if(platform.equalsIgnoreCase("Linux")){
                    capability.setPlatform(Platform.LINUX);
                }
                
                if (browser.equalsIgnoreCase("Internet Explorer")) {
                    capability = DesiredCapabilities.internetExplorer();
                }
                if (browser.equalsIgnoreCase("Firefox")) {
                    capability = DesiredCapabilities.firefox();
                }
                capability.setVersion(version);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
                return driver;
            }catch (MalformedURLException ex) {
                Logger.getLogger(AmazonTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
}
