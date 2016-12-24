package com.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

/**
 * Created by awi40 on 25/11/2016.
 */
public class DriverFactory {

    public static WebDriver driver;
    public static FirefoxProfile profile;
    public static ProfilesIni profilesIni;

    public static WebDriver getDriver(String desiredBrowser) {
        String s = desiredBrowser.toLowerCase();
        if (s.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
            driver = new ChromeDriver(desiredCapabilities);
        } else if(s.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
            profile = new FirefoxProfile();
            profilesIni = new ProfilesIni();
            profile = profilesIni.getProfile("default");
            profile.setAcceptUntrustedCertificates(true);
            driver = new FirefoxDriver(profile);
        } else {
            new Exception("The requested browser isn't in the desired list");
        }
        return driver;
    }
}
