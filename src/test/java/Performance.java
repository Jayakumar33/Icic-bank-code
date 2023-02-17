import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Performance {
    /*  protected static ChromeDriver driver; */
    WebDriver driver = null;

    public static String status = "passed";
    String username = "";
    String access_key = "";





    @BeforeTest
    public void testSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions browserOptions = new ChromeOptions();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("browserName", "Chrome");
        ltOptions.put("browserVersion", "105.0");
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("terminal", true);
        ltOptions.put("console", true);
        ltOptions.put("build", "Performance metrics");
        ltOptions.put("name", "https://www.icicibank.com/offers/nearby-offers?");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        ltOptions.put("performance", true);
        caps.setCapability("LT:Options", ltOptions);


        driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), caps);
        System.out.println("Started session");
    }

    @Test
    public void performanceMetrics() throws InterruptedException {
        String URL = "https://www.icicibank.com/offers/nearby-offers?";
        driver.navigate().to(URL);
        driver.manage().window().maximize();


        Thread.sleep(60000);



    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}