import com.browser.browserInitialiser;
import com.url.urlProcessor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by awi40 on 16/11/2016.
 */
public class certAcceptorConfigTests {

    public urlProcessor urls;
    public browserInitialiser bi;

    String validFilename;
    String validBrowser;
    String anotherValidBrowser;

    @Before
    public void setup(){
        validFilename = System.getProperty("user.dir")+"/urls.txt";
        validBrowser = "Chrome";
        anotherValidBrowser = "Firefox";
        urls = new urlProcessor(validFilename);
        bi = new browserInitialiser();
    }

    @Test
    public void passAValidFileName(){
        //pass a valid url file and use a getter to confirm within the object
        String confirmedFileName = urls.getFileName();
        System.out.println(validFilename);
        System.out.println(confirmedFileName);
        Assert.assertEquals("Filename matches "+validFilename, validFilename, confirmedFileName);
    }

    @Test
    public void checkReturnedArrayofURLs() throws MalformedURLException {
        //Declare an array to check against
        ArrayList<URL> expectedData = new ArrayList<URL>();
        expectedData.add(new URL("https://www.google.co.uk"));
        expectedData.add(new URL("https://www.bbc.co.uk"));
        //Get an array of urls needed back
        ArrayList<URL> actualData = new ArrayList<URL>();
        try {
            actualData = urls.getProcessedList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Assert against those arrays
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void passAValidBrowser(){
        //Check that the browser I wish to use is valid
        ArrayList<String> desiredBrowsers = new ArrayList<String>();
        desiredBrowsers.add(validBrowser);
        Boolean isBrowserValid = bi.checkBrowser(desiredBrowsers);
        Assert.assertTrue(isBrowserValid);
    }

    @Test
    public void passAnInvalidBrowser(){
        ArrayList<String> desiredBrowsers = new ArrayList<String>();
        desiredBrowsers.add(validBrowser+"blah");
        Boolean isBrowserValid = bi.checkBrowser(desiredBrowsers);
        Assert.assertFalse(isBrowserValid);
    }

    @Test
    public void moreThanOneValidBrowser(){
        ArrayList<String> desiredBrowsers = new ArrayList<String>();
        desiredBrowsers.add(validBrowser);
        desiredBrowsers.add(anotherValidBrowser);
        Boolean areBrowsersValid = bi.checkBrowser(desiredBrowsers);
        Assert.assertTrue(areBrowsersValid);
    }

    @Test
    public void requestBrowsersInAnyOrder(){
        ArrayList<String> desiredBrowsers = new ArrayList<String>();
        desiredBrowsers.add(anotherValidBrowser);
        desiredBrowsers.add(validBrowser);
        Boolean areBrowsersValid = bi.checkBrowser(desiredBrowsers);
        Assert.assertTrue(areBrowsersValid);
    }

    @After
    public void teardown(){
        validBrowser = null;
        anotherValidBrowser = null;
        validFilename = null;
    }



}
