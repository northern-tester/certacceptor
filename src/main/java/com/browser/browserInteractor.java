package com.browser;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by awi40 on 29/11/2016.
 */
public class browserInteractor {
    public int isAccepted() {

        return 0;
    }

    public DesiredCapabilities acceptChromeCertificates(String s) {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return capability;
    }
}
