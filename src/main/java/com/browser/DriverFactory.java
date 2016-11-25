package com.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by awi40 on 25/11/2016.
 */
public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver getDriver(String desiredBrowser) {
        String s = desiredBrowser.toLowerCase();
        if (s.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
            driver = new ChromeDriver();
        } else if(s.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
            driver = new FirefoxDriver();
        } else {
            new Exception("The requested browser isn't in the desired list");
        }
        return driver;
    }
}
