import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;


public class GATags {
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
        ltOptions.put("terminal", "true");
        ltOptions.put("console", "true");
        ltOptions.put("build", "GA Tags");
        ltOptions.put("name", "https://www.icicibank.com/personal-banking/logout");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        caps.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), caps);
        System.out.println("Started session");


    }

    @Test
    public void  test_Selenium_Google_Analytics() {
        String URL = "https://www.icicibank.com/";

        driver.navigate().to(URL);
        driver.manage().window().maximize();

        List<WebElement> scriptList = driver.findElements(By.tagName("script"));
        boolean scriptFound = false;
        for(WebElement item : scriptList) {
            scriptFound = item.getAttribute("src").contains("google-analytics.com/ga.js");
//            System.out.println(item.getAttribute("src").contains("google-analytics.com/ga.js"))
        }

        if (scriptFound) {

            System.out.println("This webpage contains google-analytics");

        } else {
            System.out.println("This webpage does not contains google-analytics");

        }

    }

    @AfterTest
    public void tearDown()
    {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
