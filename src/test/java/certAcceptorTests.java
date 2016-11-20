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
public class certAcceptorTests {

    public urlProcessor urls;

    String validFilename;
    String validBrowser;
    String anotherValidBrowser;

    @Before
    public void setup(){
        validFilename = System.getProperty("user.dir")+"/urls.txt";
        validBrowser = "Chrome";
        anotherValidBrowser = "Firefox";
        urls = new urlProcessor(validFilename);
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

    }

    @Test
    public void moreThanOneValidBrowser(){

    }

    @After
    public void teardown(){

    }



}
