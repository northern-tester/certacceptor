import com.browser.DriverFactory;
import com.browser.browserInitialiser;
import com.browser.browserInteractor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by awi40 on 23/11/2016.
 */
public class certAcceptorBrowserTests {

    public browserInitialiser biser;
    public URL url;
    public ArrayList<String> desiredBrowsers;
    public WebDriver driver;
    public JavascriptExecutor js;
    public String pageTitle;
    public browserInteractor bitor;


    @Before
    public void setup() throws MalformedURLException {
        biser = new browserInitialiser();
        bitor = new browserInteractor();
        desiredBrowsers = new ArrayList<String>(biser.getValidBrowsers());
        url = new URL("https", "bbc.co.uk", "/news");
        pageTitle = "Home - BBC News";
    }

    @Test
    public void instantiateOnlyChromeDriver(){
        driver = DriverFactory.getDriver(desiredBrowsers.get(0));
        driver.get(String.valueOf(url));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String userAgent = (String)js.executeScript("return navigator.userAgent;");
        Assert.assertTrue(userAgent.contains(desiredBrowsers.get(0)));
        Assert.assertTrue(driver.getTitle().equals(pageTitle));
    }

    @Test
    public void instantiateOnlyFirefoxDriver(){
        driver = DriverFactory.getDriver(desiredBrowsers.get(1));
        driver.get(String.valueOf(url));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String userAgent = (String)js.executeScript("return navigator.userAgent;");
        System.out.println(userAgent);
        Assert.assertTrue(userAgent.contains(desiredBrowsers.get(1)));
        Assert.assertTrue(driver.getTitle().equals(pageTitle));
    }

    @Test
    public void instantiateNonExistentDrivers(){
        try {
            driver = DriverFactory.getDriver("edge");
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals("The requested browser isn't in the desired list"));
        }


    }

    @Test
    public void acceptCertificatesChromeDriver() throws MalformedURLException {
        url = new URL("https", "pcwebshop.co.uk", "/");
        driver = DriverFactory.getDriver(desiredBrowsers.get(0), bitor.acceptChromeCertificates());
        driver.get(String.valueOf(url));
        Assert.assertTrue(driver.getCurrentUrl().endsWith("co.uk"));
    }

    @Test
    public void acceptCertificatesFirefoxDriver(){

    }

    @Test
    public void acknowledgeIfCertificatesOkAndContinue(){

    }

    @After
    public void teardown(){
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println(e + "- was not a selenium test");
        }
        url = null;
    }

}
