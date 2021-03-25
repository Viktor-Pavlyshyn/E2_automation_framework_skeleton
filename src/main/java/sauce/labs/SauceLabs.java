package sauce.labs;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabs {
    private final String SAUCE_USERNAME = "Vikrot_Pavlyshyn";
    private final String SAUCE_ACCESS_KEY = "fc7686ea-ba5f-4733-bffb-ec279095ded4";

    public RemoteWebDriver createSauceLabs(){
        String sauceURL = "https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
        RemoteWebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "WIN10");
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("version","latest");
        capabilities.setCapability("name","SauceLabsTest");

        try {
            driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
