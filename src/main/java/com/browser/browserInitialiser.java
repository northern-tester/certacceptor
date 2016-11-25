package com.browser;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by awi40 on 20/11/2016.
 */
public class browserInitialiser {

    public ArrayList<String> validBrowsers;
    Boolean isValidStatus;

    public browserInitialiser() {
        validBrowsers = new ArrayList<String>();
        validBrowsers.add("Chrome");
        validBrowsers.add("Firefox");
    }

    public Boolean checkBrowser(ArrayList<String> desiredBrowsers) {
        if (desiredBrowsers.size() > 1) {
            isValidStatus = CollectionUtils.containsAll(validBrowsers, desiredBrowsers);
        } else if(desiredBrowsers.size() == 1) {
            isValidStatus = CollectionUtils.containsAny(validBrowsers, desiredBrowsers);
        } else {
            System.out.println(desiredBrowsers.toArray().toString()+" is invalid. Make sure to add quotes the browsers needed");
            System.exit(0);
        }
        return isValidStatus;
    }

    public ArrayList<String> getValidBrowsers() {
        return validBrowsers;
    }
}
