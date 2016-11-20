package com.browser;

/**
 * Created by awi40 on 20/11/2016.
 */
public class browserInitialiser {
    public Boolean checkBrowser(String[] desiredBrowsers) {
        String[] validBrowsers = new String[]{"Chrome","Firefox"};
        String validBrowser;
        String desiredBrowser;
        Boolean status = null;
        for(int i = 0; i < validBrowsers.length; i++) {
            validBrowser = validBrowsers[i];
            desiredBrowser = desiredBrowsers[i];
                if (!desiredBrowser.equals(validBrowser)) {
                    status = false;
                    break;
                } else {
                    status = true;
                }
            }
            return status;
        }
    }
