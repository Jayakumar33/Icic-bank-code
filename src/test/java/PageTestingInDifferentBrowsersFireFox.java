import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class PageTestingInDifferentBrowsersFireFox {

    /*  protected static ChromeDriver driver; */
    WebDriver driver = null;

    public static String status = "passed";
    String username = "";
    String access_key = "";


    @BeforeTest
    public void testSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("browserName", "Firefox");
        ltOptions.put("browserVersion", "105.0");
        ltOptions.put("platformName", "Windows 11");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("terminal", true);
        ltOptions.put("console", true);
        ltOptions.put("build", "Page Testing in Desktop - different resolutions");
        ltOptions.put("name", "https://www.icicibank.com/");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
       ltOptions.put("resolution", "1280x800");
        caps.setCapability("performance", true);
        caps.setCapability("LT:Options", ltOptions);


        driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), caps);
        System.out.println("Started session");
    }

    @Test
    public void performanceMetrics() throws InterruptedException {
        String URL = "https://www.icicibank.com/";
        driver.navigate().to(URL);
        driver.manage().window().maximize();


        Thread.sleep(30000);


    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}