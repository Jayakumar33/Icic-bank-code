import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class PageTestingInIos {


    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("deviceName", "iphone 13");
        caps.setCapability("platformVersion", "15");
        caps.setCapability("build", "PageTestingInIos");
        caps.setCapability("name", "https://www.icicibank.com/");
        caps.setCapability("visual", true);
        caps.setCapability("network", true);
        caps.setCapability("video", true);
        caps.setCapability("console", true);
        caps.setCapability("networkThrottling", "Regular 4G");
        caps.setCapability("performance", true);
//        caps.setCapability("plugin", "git-testng");
        caps.setCapability("isRealMobile", true);

//        String[] Tags = new String[] { "Feature", "Tag", "Moderate" };
//        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        driver.get("https://www.icicibank.com/");
        Thread.sleep(10000);

        Status = "passed";
        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}