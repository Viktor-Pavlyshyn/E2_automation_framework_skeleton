package sauce.labs;

import com.epam.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.utils.DataPropLoader.getSauceLabsProperty;

public class SauceLabsDriverFactory extends WebDriverFactory {
    @Override
    protected WebDriver createDriver() {
        String sauceURL = "https://" + getSauceLabsProperty("user.name") + ":" + getSauceLabsProperty("access.key") + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(sauceURL), setCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private DesiredCapabilities setCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", getSauceLabsProperty("platform"));
        capabilities.setCapability("browserName", getSauceLabsProperty("browser.name"));
        capabilities.setCapability("version", getSauceLabsProperty("version"));
        capabilities.setCapability("name", getSauceLabsProperty("name"));
        return capabilities;
    }
}
