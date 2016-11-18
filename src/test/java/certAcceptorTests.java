import com.url.urlProcessor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void checkReturnedArrayofURLs(){
        //Declare an array to check against
        ArrayList<String> expectedData = new ArrayList<String>();
        expectedData.add("https://www.google.co.uk");
        expectedData.add("https://www.bbc.co.uk");
        //Get an array of urls needed back
        ArrayList<String> actualData = new ArrayList<String>();
        actualData = urls.getProcessedList();
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
